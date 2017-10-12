// Copyright (c) 2017 Quick.
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.post.dao;

import java.util.List;
import java.util.Map;

import pers.jerry.quick.post.domain.Post;
import pers.jerry.quick.post.domain.PostLike;
import pers.jerry.quick.user.domain.User;


/**
 * @author jerry.zhao
 *
 */
public interface PostDao {

    List<Post> getPosts();
    List<Post> getPostsPage(Integer beginNum);
    void savePost(Post post);
    void updatePost(Post post);
    Post getPost(Integer postId);
    List<Map<Object, Object>> hotPosts();
    List<Post> searchPosts(Map<String, Object> searchCondition);
    List<Post> getUserPosts(Map<String, Object> searchCondition);
    void likePost(PostLike postLike);
    void likeOrDisLikePost(Map<String, Object> udpateCondition);
    PostLike getPostLike(Map<String, Integer> searchCondition);
}
