// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.post.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.jerry.quick.post.dao.PostDao;
import pers.jerry.quick.post.domain.Post;
import pers.jerry.quick.post.service.PostService;

/**
 * @author jerry.zhao
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    /*
     * (non-Javadoc)
     * @see pers.jerry.quick.user.service.PostService#getPosts()
     */
    @Override
    public List<Post> getPosts() {
        return postDao.getPosts();
    }

    /*
     * (non-Javadoc)
     * @see pers.jerry.quick.post.service.PostService#savePost()
     */
    @Override
    public void savePost(Post post) {
        postDao.savePost(post);
    }

    /*
     * (non-Javadoc)
     * @see pers.jerry.quick.post.service.PostService#getPost(java.lang.String)
     */
    @Override
    public Post getPost(Integer postId) {
        return postDao.getPost(postId);
    }

    /*
     * (non-Javadoc)
     * @see pers.jerry.quick.post.service.PostService#getPostTags(java.lang.String)
     */
    @Override
    public List<String> getPostTags(String tags) {
        final List<String> tagList = new ArrayList<String>();
        final String[] postTags = tags.split(" ");
        for (final String tag : postTags) {
            tagList.add(tag);
        }
        return tagList;
    }

    /* (non-Javadoc)
     * @see pers.jerry.quick.post.service.PostService#hotPost()
     */
    @Override
    public List<Map<Object, Object>> hotPosts() {
        final List<Map<Object, Object>> hotPosts = new ArrayList<Map<Object, Object>>();
        final List<Map<Object, Object>> orderlyHotPosts = postDao.hotPosts();
        for (final Map<Object, Object> orderlyHotPost : orderlyHotPosts) {
            final Map<Object, Object> postMap = new HashMap<Object, Object>();
            final Post post = postDao.getPost((Integer) orderlyHotPost.get("postId"));
            postMap.put("postId", post.getId());
            postMap.put("postTitle", post.getTitle());
            hotPosts.add(postMap);
        }
        return hotPosts;
    }
}
