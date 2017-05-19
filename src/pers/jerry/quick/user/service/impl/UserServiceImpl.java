// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.jerry.quick.user.dao.UserDao;
import pers.jerry.quick.user.domain.User;
import pers.jerry.quick.user.service.UserService;

/**
 * @author jerry.zhao
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    /* (non-Javadoc)
     * @see pers.jerry.quick.user.service.UserService#insertUser(pers.jerry.quick.user.domain.User)
     */
    @Override
    public void insertUser(User user) {
        // TODO Auto-generated method stub
        userDao.insertUser(user);
    }
    /* (non-Javadoc)
     * @see pers.jerry.quick.user.service.UserService#getCookieUser(pers.jerry.quick.user.domain.User)
     */
    @Override
    public User getCookieUser(User user) {
        // TODO Auto-generated method stub
        return userDao.getCookieUser(user);
    }
    /* (non-Javadoc)
     * @see pers.jerry.quick.user.service.UserService#getLoginUser(pers.jerry.quick.user.domain.User)
     */
    @Override
    public User getLoginUser(User user) {
        // TODO Auto-generated method stub
        return userDao.getLoginUser(user);
    }

}
