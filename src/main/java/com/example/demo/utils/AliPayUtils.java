package com.example.demo.utils;

import org.springframework.stereotype.Component;

/**
 * @ClassName AliPayUtils
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/20 9:50
 * @Version 1.0
 */
@Component
public class AliPayUtils {
    /**
     * 支付宝网关
     */
   private  String gateWayUrl="https://openapi.alipaydev.com/gateway.do";

    /**
     * 支付宝收款账户APPID
     */
    private String appId="2016101000651284";

    /**
     * 支付宝公钥
     */
    private String alipayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjpYtGij+NaUDzjNZ66JwwB2HiWl28E+efpUMVhGKmysrIwZTiI+/YPob3sgLSrKoCQsWMF/D4K+cNlzY9dK0vszDBLZ/+sVlXMcC3SemNuBnZy7wI0lelKqHe4M5Ltqyh/qCjRz+N1rtCj/WOAP+fOsHE5NL+BHyDp6mjx1dpX+PcLYsEhKL1C5rhX5c2Vg29j2MtMZZ6tgf1hkJqHfgNdw1bDcFCp8x2I3jx+NuFr2LlfvF/hI4jSte6889FcYbPCuCHZI1/4E6C/sTdqPXoktPmCXdF5ymhvVqEMjQ2YU3BttyO3YwEGA/5WMR7n8H7dG50buenLvqfuXAAUm0xQIDAQAB";

    /**
     * 商户私钥
     */
    private String merchantPrivateKey="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCOli0aKP41pQPOM1nronDAHYeJaXbwT55+lQxWEYqbKysjBlOIj79g+hveyAtKsqgJCxYwX8Pgr5w2XNj10rS+zMMEtn/6xWVcxwLdJ6Y24GdnLvAjSV6Uqod7gzku2rKH+oKNHP43Wu0KP9Y4A/586wcTk0v4EfIOnqaPHV2lf49wtiwSEovULmuFflzZWDb2PYy0xlnq2B/WGQmod+A13DVsNwUKnzHYjePH424WvYuV+8X+EjiNK17rzz0Vxhs8K4IdkjX/gToL+xN2o9eiS0+YJd0XnKaG9WoQyNDZhTcG23I7djAQYD/lYxHufwft0bnRu56cu+p+5cABSbTFAgMBAAECggEAAKuMArd2mmHwJqPvJEBbL0v0Ox0XxgFZyVaB/FWQxTHqvftloRqr15TVVLKz+uHkEEbRD+EjVob8wPSmwGEBIHRt5jPFXjRXSZxV0xxAl7luQvnhfwj1PNWgVWBEgIfelu0CeA9O0ovG2Wl7ZEAAji28lsb2cHAFJzRvq/SDYCe7cWdj6c+9D9MGQf58WdvqX5HHe8325RROTiVZ/AaT2rEtCNzbb1xCMaf3VZLn/TONmGmPmNaiFC+pdcxzDdOQC7LjOx0Njoppj0WaU2Lm28H72yJPYKNGTo0SUgY9eumie09ElFPaF4PJ0u6irNC70/emVPSfpeX7p0R+cUNTgQKBgQD/y5aapUcuXbVPeNrR2EhLyzPPMhxlvkX2hJ+gFHYyaVzTpVbq5xEs/tWQIeXPovZQNyl4QKj1JvI6S+F1EO87myCyCDfChPTlWzd+/I7H5BAsL+auKYUT2VAHZ3kcwpwCz75f0oOwUqMZwGbl6gJm3bHz8rFwcD6MZvXrYfEPfQKBgQCOs2RKm6EUruu+HKTrIhZf9bdpE777nkY0lEDI2VuLfyx+ASWsPmgn1JmU3KXg2zlFX4XUDqyoHvVH+268Jzxh5788ImqEcJmLz2HWJfHy72auHU24HcICMyZSyheYiK+GjBnW5u0p03LktuOQNtkvcPlKWuvBsB78o3NlcqfM6QKBgHlMrABtvBGKsn4bS3kTXUVD+S+aDclZr4e1YJTi3yIMwM5Eq7D9HjH+LnwI9xe9qZxkbC/wSa7nZxqp/SIsg6X6bEjAiOCfeBqDZQ+86GB2EA1EMdoJKmg9Nywrr00qJB1ZMmfyRiyJI3sEuEby72ykWMzcG7S8JY0jDh8u9MdpAoGBAIKWfCMihKhu4uFZSTq8OQmbzTpljZKp5slbGmYzMulXehndZuJXQe2hSuLFgS9iruhjYA8NVseLfR9gYpfguAtIjuKzBBMrD/i30Wqt0tpkZuzTeDoTUWW99UYyFqHKBAb20vas4UAzdqMDEwD4kIwvsJJw3eqkB9depM2jvRdxAoGBALx2r7Hydd6QYGPUGz+KikWrDU57cKEQyKWzF5TDYQtmBg0g4Yj4O7GG2KSLU18VLJPRU/lgue7GFwFe/DQmpMzP7os5wdl45aFQCSdq9keUze5TohhJkdLp7sWLV1sIQtr2z+RjAcso2mbSTG4+U3UgcDyy9m+LtcQdWglroMvM";

    /**
     * 签名方式
     */
    private String signType="RSA2";

    /**
     * 字符编码格式
     */
    private String  charset = "utf-8";

    /**
     * 超时时间
     */
    private String timeOut = "30m";

    public String getGateWayUrl() {
        return gateWayUrl;
    }

    public void setGateWayUrl(String gateWayUrl) {
        this.gateWayUrl = gateWayUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }
}
