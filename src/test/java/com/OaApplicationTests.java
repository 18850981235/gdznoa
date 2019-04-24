package com;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.service.mc.McStampService;
import com.service.sys.AuthorityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OaApplicationTests {

    @Resource(name = "authorityService")
    private AuthorityService authorityService;
    @Resource(name = "mcStampService")
    private McStampService mcStampService;

    @Test
    public void contextLoads() {
        int[] arr = new int[42];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        authorityService.add(arr, 31);
    }

    @Test
    public void stampList(){
        System.out.println(JSONObject.toJSONString(mcStampService.getList(null,0,0,null,null,0),
                SerializerFeature.DisableCircularReferenceDetect));
    }
}
