// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

/**
 * @author jerry.zhao
 *
 */
package pers.jerry.quick.user.service;

import pers.jerry.quick.user.domain.User;

public interface UserService {

    User getCookieUser(User user);
    User getLoginUser(User user);
    void insertUser(User user);
}
