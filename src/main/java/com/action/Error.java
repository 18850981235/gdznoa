package com.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 李鹏熠
 * @create 2019/3/20 16:49
 */
@Controller
public class Error {

    @RequestMapping("/404")
    public  String error404(){
        return "404";
    }

    @RequestMapping("/500")
    public  String error500(){
        return "500";
    }


}