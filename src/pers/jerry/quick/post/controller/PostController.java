// Copyright (c) 2017 Jerry Home. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

/**
 * @author jerry.zhao
 *
 */
package pers.jerry.quick.post.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pers.jerry.jerryhome.common.controller.BaseController;
import pers.jerry.quick.post.domain.Post;
import pers.jerry.quick.post.service.PostService;

@Controller
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    // go login page
    @RequestMapping(value = INDEX, method = RequestMethod.GET)
    public String goIndex(ModelMap modelMap) {
        final List<Post> posts = postService.getPosts();
        modelMap.put("posts", posts);
        return INDEX;
    }

    // go login page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getPosts(ModelMap modelMap) {
        final List<Post> posts = postService.getPosts();
        modelMap.put("posts", posts);
        return INDEX;
    }

    @RequestMapping(value = "post/editor", method = RequestMethod.GET)
    public String goPostEditor() {
        return "post/postEditor";
    }

    @RequestMapping(value = "post/savePost", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> savePost(Post post, HttpServletRequest request, @RequestParam MultipartFile postImage)
            throws IllegalStateException, IOException {
        final String newPostImagePath = System.getProperty("catalina.home") + "/postimage/";
        return uploadImage(postImage, newPostImagePath);
    }

    @RequestMapping(value = "post/uploadContentImage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadContentImage(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "editormd-image-file") MultipartFile attach) throws IllegalStateException,
            IOException {
        final String newPostImagePath = System.getProperty("catalina.home") + "/postimage/temp/";
        return uploadImage(attach, newPostImagePath);
    }

    private Map<String, Object> uploadImage(MultipartFile Image, String ImageSavePath)
            throws IllegalStateException, IOException {
        final Map<String, Object> map = new HashMap<String, Object>();
        final String originalPostImageName = Image.getOriginalFilename();
        final String postImageName = UUID.randomUUID()
                + originalPostImageName.substring(originalPostImageName.lastIndexOf("."));
        if (Image != null && StringUtils.isNotBlank(postImageName)) {
            String newImagePath = ImageSavePath + postImageName.replace("-", "");
            newImagePath = newImagePath.replace("/", "\\");
            Image.transferTo(new File(newImagePath));
            map.put("success", "1");
            map.put("message ", "upload success");
            map.put("url", newImagePath);
        } else {
            map.put("success", "0");
        }
        return map;
    }

}
