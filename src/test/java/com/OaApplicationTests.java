package com;

import com.beans.SysApprovalDetailed;
import com.service.bd.BdProjectService;
import com.service.mc.McStampService;
import com.service.sys.AuthorityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OaApplicationTests {

    @Resource(name = "authorityService")
    private AuthorityService authorityService;
    @Resource(name = "mcStampService")
    private McStampService mcStampService;
    @Resource(name = "bdProjectService")
    private BdProjectService bdProjectService;


    @Test
    public void contextLoads() {
        int[] arr = new int[42];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        authorityService.add(arr, 31);
    }

    @Test
    public void approval(){
        SysApprovalDetailed a=new SysApprovalDetailed();
        a.setApprovalName("项目立项");
        a.setApprovalId(1);
        a.setApprovalUser(32);
        a.setState("通过");
        a.setApprovalDate(new Date());
        a.setOpinion("通过");
        bdProjectService.addProjectApproval(a);
    }
    @Test
    public void approval2(){
        SysApprovalDetailed a=new SysApprovalDetailed();
        a.setApprovalId(3);
        a.setApprovalUser(15);
        a.setState("通过");
        a.setApprovalDate(new Date());
        a.setOpinion("通过");
        mcStampService.addProjectApproval(a);
    }

}
