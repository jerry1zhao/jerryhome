// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, Jerry, creation
// ============================================================================

package pers.jerry.quick.post.domain;

import java.sql.Timestamp;

import pers.jerry.quick.user.domain.User;

/**
 * @author Jerry
 *
 */
public class PostLike {
	private int id;
    private int postId;
    private User likeUser;
    private Timestamp likeDate;
    private Boolean isLike;
    /**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the postId
	 */
	public int getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}
	/**
	 * @return the likeUser
	 */
	public User getLikeUser() {
		return likeUser;
	}
	/**
	 * @param likeUser the likeUser to set
	 */
	public void setLikeUser(User likeUser) {
		this.likeUser = likeUser;
	}
	/**
	 * @return the likeDate
	 */
	public Timestamp getLikeDate() {
		return likeDate;
	}
	/**
	 * @param likeDate the likeDate to set
	 */
	public void setLikeDate(Timestamp likeDate) {
		this.likeDate = likeDate;
	}
	/**
	 * @return the isLike
	 */
	public Boolean getIsLike() {
		return isLike;
	}
	/**
	 * @param isLike the isLike to set
	 */
	public void setIsLike(Boolean isLike) {
		this.isLike = isLike;
	}
}
