package org.world.origin.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.world.origin.domain.PageData;
import org.world.origin.enums.ResultEnum;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * <pre>
 * *********************************************
 * Copyright .
 * All rights reserved.
 * Description: HTTP
 * HISTORY
 * *********************************************
 *  ID     REASON        PERSON          DATE
 *  1      Create   	 darwin du       2017年7月25日
 * *********************************************
 * </pre>
 */
public class HttpUtil {

	private static final Logger log = Log.get();
	/**编码格式。发送编码格式统一用UTF-8**/
    private static String ENCODING = "UTF-8";
    
    
    /**
     * 基于HttpClient 4.3的通用GET方法
     * @param url       提交的URL
     * @return 提交响应
     */
    public static String get(String url) { 
    	
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		String responseText = "";
		CloseableHttpResponse response = null;
        try {
        	log.info("======get 请求访问URL=====" + url);
        	HttpGet get = new HttpGet(url);
        	//设置请求和传输超时时间
    		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(1000).build();
    		get.setConfig(requestConfig);
    		
            response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
            log.info("======结果集=====" + responseText);
        } catch (Exception e) {
        	
        	PageData pdResult = ResultUtil.error(ResultEnum.ERROR_TIMEOUT_RESEND.getMsg(), ResultEnum.ERROR_TIMEOUT_RESEND.getCode());
        	responseText = pdResult.toString();
        } finally {
            try {
            	if(response != null) {
            		response.close();
            	}
			} catch (IOException e) {
				PageData pdResult = ResultUtil.error(ResultEnum.ERROR_IO.getMsg(), ResultEnum.ERROR_IO.getCode());
	        	responseText = pdResult.toString();
			}
            
        }
        return responseText;  
    }
    
	 /**
     * 基于HttpClient 4.3的通用POST方法
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */
    public static String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost post = new HttpPost(url);
            //设置请求和传输超时时间
    		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
    		post.setConfig(requestConfig);
            
            if (paramsMap != null && !paramsMap.isEmpty()) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                post.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
            log.info("======结果集=====" + responseText);
        } catch (Exception e) {
        	PageData pdResult = ResultUtil.error(ResultEnum.ERROR_TIMEOUT_RESEND.getMsg(), ResultEnum.ERROR_TIMEOUT_RESEND.getCode());
        	responseText = pdResult.toString();
        } finally {
        	try {
        		if(response != null) {
            		response.close();
            	}
			} catch (IOException e) {
				PageData pdResult = ResultUtil.error(ResultEnum.ERROR_IO.getMsg(), ResultEnum.ERROR_IO.getCode());
	        	responseText = pdResult.toString();
			}
        }
        return responseText;
    }
    
    public static void main(String[] args) {
		
    	String url = "https://tapi.wincustomer.net/ypos/api";
    	
    	String body = "{\"shopno\":\"0206\",\"posno\":\"001\"}";
		String invoker_id = "w1p9nq8khvvyblyi";
		String method = "init";
		String nonce_str = "20180504154000";
		String version = "1.0";
		String sign = "58b32c567c60816fb0c192edd0461c8ee7e866a1";
		
		Map<String, String> paramsMap = new HashMap<String, String>();
		/*paramsMap.put("body", body);
		paramsMap.put("method", method);
		paramsMap.put("nonce_str", nonce_str);
		paramsMap.put("version", version);
		paramsMap.put("invoker_id", invoker_id);
		paramsMap.put("sign", sign);
    	
    	String ss = post(url, paramsMap);
    	System.out.println(ss);
    	JSONObject json = JSONObject.parseObject(ss);
    	String status = json.getString("status");
    	System.out.println(status);
    	JSONObject bodyJson = json.getJSONObject("body");
    	String token = bodyJson.getString("token");
    	System.out.println(token);
    	System.out.println(json.getJSONObject(""));
    	System.out.println(1);*/
    	
    	
    	body = "{\"token\":\"57b1309918344479a3809f671e919449\",\"goods\":[{\"goods_type\":0,\"goods_no\":\"4891028164456\",\"quantity\":2}]}";
		invoker_id = "w1p9nq8khvvyblyi";
		method = "calcamount";
		nonce_str = "20180504154000";
		version = "1.0";
		sign = "d0e45b357500e13afbd096e713655d94acf8ed69";
		
		paramsMap = new HashMap<String, String>();
		paramsMap.put("body", body);
		paramsMap.put("method", method);
		paramsMap.put("nonce_str", nonce_str);
		paramsMap.put("version", version);
		paramsMap.put("invoker_id", invoker_id);
		paramsMap.put("sign", sign);
		
		String ss = post(url, paramsMap);
    	System.out.println(ss);
    	JSONObject json = JSONObject.parseObject(ss);
    	String status = json.getString("status");
    	System.out.println(status);
    	JSONObject bodyJson = json.getJSONObject("body");
    	System.out.println(bodyJson);
    	JSONArray goodsJSONArray = bodyJson.getJSONArray("goods");
    	System.out.println(goodsJSONArray);
    	if(goodsJSONArray != null && !goodsJSONArray.isEmpty()) {
    		for(Object good : goodsJSONArray) {
    			JSONObject goodJson = (JSONObject) good;
    			System.out.println(goodJson);
    			System.out.println(goodJson.getString("goods_name"));
    		}
    	}
	}
}
