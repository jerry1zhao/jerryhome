// Copyright (c) 1998-2017 Core Solutions Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION CNT.5.0.1
// ============================================================================
// CHANGE LOG
// CNT.5.0.1 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

/**
 * @author jerry.zhao
 *
 */
package pers.jerry.quick.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.jerry.quick.user.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //go login page
    @RequestMapping(value = "/login")
    public String userLogin(ModelMap modelMap) {
        return "user/userLogin";
    }

    //go signin page
    @RequestMapping(value = "/signin")
    public String userSignin(ModelMap modelMap) {
        return "user/userSignin";
    }
}
