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
import pers.jerry.quick.post.domain.PostLike;
import pers.jerry.quick.user.domain.User;


public interface PostService {

    List<Post> getPosts();
    List<Post> getPostsPage(Integer beginNum);
    void savePost(Post post);
    void updatePost(Post post);
    Post getPost(Integer postId);
    List<String> getPostTags(String tags);
    List<Map<Object, Object>> hotPosts();
    List<Post> searchPosts(Map<String, Object> searchCondition);
    List<Post> getUserPosts(Map<String, Object> searchCondition);
    List<Post> getUserLikePosts(Map<String, Object> searchCondition);
    void likePost(Integer postId,User user);
    void likeOrDisLikePost(Integer postId, User user, Boolean like);
    Boolean getPostLike(Integer postId, User user);
}
