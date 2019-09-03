package com.example.demo.utils;

import com.sun.javafx.collections.MappingChange;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.validation.constraints.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HttpUtils
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/19 14:42
 * @Version 1.0
 */
public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
//    /**
//     * 向指定URL发送GET方法的请求
//     *
//     * @param url    请求URL
//     * @param params 请求参数
//     * @return URL 所代表远程资源的响应结果
//     */
//    public static String sendGet(@NotNull String url, List<Map<String, String> > params) {
//        BufferedReader in = null;
//        StringBuilder sb = new StringBuilder();
//        String requestUrl = prepareRequestUrl(url, params), line;
//
//        try {
//            URLConnection connection = new URL(requestUrl).openConnection();
//
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//
//            connection.connect();
//
//            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            while ((line = in.readLine()) != null) {
//                sb.append(line);
//            }
//        } catch (Exception e) {
//            logger.error("发送GET请求异常", e);
//        } finally {
//            connection.close();
//        }
//
//        return sb.toString();
//    }
}
