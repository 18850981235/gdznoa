package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.service.sys.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 李鹏熠
 * @create 2019/3/22 11:05
 */
@Controller
@RequestMapping("/util")
public class UtilAciton {
    @Resource(name = "deptService")
    private DeptService deptService;

    @RequestMapping("/foundUser")
    @ResponseBody
    public String foundUser(String name,int id){
        Map map=new HashMap();
        map.put("name",name);
        map.put("id",id);
        return JSONObject.toJSONString(map);
    }

    @RequestMapping(value = "/getDeptUsers",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getDeptUsers(){
        return JSONObject.toJSONString(deptService.getDeptUsers(),SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/getDept",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getDept(){
        return JSONObject.toJSONString(deptService.getDeptList(0),SerializerFeature.DisableCircularReferenceDetect);
    }
}