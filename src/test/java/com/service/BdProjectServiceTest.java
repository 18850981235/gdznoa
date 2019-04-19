package com.service;

import com.OaApplicationTests;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.McPersonnelDispatched;
import com.service.bd.BdProjectService;
import com.service.mc.McPersonnelDispatchedService;
import com.service.mc.McStampService;
import com.service.sys.AuthorityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;


public class BdProjectServiceTest extends OaApplicationTests {
    @Autowired
    private McStampService mcStampService;

    @Autowired
    private MyWorkService myWorkService;

    @Autowired
    @Resource(name = "bdProjectService")
    private BdProjectService bdProjectService;

    @Resource(name = "authorityService")
    private AuthorityService authorityService;

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
       // System.out.println(mcPersonnelDispatchedService.add(m));
    }


    @Test
    public void setMcStampService(){
        System.out.println(JSONObject.toJSONString(mcStampService.getList(null,0,1,null,null,1), SerializerFeature.DisableCircularReferenceDetect));
    }
    @Test
    public void myWork(){
        //System.out.println(JSONObject.toJSONString(myWorkService.getList(7), SerializerFeature.DisableCircularReferenceDetect));
       /* System.out.println(JSONObject.toJSONString( bdProjectService.getProjectById(1),
                SerializerFeature.DisableCircularReferenceDetect));*/
    }
    @Test
    public void aa(){
        int [] arr={73,80,85,90,94,98,102,139,142,144,147,149,152,160,161,162,163,164,165,166};

        for(int i=11;i<21;i++){
            authorityService.add(arr,i);
        }
    }

}