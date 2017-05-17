// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.service.impl;

import java.util.List;

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
     * @see pers.jerry.quick.user.service.UserService#getUser(pers.jerry.quick.user.domain.User)
     */
    @Override
    public List<User> getUser(int userId) {
        // TODO Auto-generated method stub
        return userDao.getUser(userId);
    }
    /* (non-Javadoc)
     * @see pers.jerry.quick.user.service.UserService#insertUser(pers.jerry.quick.user.domain.User)
     */
    @Override
    public void insertUser(User user) {
        // TODO Auto-generated method stub
        userDao.insertUser(user);
    }

}
