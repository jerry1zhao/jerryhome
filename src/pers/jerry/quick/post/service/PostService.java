// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

/**
 * @author jerry.zhao
 *
 */
package pers.jerry.quick.post.service;

import java.util.List;
import java.util.Map;

import pers.jerry.quick.post.domain.Post;


public interface PostService {

    List<Post> getPosts();
    void savePost(Post post);
    Post getPost(Integer postId);
    List<String> getPostTags(String tags);
    List<Map<Object, Object>> hotPosts();
}
