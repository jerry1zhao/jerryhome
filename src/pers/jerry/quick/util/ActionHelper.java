// Copyright (c) 2017 Quick
// ============================================================================
// CHANGE LOG
// V.1.0 : 2017-XX-XX, Jerry, creation
// ============================================================================

package pers.jerry.quick.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pers.jerry.quick.post.domain.PostConstants;

/**
 * @author Jerry
 *
 */
public class ActionHelper {
    private static final String POST_IMAGE_REG = "(https|http)?:\\/\\/orzrxu448.bkt.clouddn.com\\/post\\/temp\\/\\w+";
    
    public static List<String> getUploadImg(String markdown){
    	List<String> uploadImgs = new ArrayList<String>();
    	Pattern p = Pattern.compile(POST_IMAGE_REG);
    	Matcher m  = p.matcher(markdown);
    	while(m.find()){
    		uploadImgs.add(m.group());
    	}
    	return uploadImgs;
    }
    
    public static Map<String,String> postContentImgHandle(String markdown,String html){
    	Map<String,String> result = new HashMap<String,String>();
    	List<String> uploadImgs =  getUploadImg(markdown);
    	Map<String,String> replacedUploadImgs = new HashMap<String,String>();
    	for(String uploadImg : uploadImgs){
    		replacedUploadImgs.put(uploadImg, uploadImg.replace("temp/", ""));
    	}
    	for(Map.Entry<String, String> entry : replacedUploadImgs.entrySet()){
    		markdown = markdown.replace(entry.getKey(), entry.getValue());
    		html = html.replace(entry.getKey(), entry.getValue());
    		String cloudKey = entry.getKey().replace(QiniuUtils.domain, "");
    		String renameCloudKey = entry.getValue().replace(QiniuUtils.domain, "");
    		QiniuUtils.rename(cloudKey, renameCloudKey);
    	}
    	result.put(PostConstants.POST_CONTENT_MARKDOWN, markdown);
    	result.put(PostConstants.POST_CONTENT_HTML, html);
    	return result;
    }
    
}
