package com.action;

import com.alibaba.fastjson.JSONObject;
import com.service.sys.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 李鹏熠
 * @create 2019/2/26 8:56
 */
@Controller
@RequestMapping("/sys")
public class SysAction {
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "menuService")
    private MenuService menuService;
    @Resource(name = "authorityService")
    private AuthorityService authorityService;
    @Resource(name = "deptService")
    private DeptService deptService;

    @RequestMapping(value = "/dept/query.json",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String showQuery(){
        return JSONObject.toJSONString(deptService.getDeptList(0));
    }


}