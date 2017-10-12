// Copyright (c) 2017 Quick Jerry
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.domain;

import java.sql.Timestamp;
/**
 * @author jerry.zhao
 */

public class User {

    public static final String USER = "user";
    public static final String JERRY_HOME_USER_COOKIE = "JERRY_HOME_USER";

    private int id;
    private int status;
    private Timestamp createdate;
    private Timestamp lastvisit;
    private String lastip;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String photo;
    private String userGroup;
    private String passwordMD5;

    public User() {

    }

    /**
     * @return the passwordMD5
     */
    public String getPasswordMD5() {
        return passwordMD5;
    }

    /**
     * @param passwordMD5
     *            the passwordMD5 to set
     */
    public void setPasswordMD5(String passwordMD5) {
        this.passwordMD5 = passwordMD5;
    }

    /**
     * @param userGroup
     *            the userGroup to set
     */
    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the createdate
     */
    public Timestamp getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     *            the createdate to set
     */
    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    /**
     * @return the lastvisit
     */
    public Timestamp getLastvisit() {
        return lastvisit;
    }

    /**
     * @param lastvisit
     *            the lastvisit to set
     */
    public void setLastvisit(Timestamp lastvisit) {
        this.lastvisit = lastvisit;
    }

    /**
     * @return the lastip
     */
    public String getLastip() {
        return lastip;
    }

    /**
     * @param lastip
     *            the lastip to set
     */
    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo
     *            the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the user_group
     */
    public String getUserGroup() {
        return userGroup;
    }

}
