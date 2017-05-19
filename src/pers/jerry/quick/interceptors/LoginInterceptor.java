// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

/**
 * @author jerry.zhao
 *
 */
package pers.jerry.quick.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import pers.jerry.quick.user.domain.User;
import pers.jerry.quick.user.service.UserService;
import pers.jerry.quick.util.CookieUtils;
import pers.jerry.quick.util.UserUtils;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static String[] exceptionPaths = {"singin", "login", "sendCaptcha"};

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("interceptor");
        final String requestURI = request.getRequestURI();
        for (final String exceptionPath : exceptionPaths) {
            if (requestURI.contains(exceptionPath)) {
                return true;
            }
        }
        final String baseCookieValue = CookieUtils.getCookieValue(request, User.JERRY_HOME_USER_COOKIE);
        if (StringUtils.isNotBlank(baseCookieValue)) {
            final String cookieValue = UserUtils.base64Decoder(baseCookieValue);

            final HttpSession session = request.getSession();
            User user = (User) session.getAttribute(User.USER);
            if (user == null) {
                final String[] cookie = cookieValue.split("_");
                if (cookie.length == 3) {
                    user = new User();
                    user.setId(Integer.parseInt(cookie[0]));
                    user.setName(cookie[1]);
                    user.setPasswordMD5(cookie[2]);
                    user = userService.getCookieUser(user);
                    session.setAttribute(User.USER, user);
                }
            }
        }
        return true;
    }

}
