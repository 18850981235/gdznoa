package com.service;

import com.OaApplicationTests;
import com.beans.McPersonnelDispatched;
import com.service.bd.BdProjectService;
import com.service.mc.McPersonnelDispatchedService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


public class BdProjectServiceTest extends OaApplicationTests {
    @Autowired
    private BdProjectService bdProjectService;

    @Autowired
    private McPersonnelDispatchedService mcPersonnelDispatchedService;
    @Test
    public void list(){
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
}