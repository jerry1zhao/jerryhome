// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import pers.jerry.quick.user.domain.User;

/**
 * @author jerry.zhao
 *
 */
public final class UserUtils {
    private UserUtils() { }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

    public static String base64EncoderForUser(Object obj) throws UnsupportedEncodingException {
        final User user = (User) obj;
        final String userCookie = user.getId() + "_" + user.getName() + "_" + user.getPasswordMD5();
        return base64Encoder(userCookie);
    }

    public static String base64Encoder(String str) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
    }

    public static String base64Decoder(String str) throws UnsupportedEncodingException {
        return new String(Base64.getDecoder().decode(str), "utf-8");
    }

    //    public static String toMD5Code(String str) throws NoSuchAlgorithmException {
    //        final StringBuffer md5Code = new StringBuffer();
    //        final MessageDigest instance = MessageDigest.getInstance("MD5");
    //        instance.update(str.getBytes());
    //        final byte[] digest = instance.digest();
    //        int index;
    //        for (final byte b : digest) {
    //            index = b;
    //            if (index < 0) {
    //                index += 256;
    //            }
    //            if (index < 16) {
    //                md5Code.append(0);
    //            }
    //            md5Code.append(Integer.toHexString(index));
    //        }
    //        return md5Code.toString();
    //    }

    public static String toMD5Code(String str) throws NoSuchAlgorithmException {
        String result = "";
        str += "JERRY";
        final MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] bytes = md.digest(str.getBytes());
        for (int i = 0; i < bytes.length; i++) {
            final int index = bytes[i] & 0xff;
            final String hexIndex = Integer.toHexString(index);
            if (hexIndex.length() < 2) {
                result += "0" + hexIndex;
            } else {
                result += hexIndex;
            }
        }
        return result;
    }

    public static boolean userCompare(User user1, User user2) {
        if (user1 != null && user2 != null) {
            if (String.valueOf(user1.getId()).equals(String.valueOf(user2.getId()))) {
                if (user1.getName().equals(user2.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

}
