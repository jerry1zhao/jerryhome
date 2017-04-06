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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

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
}
