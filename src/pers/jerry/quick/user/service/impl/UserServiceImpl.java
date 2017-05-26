// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.service.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.jerry.quick.user.dao.UserDao;
import pers.jerry.quick.user.domain.User;
import pers.jerry.quick.user.service.UserService;
import pers.jerry.quick.util.UserUtils;

/**
 * @author jerry.zhao
 *
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;
    /* (non-Javadoc)
     * @see pers.jerry.quick.user.service.UserService#insertUser(pers.jerry.quick.user.domain.User)
     */
    @Override
    public User insertUser(User user) {
        user.setCreatedate(new Timestamp(System.currentTimeMillis()));
        user.setLastvisit(new Timestamp(System.currentTimeMillis()));
        user.setUserGroup(User.USER);
        try {
            user.setPasswordMD5(UserUtils.toMD5Code(user.getPassword()));
        } catch (final NoSuchAlgorithmException e) {
            logger.error("NoSuchAlgorithmException", e);
        }
        userDao.insertUser(user);
        return user;
    }

    /* (non-Javadoc)
     * @see pers.jerry.quick.user.service.UserService#getUser(pers.jerry.quick.user.domain.User)
     */
    @Override
    public User getUser(User user) {
        if (user.getPasswordMD5() == null) {
            if (user.getPassword() != null) {
                try {
                    final String passwordMD5 = UserUtils.toMD5Code(user.getPassword());
                    user.setPasswordMD5(passwordMD5);
                } catch (final NoSuchAlgorithmException e) {
                    logger.error("NoSuchAlgorithmException", e);
                }
            }
        }
        return userDao.getUser(user);
    }

    @Override
    public User getCookieUser(String[] cookie) {
        // TODO Auto-generated method stub
        final User user = new User();
        user.setId(Integer.parseInt(cookie[0]));
        user.setName(cookie[1]);
        user.setPasswordMD5(cookie[2]);
        return userDao.getUser(user);
    }

}
