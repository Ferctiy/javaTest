package com.example.demo.utils;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Validation
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/19 14:35
 * @Version 1.0
 */
public class Validation {

//    public static Map<String,String> idCardValidate(String appCode){
//        String host = "https://idcardcert.market.alicloudapi.com";
//        String path = "/idCardCert";
//        String method = "GET";
//        Map<String, String> headers = new HashMap<>();
//        headers.put("Authorization", "APPCODE " + appCode);
//        Map<String, String> querys = new HashMap<>();
//        querys.put("idCard", "610429199104043793");
//        querys.put("name", "李鹏刚");
//        Map<String, String> data = new HashMap<>();
//        try {
//            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//            data.put("code", JSON.parseObject(EntityUtils.toString(response.getEntity())).getString("status"));
//            data.put("message", JSON.parseObject(EntityUtils.toString(response.getEntity())).getString("msg"));
//            System.out.println(response.toString());
//            //如不输出json, 请打开这行代码，打印调试头部状态码。
//            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
//            System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return data;
//    }

}
