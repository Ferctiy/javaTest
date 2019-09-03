package com.example.demo.utils;

import java.util.Map;

/**
 * API返回对象
 *
 * @param <TModel>
 */
public class RestResult<TModel> {

    /**
     * 状态
     */
    private int status;
    /**
     * 信息
     */
    private String message;

    /**
     * 数据模型
     */
    private TModel data;

    public RestResult() {
    }

    public RestResult(int status) {
        this.status = status;
    }

    public RestResult(int status, TModel data) {
        this.status = status;
        this.data = data;
    }

    public RestResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public RestResult(int status, String message, TModel data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * 取得状态
     *
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 取得信息
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置信息
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * 取得数据模型
     *
     * @return
     */
    public TModel getData() {
        return data;
    }

    /**
     * 设置数据模型
     *
     * @param data
     */
    public void setData(TModel data) {
        this.data = data;
    }
}
