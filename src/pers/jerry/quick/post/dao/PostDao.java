// Copyright (c) 2017 Quick.
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.post.dao;

import java.util.List;
import java.util.Map;

import pers.jerry.quick.post.domain.Post;


/**
 * @author jerry.zhao
 *
 */
public interface PostDao {

    List<Post> getPosts();
    List<Post> getPostsPage(Integer beginNum);
    void savePost(Post post);
    Post getPost(Integer postId);
    List<Map<Object, Object>> hotPosts();

}
