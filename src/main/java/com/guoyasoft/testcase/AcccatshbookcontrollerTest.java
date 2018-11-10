package com.guoyasoft.testcase;

import com.alibaba.fastjson.JSON;
import com.guoyasoft.bean.login.LoginReq;
import com.guoyasoft.bean.login.LoginResp;
import com.guoyasoft.tools.HttpTools;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @Auther: xuepl
 * @Date: 2018/11/10 15:12
 * @Description:
 */
public class AcccatshbookcontrollerTest {
    @Test
    public void testLogin(){
        LoginReq loginReq = new LoginReq();
        loginReq.setUserName("xuepl");
        loginReq.setPwd("aaaaaa");

        String reqJson = JSON.toJSONString(loginReq, true);
        System.out.println("------------------------请求数据-------------");
        System.out.println(reqJson);

        String respString = HttpTools.doPostByJson("http://qa.guoyasoft.com:8080/user/login", reqJson, "UTF-8");
        System.out.println("-------------------------响应正文----------------------");
        System.out.println(respString);

        LoginResp loginResp = JSON.parseObject(respString, LoginResp.class);
        String respCode = loginResp.getRespCode();
        System.out.println("-----------------------respCode-------------------");
        System.out.println(respCode);

        Assert.assertEquals(respCode,"9999");
    }
}
