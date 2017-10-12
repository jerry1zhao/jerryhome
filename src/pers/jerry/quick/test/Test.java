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
import java.util.List;

import org.apache.log4j.Logger;

import pers.jerry.quick.util.ActionHelper;

public class Test {
    static Logger log = Logger.getLogger(Test.class);

    public static void main(String[] args) throws Exception {

    	List<String> s = ActionHelper.getUploadImg("![](http://orzrxu448.bkt.clouddn.com/post/temp/09c87d81845b422c9c484126234fa0cf)asda![](http://orzrxu448.bkt.clouddn.com/post/temp/09c87d81845b422c9c484126234fa0cf)dasz+-![](http://orzrxu448.bkt.clouddn.com/post/temp/09c87d81845b422c9c484126234fa0cf)*/*");
    	s.get(0);
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
