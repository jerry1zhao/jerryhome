// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pers.jerry.quick.user.domain.User;
import pers.jerry.quick.user.service.UserService;

/**
 * @author jerry.zhao
 *
 */
@Controller
@RequestMapping("user")
public class UserDomainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String settings(HttpServletRequest request, ModelMap modelMap) {
        final User currentUser = (User) request.getSession().getAttribute(User.USER);
        if (currentUser == null) {
            return "redirect:/logon";
        }
        modelMap.put("currentUser", currentUser);
        return "user/userSettings";
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String homepage(HttpServletRequest request, ModelMap modelMap) {
        final User currentUser = (User) request.getSession().getAttribute(User.USER);
        if (currentUser == null) {
            return "redirect:/logon";
        }
        modelMap.put("currentUser", currentUser);
        return "user/userHomepage";
    }

}
