package com.example.demo.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.example.demo.service.PaymentService;
import com.example.demo.utils.AliPayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName Payment
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/20 10:26
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private AliPayUtils aliPayUtils;

    @Override
    public String aliPayConnect() {
        //1、获得初始化的AlipayClient
        String result;
        AlipayTradeAppPayRequest alipayTradeAppPayRequest = new AlipayTradeAppPayRequest();
        AlipayClient apAlipayClient = new DefaultAlipayClient(aliPayUtils.getGateWayUrl(), aliPayUtils.getAppId(), aliPayUtils.getMerchantPrivateKey(),
                AlipayConstants.FORMAT_JSON, AlipayConstants.CHARSET_UTF8, aliPayUtils.getAlipayPublicKey(), AlipayConstants.SIGN_TYPE_RSA2);
        AlipayTradeAppPayModel payModel = new AlipayTradeAppPayModel();
        payModel.setSubject("测试");
        payModel.setOutTradeNo("2088102178899205");
        payModel.setTimeoutExpress(aliPayUtils.getTimeOut());
        payModel.setTotalAmount("0.01");
        alipayTradeAppPayRequest.setBizModel(payModel);
        try {
            result = apAlipayClient.pageExecute(alipayTradeAppPayRequest).getBody();
        } catch (AlipayApiException e) {
            result = "支付失败";
        }
        System.out.println("result = " + result);
        return result;
    }
}
