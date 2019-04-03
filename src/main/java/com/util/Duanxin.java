package com.util;

import com.alibaba.fastjson.JSONObject;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.stereotype.Component;

import javax.naming.Name;
import javax.servlet.http.HttpSession;
import java.util.Random;


public class Duanxin {
    private static String apiUrl = "https://sms_developer.zhenzikj.com";
    private static String appId = "100391";
    private static String appSecret = "MzQwZTZlMzMtOWNkNy00OTk2LWIxZTgtYmYzYWU0NWIzYWUz";
    public static String  verify(String mobile,String verifyCode){
        try {
            JSONObject json = null;
            json = new JSONObject();
            //发送短信
            ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
            String result = client.send(mobile, "您的验证码为:" + verifyCode + "，该码有效期为5分钟，该码只能使用一次!李鹏熠测试");
            String a= client.balance();
            json = JSONObject.parseObject(result);
            if (json.getIntValue("code") != 0) {//发送短信失败
                return "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
