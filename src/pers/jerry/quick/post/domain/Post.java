// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.post.domain;

import java.sql.Timestamp;

import pers.jerry.quick.user.domain.User;

/**
 * @author jerry.zhao
 *
 */
public class Post {

    private int id;
    private User createUser;
    private Timestamp createDate;
    private String title;
    private String subject;
    private String description;
    private String tags;
    private String postImage;
    private String status;
    private String htmlContent;
    private String markdownContent;

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * @return the htmlContent
     */
    public String getHtmlContent() {
        return htmlContent;
    }
    /**
     * @param htmlContent the htmlContent to set
     */
    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }
    /**
     * @return the markdownContent
     */
    public String getMarkdownContent() {
        return markdownContent;
    }
    /**
     * @param markdownContent the markdownContent to set
     */
    public void setMarkdownContent(String markdownContent) {
        this.markdownContent = markdownContent;
    }
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
     * @return the createDate
     */
    public Timestamp getCreateDate() {
        return createDate;
    }
    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }
    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the tags
     */
    public String getTags() {
        return tags;
    }
    /**
     * @param tags the tags to set
     */
    public void setTags(String tags) {
        this.tags = tags;
    }
    /**
     * @return the postImage
     */
    public String getPostImage() {
        return postImage;
    }
    /**
     * @param postImage the postImage to set
     */
    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }
}
