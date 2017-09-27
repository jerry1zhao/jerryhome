// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.post.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.jerry.quick.post.dao.PostDao;
import pers.jerry.quick.post.domain.Post;
import pers.jerry.quick.post.domain.PostLike;
import pers.jerry.quick.post.service.PostService;
import pers.jerry.quick.user.domain.User;

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
        final String[] postTags = tags.split("[+]");
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

    /* (non-Javadoc)
     * @see pers.jerry.quick.post.service.PostService#getPostsPage(java.lang.Integer)
     */
    @Override
    public List<Post> getPostsPage(Integer beginNum) {
        // TODO Auto-generated method stub
        return postDao.getPostsPage(beginNum);
    }

    /* (non-Javadoc)
     * @see pers.jerry.quick.post.service.PostService#searchPosts(java.util.Map)
     */
    @Override
    public List<Post> searchPosts(Map<String, Object> searchCondition) {
        // TODO Auto-generated method stub
        return postDao.searchPosts(searchCondition);
    }

    /* (non-Javadoc)
     * @see pers.jerry.quick.post.service.PostService#getUserPosts(java.util.Map)
     */
    @Override
    public List<Post> getUserPosts(Map<String, Object> searchCondition) {
        return postDao.getUserPosts(searchCondition);
    }

	/* (non-Javadoc)
	 * @see pers.jerry.quick.post.service.PostService#likePost(java.lang.Integer, pers.jerry.quick.user.domain.User)
	 */
	@Override
	public void likePost(Integer postId, User user) {
		// TODO Auto-generated method stub
		PostLike likePost = new PostLike();
		likePost.setPostId(postId);
		likePost.setIsLike(true);
		likePost.setLikeUser(user);
		likePost.setLikeDate(new Timestamp(System.currentTimeMillis()));
		postDao.likePost(likePost);
	}

	/* (non-Javadoc)
	 * @see pers.jerry.quick.post.service.PostService#getPostLike(java.lang.Integer, pers.jerry.quick.user.domain.User)
	 */
	@Override
	public Boolean getPostLike(Integer postId, User user) {
		if(user == null){
			return false;
		}
		Map<String,Integer> searchCondition = new HashMap<String, Integer>();
		searchCondition.put("postId", postId);
		searchCondition.put("userId", user.getId());
		PostLike postLike = postDao.getPostLike(searchCondition);
		if(postLike != null){
			return postLike.getIsLike();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see pers.jerry.quick.post.service.PostService#disLikePost(java.lang.Integer, pers.jerry.quick.user.domain.User)
	 */
	@Override
	public void likeOrDisLikePost(Integer postId, User user, Boolean like) {
		Map<String,Object> udpateCondition = new HashMap<String, Object>();
		udpateCondition.put("postId", postId);
		udpateCondition.put("userId", user.getId());
		udpateCondition.put("like", like);
		postDao.likeOrDisLikePost(udpateCondition);
	}

}
