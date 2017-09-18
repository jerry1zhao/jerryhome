// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pers.jerry.quick.user.service.UserService;

/**
 * @author jerry.zhao
 *
 */
@Controller
@RequestMapping("user")
public class UserSettingsController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String settings(HttpServletRequest request) {
        return "user/userSettings";
    }

}
