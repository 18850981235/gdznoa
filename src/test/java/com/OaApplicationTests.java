package com;

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



    @Test
    public void contextLoads() {
        int []arr=new  int [38];
        for (int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        authorityService.add(arr,1);
    }

}
