package com.action;

import com.beans.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
    public class UserAction {
        //更改用户信息
         public String updateUser(SysUser user){
            return "";
            };
        //根据查询用户信息
         public String queryUserbyId(@Param("id") int id){
           return " ";
         };
        //查询所有用户
         public String  queryUser(@Param("account") String account,@Param("name") String name){
           return  "";
         };
        //修改所拥有权限
         public String updateMenu(){

           return " ";
         };


    }
