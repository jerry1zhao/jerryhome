// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import pers.jerry.quick.user.dao.UserDao;
import pers.jerry.quick.user.domain.User;
import pers.jerry.quick.user.service.UserService;

/**
 * @author jerry.zhao
 *
 */
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userdao;
    /* (non-Javadoc)
     * @see pers.jerry.quick.user.service.UserService#userIsExists(pers.jerry.quick.user.domain.User)
     */
    @Override
    public boolean userIsExists(User user) {
        return  userdao.userIsExists(user);
    }

}
