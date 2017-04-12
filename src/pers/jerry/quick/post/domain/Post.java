// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.post.domain;

import java.time.LocalDateTime;

import pers.jerry.quick.user.domain.User;

/**
 * @author jerry.zhao
 *
 */
public class Post {
    private int id;
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
    private String postHeaderImage;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private User createUser;
    private LocalDateTime updateDate;
    private User updateUser;
    /**
     * @return the updateUser
     */
    public User getUpdateUser() {
        return updateUser;
    }
    /**
     * @param updateUser the updateUser to set
     */
    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }
    /**
     * @return the postHeaderImage
     */
    public String getPostHeaderImage() {
        return postHeaderImage;
    }
    /**
     * @param postHeaderImage the postHeaderImage to set
     */
    public void setPostHeaderImage(String postHeaderImage) {
        this.postHeaderImage = postHeaderImage;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * @return the createDate
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    /**
     * @return the updateDate
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    /**
     * @return the createUser
     */
    public User getCreateUser() {
        return createUser;
    }
    /**
     * @param createUser the createUser to set
     */
    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

}
