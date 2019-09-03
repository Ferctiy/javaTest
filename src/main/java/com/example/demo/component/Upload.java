package com.example.demo.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName UploadConfig
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/9/3 12:18
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "upload")
public class Upload {
    public static Upload instance;
    private String savePath;
    private String acceptType;
    private Long maxFileSize;

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getAcceptType() {
        return acceptType;
    }

    public void setAcceptType(String acceptType) {
        this.acceptType = acceptType;
    }

    public Long getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(Long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }
}
