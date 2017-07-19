// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, jerry.zhao, creation
// ============================================================================

package pers.jerry.quick.util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * @author jerry.zhao
 *
 */
public final class QiniuUtils {
    public static String domain;

    private static final Logger logger = Logger.getLogger(QiniuUtils.class);
    private static final String CONSTANT_QINIU_ACCESS_KEY = "accessKey";
    private static final String CONSTANT_QINIU_SECRET_KEY = "secretKey";
    private static final String CONSTANT_QINIU_BUCKET_NAME = "bucketName";
    private static final String CONSTANT_QINIU_DOMAIN = "domain";

    private static String accessKey;
    private static String secretKey;
    private static String bucketName;
    private static String upToken;
    private static UploadManager uploadManager;

    static {
        final ResourceBundle resource = ResourceBundle.getBundle("QiniuSetting");
        accessKey = resource.getString(CONSTANT_QINIU_ACCESS_KEY);
        secretKey = resource.getString(CONSTANT_QINIU_SECRET_KEY);
        bucketName = resource.getString(CONSTANT_QINIU_BUCKET_NAME);
        domain = resource.getString(CONSTANT_QINIU_DOMAIN);

        upToken = Auth.create(accessKey, secretKey).uploadToken(bucketName);
        uploadManager = new UploadManager(new Configuration(Zone.zone2()));
    }

    private QiniuUtils() {
    }

    public static Map<String, String> upload(byte[] file, String loadupPath) {
        final Map<String, String> map = new HashMap<String, String>();
        final String fileName = loadupPath + UUID.randomUUID().toString().replace("-", "");
        try {
            final Response response = uploadManager.put(file, fileName, upToken);
            final DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            map.put("path", putRet.key);
        } catch (final QiniuException e) {
            logger.error("QiniuException", e);
        }
        return map;
    }

}
