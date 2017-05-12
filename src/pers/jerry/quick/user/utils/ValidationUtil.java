// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.user.utils;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import pers.jerry.quick.user.domain.User;

/**
 * @author jerry.zhao
 */
public final class ValidationUtil {

    private ValidationUtil() {
    }

    public static boolean checkUserName(String userName) {
        if (StringUtils.isNotBlank(userName)) {
            final String reg = "^[\\u0391-\\uFFE5_0-9a-zA-z]{4,12}$";
            return Pattern.matches(reg, userName);
        }
        return false;
    }

    public static boolean checkPassword(String password) {
        if (StringUtils.isNotBlank(password)) {
            final String reg = "^([A-Z]|[a-z]|[0-9]|[~!@#$%*=+-]){6,18}$";
            return Pattern.matches(reg, password);
        }
        return false;

    }

    public static boolean checkEmail(String email) {
        if (StringUtils.isNotBlank(email)) {
            final String reg = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
            return Pattern.matches(reg, email);
        }
        return false;

    }

    public static boolean checkCpatcha(String captcha) {
        if (StringUtils.isNotBlank(captcha)) {
            final String reg = "^([A-Z]|[a-z]|[0-9]){6}$";
            return Pattern.matches(reg, captcha);
        }
        return false;

    }

    public static boolean checkSignUpForm(User user, String captcha) {
        if (checkUserName(user.getName()) && checkPassword(user.getPassword()) && checkEmail(user.getEmail())
                && checkCpatcha(captcha)) {
            return true;
        }
        return false;

    }

    public static boolean checkLoginForm(User user) {
        if (checkEmail(user.getEmail()) && checkPassword(user.getPassword())) {
            return true;
        }
        return false;
    }

}
