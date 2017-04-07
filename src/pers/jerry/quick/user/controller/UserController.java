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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pers.jerry.quick.user.domain.User;
import pers.jerry.quick.user.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    //index
    @RequestMapping(value="/")
    public ModelAndView index(){
        final ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("user", "jerry");
        return modelAndView;
    }

    //go login page
    @RequestMapping(value="/page")
    public ModelAndView post(){
        return new ModelAndView("test");
    }

    //go login page
    @RequestMapping(value="/login")
    public ModelAndView userLogin(){
       final ModelAndView modelAndView= new ModelAndView("index");
       final List<User> user = userService.getUser();
       modelAndView.addObject("userName", user.get(0).getName());
       return modelAndView;
    }
}
