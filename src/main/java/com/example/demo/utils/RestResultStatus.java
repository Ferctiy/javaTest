package com.example.demo.utils;

/**
 * @ClassName ss
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/9/3 16:46
 * @Version 1.0
 */
public enum RestResultStatus {

    Success(200, "Success", "处理成功"),

    NoData(204, "NoData", "无数据"),

    ParamError(400, "ParamError", "参数错误"),

    NoAuth(403, "NoAuth", "禁止访问"),

    NotFound(404, "NotFoundUrl", "路由出错"),

    Failed(417, "Failed", "处理失败");

    private int value;

    private String name;

    private String message;


    RestResultStatus(int value, String name, String message) {
        this.value = value;
        this.name = name;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
