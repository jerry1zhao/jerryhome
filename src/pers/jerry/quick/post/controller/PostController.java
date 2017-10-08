// Copyright (c) 2017 Jerry Home. All rights reserved.
// CHANGE LOG
// 2017-XX-XX, jerry.zhao, creation
// ============================================================================

/**
 * @author jerry.zhao
 *
 */
package pers.jerry.quick.post.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import pers.jerry.jerryhome.common.controller.BaseController;
import pers.jerry.quick.jedis.JedisUtil;
import pers.jerry.quick.post.domain.Post;
import pers.jerry.quick.post.domain.PostConstants;
import pers.jerry.quick.post.domain.PostLike;
import pers.jerry.quick.post.service.PostService;
import pers.jerry.quick.user.domain.User;
import pers.jerry.quick.util.ActionHelper;
import pers.jerry.quick.util.QiniuUtils;
import pers.jerry.quick.util.UserUtils;
import pers.jerry.quick.util.ValidationUtils;

@Controller
public class PostController extends BaseController {
    private static final Logger logger = Logger.getLogger(PostController.class);
    private static final String UPLOAD_PATH = "post/";

    @Autowired
    private PostService postService;
    private final Map<String, Object> map = new HashMap<String, Object>();

    @RequestMapping(value = {"/", "/posts" }, method = RequestMethod.GET)
    public String getPosts(ModelMap modelMap) {
        final List<Post> posts = postService.getPosts();
        final List<Map<Object, Object>> hotPosts = postService.hotPosts();
        modelMap.put("posts", posts);
        modelMap.put("hotPosts", hotPosts);
        return INDEX;
    }

    @RequestMapping(value = "post/editor", method = RequestMethod.GET)
    public String goPostEditor() {
        return "post/postEditor";
    }

    @RequestMapping(value = "post/savePost", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> savePost(MultipartHttpServletRequest request) throws IOException {
    	String postMarkDown = request.getParameter(PostConstants.POST_CONTENT_MARKDOWN);
    	String postHtml = request.getParameter(PostConstants.POST_CONTENT_HTML);
    	Map<String, String> result = ActionHelper.postContentImgHandle(postMarkDown, postHtml);
        final Post post = new Post();
        post.setTitle(request.getParameter(PostConstants.TITLE));
        post.setSubject(request.getParameter(PostConstants.SUBJECT));
        post.setDescription(request.getParameter(PostConstants.DESCRIPTION));
        post.setTags(request.getParameter(PostConstants.TAGS));
        post.setCreateUser((User) request.getSession().getAttribute(User.USER));
        post.setCreateDate(new Timestamp(System.currentTimeMillis()));
        post.setStatus(PostConstants.DRAFT);
        post.setMarkdownContent(result.get(PostConstants.POST_CONTENT_MARKDOWN));
        post.setHtmlContent(result.get(PostConstants.POST_CONTENT_HTML));

        final MultipartFile postImage = request.getFile("postImage");
        if (postImage != null) {
            final Map<String, String> uploadResult = QiniuUtils.upload(postImage.getBytes(), UPLOAD_PATH);
            final String postImagePath = QiniuUtils.domain + uploadResult.get("path");
            post.setPostImage(postImagePath);
        }

        if (ValidationUtils.checkPostForm(post)) {
            postService.savePost(post);
            map.put("state", "success");
            map.put("postId", post.getId());
        } else {
            map.put("state", "failed");
            map.put("postId", post.getId());
        }
        return map;
    }
    
    @RequestMapping(value = "post/updatePost", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updatePost(MultipartHttpServletRequest request) throws IOException {
        final Post post = new Post();
        post.setId(Integer.valueOf(request.getParameter(PostConstants.POST_ID)));
        post.setTitle(request.getParameter(PostConstants.TITLE));
        post.setSubject(request.getParameter(PostConstants.SUBJECT));
        post.setDescription(request.getParameter(PostConstants.DESCRIPTION));
        post.setTags(request.getParameter(PostConstants.TAGS));
        post.setStatus(PostConstants.DRAFT);
        post.setHtmlContent(request.getParameter(PostConstants.POST_CONTENT_HTML));
        post.setMarkdownContent(request.getParameter(PostConstants.POST_CONTENT_MARKDOWN));

        final MultipartFile postImage = request.getFile("postImage");
        if (postImage != null) {
            final Map<String, String> uploadResult = QiniuUtils.upload(postImage.getBytes(), UPLOAD_PATH);
            final String postImagePath = QiniuUtils.domain + uploadResult.get("path");
            post.setPostImage(postImagePath);
        }

        if (ValidationUtils.checkPostFormByUpdate(post)) {
            postService.updatePost(post);
            map.put("state", "success");
            map.put("postId", post.getId());
        } else {
            map.put("state", "failed");
            map.put("postId", post.getId());
        }
        return map;
    }

    @RequestMapping(value = "post/uploadContentImage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadContentImage(@RequestParam(value = "editormd-image-file") MultipartFile attach)
            throws IOException {
        final Map<String, String> uploadResult = QiniuUtils.upload(attach.getBytes(), UPLOAD_PATH + "temp/");
        final String postImagePath = QiniuUtils.domain + uploadResult.get("path");
        final Map<String, Object> result = new HashMap<String, Object>();
        result.put("url", postImagePath);
        result.put("success", 1);
        result.put("message", "upload success!");
        return result;
    }

    @RequestMapping(value = "post/{postId}", method = RequestMethod.GET)
    public String postPage(HttpServletRequest request, @PathVariable("postId") Integer postId, ModelMap map) {
        final Post post = postService.getPost(postId);
        if (post != null) {
            final List<String> postTags = postService.getPostTags(post.getTags());
            User currentUser = (User) request.getSession().getAttribute(User.USER);
            if(currentUser != null){
            	Boolean isLikePost = postService.getPostLike(postId, currentUser);
            	if(isLikePost == null){
            		map.put("isLikePost", "notLike");
            	} else if(isLikePost){
            		map.put("isLikePost", "like");
            	} else {
            		map.put("isLikePost", "disLike");
            	}
            }
            map.put("post", post);
            map.put("postTags", postTags);
            return "post/post";
        }
        return "404";
    }

    @RequestMapping(value = "post/edit", method = RequestMethod.GET)
    public String editPost(HttpServletRequest request, @RequestParam("id") Integer postId, ModelMap map) {
        final Post post = postService.getPost(postId);
        if (post != null) {
            if (UserUtils.userCompare(post.getCreateUser(), (User) request.getSession().getAttribute(User.USER))) {
                map.put("post", post);
                map.put("state", "success");
                return "post/postEdit";
            }
        }
        return "404";
    }

    @RequestMapping(value = "post/showEditBtn", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> showEditBtn(HttpServletRequest request, Integer postId) {
        final Post post = postService.getPost(postId);
        if (post != null) {
            if (UserUtils.userCompare(post.getCreateUser(), (User) request.getSession().getAttribute(User.USER))) {
                map.put("state", "same");
                return map;
            }
            map.put("state", "different");
            return map;
        }
        map.put("state", "404");
        return map;
    }
    
    @RequestMapping(value = "post/likePost", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> likePost(HttpServletRequest request, Integer postId) {
        final Map<String, Object> map = new HashMap<String, Object>();
    	User currentUser = (User) request.getSession().getAttribute(User.USER);
    	Boolean isLikePost = postService.getPostLike(postId, currentUser);
    	if(isLikePost == null){
    		postService.likePost(postId, currentUser);
    		map.put("like", true);
    	} else {
    		postService.likeOrDisLikePost(postId, currentUser, !isLikePost);
    		map.put("like", !isLikePost);
    	}
        return map;
    }

    @RequestMapping(value = "showNextPage", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> showNextPage(Integer nextPage) {
        final Map<String, Object> posts = new HashMap<String, Object>();
        final int page = (nextPage - 1) * 5;
        posts.put("posts", postService.getPostsPage(page));
        return posts;
    }


    private Map<String, Object> uploadImage(MultipartFile image, String imageSavePath) throws IOException {
        final String originalPostImageName = image.getOriginalFilename();
        final String postImageName = UUID.randomUUID()
                + originalPostImageName.substring(originalPostImageName.lastIndexOf("."));
        if (image != null && StringUtils.isNotBlank(postImageName)) {
            String newImagePath = imageSavePath + postImageName.replace("-", "");
            newImagePath = newImagePath.replace("/", "\\");
            image.transferTo(new File(newImagePath));
            map.put("success", "1");
            map.put("message ", "upload success");
            map.put("url", newImagePath);
        } else {
            map.put("success", "0");
        }
        return map;
    }
}
