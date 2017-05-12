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

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.jerry.quick.user.domain.User;
import pers.jerry.quick.user.service.UserService;
import pers.jerry.quick.user.utils.MailUtil;
import pers.jerry.quick.user.utils.ValidationUtil;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    //go login page
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLogin() {
        return "user/userLogin";
    }

    //go signin page
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String userSignin() {
        return "user/userSignUp";
    }

    //handle signin page
    @RequestMapping(value = "/handleUserSignin", method = RequestMethod.POST)
    @ResponseBody
    public String handleUserSignin(String captcha, User user) {
        if (ValidationUtil.checkSignUpForm(user, captcha)) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping(value = "/sendCaptcha", method = RequestMethod.GET)
    @ResponseBody
    public String sendCaptcha(String email, HttpSession session) {
        try {
           final String captcha = MailUtil.sendMail(email);
           session.setAttribute(email, captcha);
           return "success";
        } catch (final UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (final MessagingException e) {
            e.printStackTrace();
        }
        return "fail";
    }

}
