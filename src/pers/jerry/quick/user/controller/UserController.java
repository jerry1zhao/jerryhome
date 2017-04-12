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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pers.jerry.quick.user.domain.User;
import pers.jerry.quick.user.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //go login page
    @RequestMapping(value="/login")
    public String userLogin(@RequestParam("userId")int userId,Model model){
       final List<User> user = userService.getUser(userId);
       model.addAttribute("userName", user.get(0).getName());
       return "index";
    }
}
