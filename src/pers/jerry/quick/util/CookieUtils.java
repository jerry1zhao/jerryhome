// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jerry.zhao
 */
public final class CookieUtils {
    private CookieUtils() { }


    public static void addCookie(HttpServletResponse response, Cookie cookie) {
        if (cookie != null) {
            response.addCookie(cookie);
        }
    }

    public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue, String domain,
            boolean httpOnly, int maxAge, String path, boolean secure) {
        if (cookieName != null && !cookieName.equals("")) {
            if (cookieValue == null) {
                cookieValue = "";
            }

            final Cookie newCookie = new Cookie(cookieName, cookieValue);
            if (domain != null) {
                newCookie.setDomain(domain);
            }

            newCookie.setHttpOnly(httpOnly);

            if (maxAge > 0) {
                newCookie.setMaxAge(maxAge);
            }

            if (path == null) {
                newCookie.setPath("/");
            } else {
                newCookie.setPath(path);
            }

            newCookie.setSecure(secure);

            addCookie(response, newCookie);
        }
    }

    public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue, String domain) {
        addCookie(response, cookieName, cookieValue, domain, true, 60 * 60 * 24 * 30, "/", false);
    }

    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        final Cookie[] cookies = request.getCookies();

        if (cookies == null || cookieName == null || cookieName.equals("")) {
            return null;
        }

        for (final Cookie c : cookies) {
            if (c.getName().equals(cookieName)) {
                return c;
            }
        }
        return null;
    }

    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        final Cookie cookie = getCookie(request, cookieName);
        if (cookie == null) {
            return null;
        } else {
            return cookie.getValue();
        }
    }

    public static void delCookie(HttpServletResponse response, Cookie cookie) {
        if (cookie != null) {
            cookie.setPath("/");
            cookie.setMaxAge(0);
            cookie.setValue(null);

            response.addCookie(cookie);
        }
    }

    public static void delCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        final Cookie c = getCookie(request, cookieName);
        if (c != null && c.getName().equals(cookieName)) {
            delCookie(response, c);
        }
    }

    public static void editCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, String domain) {
        final Cookie c = getCookie(request, cookieName);
        if (c != null && cookieName != null && !cookieName.equals("") && c.getName().equals(cookieName)) {
            addCookie(response, cookieName, cookieValue, domain);
        }
    }
}
