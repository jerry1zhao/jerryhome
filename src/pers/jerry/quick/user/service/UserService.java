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

    User insertUser(User user);
    User getUser(User user);
    User getCookieUser(String[] cookie);
    User getUserByEmail(String email);
    User getUserByUserName(String userName);
}
