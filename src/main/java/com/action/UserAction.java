package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.Requestsp;
import com.beans.RequestspErmissions;
import com.beans.SysUser;
import com.service.sys.AuthorityService;
import com.service.sys.SysRequestspService;
import com.service.sys.SysUserService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
    public class UserAction {
    @Resource(name="authorityService")
    private AuthorityService authorityService;
    @Resource(name="SysUserService")
    private SysUserService sysUserService;
    @Resource(name="SysRequestspService")
    private SysRequestspService sysRequestspService;


    @RequestMapping(value = "/useraction/queryUser", produces = "application/json; charset=utf-8")
    @ResponseBody
        //查询所有用户
         public String  queryUser(@Param("account") String account,@Param("name") String name,@Param("pageIndex")int pageIndex){
             return JSONObject.toJSONString( sysUserService.queryUser(account, name,pageIndex),
                     SerializerFeature.DisableCircularReferenceDetect,
                     SerializerFeature.WriteNullStringAsEmpty);
         };
    //根据查询用户信息
    @RequestMapping(value = "/useraction/queryUserbyId", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryUserbyId(@Param("id") int id){
        return JSONObject.toJSONString( sysUserService.querybyId(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    //更改用户信息
    @RequestMapping(value = "/useraction/updateUser", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateUser(SysUser user){
       int i= sysUserService.updateUser(user);
       if (i==1) {return "";}
       else{
           return ""
;
       }
    };

    //添加用户申请
    //更改用户信息
    @RequestMapping(value = "/useraction/addRequest", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addRequest(Requestsp requestsp, HttpServletRequest request){
        int i= sysUserService.addyReques(requestsp,request);
        if (i==1) {return "";}
        else{
            return ""
                    ;
        }
    };

    //添加完跳转到申请权限界面
    @RequestMapping(value = "/useraction/addRequest", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getrequestidbyuser(HttpSession session){
      int   userid=(int) session.getAttribute("userId");
        return JSONObject.toJSONString( sysRequestspService.getRequestspby(userid),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };

    //添加到申请权限里面
    @RequestMapping(value = "/useraction/addRequest", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addErmissions(Requestsp requestsp, List<RequestspErmissions> List){
        int i=sysUserService.add(List,requestsp);
                if(i>0){
                    return "";
                }else{
                    return "";
                }
    };


    //查询用户自身的申请
    @RequestMapping(value = "/useraction/queryRequestspbymyselef", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryRequestspbymyselef(@Param("userid") int userid, @Param("pageIndex") int pageIndex, HttpSession session){
         userid=(int) session.getAttribute("userId");
        return JSONObject.toJSONString( sysUserService.queryRequestbyuserid(userid, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    //查询某用户的申请
    @RequestMapping(value = "/useraction/queryRequestspbyuser", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryRequestspbyuser(@Param("userid") int userid,@Param("pageIndex") int pageIndex){
        return JSONObject.toJSONString( sysUserService.queryRequestbyuserid(userid, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    //查询ID申请
    @RequestMapping(value = "/useraction/queryRequestspbyid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryRequestspbyid(@Param("id") int id){
        return JSONObject.toJSONString( sysUserService.queryRequestbyuserid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    //查询某用户的某条申请
    @RequestMapping(value = "/useraction/queryRequestspbyid", produces = "application/json; charset=utf-8")
    @ResponseBody

    public String queryErmissionbyid(@Param("quesid")int quesid,@Param("userid")int userid){
        return JSONObject.toJSONString( sysUserService.getListErmissions(quesid, userid),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };

    //查询某用户的某条申请
    @RequestMapping(value = "/useraction/queryRequestspbyid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getallMenuanduser(@Param("quesid")int quesid,@Param("userid")int userid){
        return JSONObject.toJSONString( sysUserService.getallMenu(quesid, userid),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };



    //更改用户权限
    @RequestMapping(value = "/useraction/updateMenu", produces = "application/json; charset=utf-8")
    @ResponseBody
        //修改所拥有权限
         public String updateMenu(int userid, int[] arr){
            boolean b= authorityService.updateAuthority(userid, arr);
            if (b) {
                return " ";
            }else{
                return  " ";
            }
         };




    }
