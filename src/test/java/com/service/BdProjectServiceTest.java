package com.service;

import com.OaApplicationTests;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.McPersonnelDispatched;
import com.service.mc.McPersonnelDispatchedService;
import com.service.mc.McStampService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;


public class BdProjectServiceTest extends OaApplicationTests {
    @Autowired
    private McStampService mcStampService;

    @Autowired
    private McPersonnelDispatchedService mcPersonnelDispatchedService;
    @Test
    public void add(){
        McPersonnelDispatched m=new McPersonnelDispatched();
        m.setDeptid(1);
        m.setCreatetime(new Date());
        m.setProjectid(3);
        m.setDemand("派遣内容");
        m.setUserid(1);
        m.setEvectionTime(new Date());
        m.setEvectionCost(1000);
        m.setProcessid(9);
        m.setProcessUserid(6);
        m.setProcessState("进行中");
        System.out.println(mcPersonnelDispatchedService.add(m));
    }

    @Test
    public void list(){
        System.out.println(JSONObject.toJSONString(mcPersonnelDispatchedService.getList(1)));
    }

    @Test
    public void setMcStampService(){
        System.out.println(JSONObject.toJSONString(mcStampService.getList(null,0,1,null,null,1), SerializerFeature.DisableCircularReferenceDetect));
    }

}