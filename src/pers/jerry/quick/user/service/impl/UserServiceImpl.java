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
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userdao;
    /* (non-Javadoc)
     * @see pers.jerry.quick.user.service.UserService#getUser(pers.jerry.quick.user.domain.User)
     */
    @Override
    public List<User> getUser() {
        // TODO Auto-generated method stub
        return userdao.getUser();
    }

}
