// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================
/**
 * @author jerry.zhao
 *
 */
package pers.jerry.quick.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import pers.jerry.quick.util.UserUtils;

public class Test {

    public static void main(String[] args) throws Exception {

        System.out.println(UserUtils.base64Decoder("MTAwOF8xMjMyMTMyMV9kMTVjOGEyMTkxZDM2ZWVkMmVhMjc2Nzc2ZDUzMTFhZQ=="));
        System.out.println(UserUtils.toMD5Code("qwerqwzdfadfassdafas"));
        String addd = "fadfa";
        System.out.println(addd+= "JERRY");
    }

    public static String a() {
        return "";
    }

    public static String b(String str) {
        String result = "";
        try {
            final MessageDigest md = MessageDigest.getInstance("MD5");
            final byte[] ads = md.digest(str.getBytes());
            for (int i = 0; i < ads.length; i++) {
                final int temp = ads[i] & 0xff;
                final String tempHex = Integer.toHexString(temp);
                if (tempHex.length() < 2) {
                    result += "0" + tempHex;
                } else {
                    result += tempHex;
                }
            }
        } catch (final NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
