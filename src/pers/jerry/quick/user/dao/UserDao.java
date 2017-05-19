// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.dao;

import pers.jerry.quick.user.domain.User;

/**
 * @author jerry.zhao
 *
 */
public interface UserDao {

    User getCookieUser(User user);
    User getLoginUser(User user);
    void insertUser(User user);

}
