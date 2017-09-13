// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.dao;

import java.util.List;

import pers.jerry.quick.user.domain.User;

/**
 * @author jerry.zhao
 *
 */
public interface UserDao {

    void insertUser(User user);
    User getUser(User user);
    List<User> searchUsersByName(String name);

}
