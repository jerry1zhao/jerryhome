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
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.jerry.jerryhome.common.controller.BaseController;
import pers.jerry.quick.user.domain.User;
import pers.jerry.quick.user.service.UserService;
import pers.jerry.quick.util.CookieUtils;
import pers.jerry.quick.util.MailUtils;
import pers.jerry.quick.util.UserUtils;
import pers.jerry.quick.util.ValidationUtils;

@Controller
public class UserController extends BaseController {

    private static final Logger logger = Logger.getLogger(UserController.class);
    private static final String LAST_REGISTRATION_TIME_COOKIE = "LAST_REGISTRATION_TIME";

    @Autowired
    private UserService userService;

    // go login page
    @RequestMapping(value = "/logon", method = RequestMethod.GET)
    public String userLogin() {
        return "user/userLogin";
    }

    // go signin page
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String userSignin() {
        return "user/userSignUp";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String userLogout(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.delCookie(request, response, User.JERRY_HOME_USER_COOKIE);
        request.getSession().invalidate();
        return "/logon";
    }

    @RequestMapping(value = "/handleUserLogin", method = RequestMethod.POST)
    @ResponseBody
    public String handleUserLogin(User user, HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException {
        if (ValidationUtils.checkLoginForm(user)) {
            final User loginUser = userService.getUser(user);
            if (loginUser != null) {
                CookieUtils.addCookie(response, User.JERRY_HOME_USER_COOKIE, UserUtils.base64EncoderForUser(loginUser),
                        null);
                request.getSession().removeAttribute(User.USER);
                return SUCCESS;
            }
        }
        return FAIL;

    }

    // handle signin page
    @RequestMapping(value = "/handleUserSignin", method = RequestMethod.POST)
    @ResponseBody
    public String handleUserSignin(String captcha, User user, HttpServletRequest request, HttpServletResponse response)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (ValidationUtils.checkSignUpForm(user, captcha)) {
            if (userService.getUserByUserName(user.getName()) == null) {
                if (userService.getUserByEmail(user.getEmail()) == null) {
                    if (ValidationUtils.checkCpatchaValidity(captcha,
                            (String) request.getSession().getAttribute(user.getEmail()))) {
                        request.getSession().removeAttribute(user.getEmail());
                        user.setLastip(UserUtils.getIpAddr(request));
                        user = userService.insertUser(user);
                        CookieUtils.addCookie(response, User.JERRY_HOME_USER_COOKIE,
                                UserUtils.base64EncoderForUser(user), null);
                        request.getSession().removeAttribute(User.USER);
                        return SUCCESS;
                    }
                    return "captchaError";
                }
                return "emailExisted";
            }
            return "userExisted";
        }
        return FAIL;
    }

    @RequestMapping(value = "/sendCaptcha", method = RequestMethod.GET)
    @ResponseBody
    public String sendCaptcha(String email, String userName, HttpServletRequest request, HttpServletResponse response) {
        if (userService.getUserByEmail(email) == null) {
            try {
                final String lastRegistrationTime = CookieUtils.getCookieValue(request, LAST_REGISTRATION_TIME_COOKIE);
                if (StringUtils.isBlank(lastRegistrationTime)) {
                    CookieUtils.addCookie(response, LAST_REGISTRATION_TIME_COOKIE, simpleDateFormat.format(new Date()),
                            null);
                    final String captcha = MailUtils.sendMail(email, userName);
                    request.getSession().setAttribute(email, captcha);
                    return SUCCESS;
                } else {
                    try {
                        final Date nowDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
                        final Date lastRegistrationDate = simpleDateFormat.parse(lastRegistrationTime);
                        final long between = ((nowDate.getTime() - lastRegistrationDate.getTime()) / 1000) / 60;
                        if (between <= 0) {
                            logger.warn("Please wait 1 minute and then register");
                            return "wait";
                        }
                        CookieUtils.addCookie(response, LAST_REGISTRATION_TIME_COOKIE,
                                simpleDateFormat.format(new Date()), null);
                        final String captcha = MailUtils.sendMail(email, userName);
                        request.getSession().setAttribute(email, captcha);
                        return SUCCESS;
                    } catch (final ParseException e) {
                        logger.error("ParseException", e);
                    }
                }
            } catch (final UnsupportedEncodingException e) {
                logger.error("UnsupportedEncodingException", e);
            } catch (final MessagingException e) {
                logger.error("MessagingException", e);
            }
            return "emailException";
        }
        return "emailExisted";
    }

    @RequestMapping(value = "/userNameCheck", method = RequestMethod.GET)
    @ResponseBody
    public String userNameCheck(String name) {
        final User signinUser = userService.getUserByUserName(name);
        if (signinUser == null) {
            return "none";
        }
        return "existed";
    }

    @RequestMapping(value = "/emailCheck", method = RequestMethod.GET)
    @ResponseBody
    public String emailCheck(String email) {
        final User signinUser = userService.getUserByEmail(email);
        if (signinUser == null) {
            return "none";
        }
        return "existed";
    }

    @RequestMapping(value = "/userIsLoggedIn", method = RequestMethod.GET)
    @ResponseBody
    public Boolean userIsLoggedIn(HttpServletRequest request) {
        final User user = (User) request.getSession().getAttribute(User.USER);
        if (user == null) {
            return false;
        }
        return true;
    }

}
