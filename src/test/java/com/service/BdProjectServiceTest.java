package com.service;

import com.OaApplicationTests;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;



public class BdProjectServiceTest extends OaApplicationTests {
    @Autowired
    private BdProjectService bdProjectService;

    @Test
    public void list(){
        System.out.println(JSONObject.toJSONString(bdProjectService.getProjectById(1)));
    }

}