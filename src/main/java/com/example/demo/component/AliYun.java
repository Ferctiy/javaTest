package com.example.demo.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName AliYun
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/19 15:06
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "ali")
public class AliYun {
    public static AliYun instance;
    private String appKey;
    private String appCode;
    private String AppSecret;
    private String idCardCert;

    public AliYun() {
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getAppSecret() {
        return AppSecret;
    }

    public void setAppSecret(String appSecret) {
        AppSecret = appSecret;
    }

    public String getIdCardCert() {
        return idCardCert;
    }

    public void setIdCardCert(String idCardCert) {
        this.idCardCert = idCardCert;
    }
}
