package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.Requestsp;
import com.beans.RequestspErmissions;
import com.beans.SysUser;
import com.service.sys.AuthorityService;
import com.service.sys.SysRequestspService;
import com.service.sys.SysUserBillServce;
import com.service.sys.SysUserService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
    public class UserAction {
    @Resource(name = "authorityService")
    private AuthorityService authorityService;
    @Resource(name = "SysUserService")
    private SysUserService sysUserService;
    @Resource(name = "SysRequestspService")
    private SysRequestspService sysRequestspService;
    @Resource(name = "SysUserBillServce")
    private SysUserBillServce sysUserBillServce;




    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }


    //region~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~用户端~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @RequestMapping("/user/updateself")
    public String updateMyself() {
        return "/background/user-on/user";
    }
//根据查询用户信息
    @RequestMapping(value = "/useraction/queryUserbySelf", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryUserbySelf(HttpServletRequest request ) {
        int id = (int) request.getSession().getAttribute("userId");
////        int id=16;
        return JSONObject.toJSONString(sysUserService.querybyId(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };

    //更改用户信息
    @RequestMapping(value = "/useraction/updateUser", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateUser(HttpServletRequest request , SysUser user) {
        int userId = (int) request.getSession().getAttribute("userId");
        user.setId(userId);
        int i = sysUserService.updateUser(user);
        if (i == 1) {
            return "yes";
        } else {
            return "no";
        }
    } ;

    //用户信息
    @RequestMapping(value = "/useraction/getLoginUser", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getLoginUser(HttpServletRequest request) {
        int userId = (int) request.getSession().getAttribute("userId");
//        int userId=15;
        return JSONObject.toJSONString(sysUserService.querybyId(userId),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }



//    //添加完跳转到申请权限界面
//    @RequestMapping(value = "/useraction/getrequestidbyuser", produces = "application/json; charset=utf-8")
//    @ResponseBody
//    public String getrequestidbyuser(HttpSession session) {
////      int   userid=(int) session.getAttribute("userId");
//        int userid = 1;
//        return JSONObject.toJSONString(sysRequestspService.getRequestspby(userid),
//                SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteNullStringAsEmpty);
//    }

    ;

//    //添加到申请权限里面
//    @RequestMapping(value = "/useraction/addErmissions", produces = "application/json; charset=utf-8")
//    @ResponseBody
//    public String addErmissions(Requestsp requestsp, List<RequestspErmissions> List) {
//        int i = sysUserService.add(List, requestsp);
//        if (i > 0) {
//            return "";
//        } else {
//            return "";
//        }
//    }

//    ;
//校验密码
@RequestMapping(value = "/useraction/checkpassword", method = RequestMethod.POST)
@ResponseBody
public String  checkpassword(  @RequestParam String password,
                               HttpServletRequest request) {
    int userId=(int) request.getSession().getAttribute("userId");
    SysUser user = sysUserService.querybyId(userId);
    if (user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
          return JSONObject.toJSONString("yes",
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }else{
        return JSONObject.toJSONString("no",
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);}
};
    //修改密码
    @RequestMapping(value = "/useraction/updatepassword", method = RequestMethod.POST)
    @ResponseBody
    public String  updatepassword(  @Param("password") String password,
                                    HttpServletRequest request ) {
        int userId=(int) request.getSession().getAttribute("userId");
            int a = sysUserService.updatePassword(userId,DigestUtils.md5DigestAsHex(password.getBytes()));

            if (a > 0) {
                return "yes";

            } else {
                return "no";
            }

    };
      //用户登录自身查看用户自身的申请
    @RequestMapping(value = "/useraction/queryRequestspbymyselef", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryRequestspbymyselef(@RequestParam(required = false, defaultValue = "0") int userid,
                                          Requestsp requestsp,
                                          HttpServletRequest request) {
         userid=(int) request.getSession().getAttribute("userId");
        String s ="已有";
        int a= sysUserService.queryrequst(userid);
        if(a>0){
                return s;
        }else{
            int i = sysUserService.addyReques(requestsp, request);
            if (i == 1) {
                return "成功";
            } else {
                return "失败";
            }
        }

    }
    //用户登录自身查看用户自身和所有的菜单
    @RequestMapping(value = "/useraction/queryAllMunebymyselef", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryAllMunebymyselef(  HttpServletRequest request) {
        int  userid=(int) request.getSession().getAttribute("userId");
//        int userid=15;
        return JSONObject.toJSONString(sysUserService.queryAllMunebymyselef(userid),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    ;

    //查询用户消费信息
    @RequestMapping(value = "/useraction/queryUserBillbyId", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryUserBillbyId(  HttpServletRequest request,
                                    @RequestParam(required = false, defaultValue = "0") int pageIndex) {
                   int userId=(int) request.getSession().getAttribute("userId");
//        int userId = 16;
        return JSONObject.toJSONString(sysUserBillServce.querybillbyuserid(userId, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    ;
    //endregion~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~用户端结束~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//region~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~管理员端~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping(value = "/useraction/queryUser", produces = "application/json; charset=utf-8")
    @ResponseBody
    //查询所有用户
    public String queryUser(@Param("account") String account, @Param("name") String name,
                            @RequestParam(required = false, defaultValue = "0") int pageIndex) {
        if (account == "" || account == null) {
            account = null;
        }
        if (name == "" || name == null) {
            name = null;
        }
        return JSONObject.toJSONString(sysUserService.queryUser(account, name, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    } ;

    @RequestMapping("/user/updateUserPage")
    public String updateUserPage() {
        return "/background/user-on/user-administration";
    }

    //根据查询用户信息
    @RequestMapping(value = "/useraction/queryUserbyId", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryUserbyId(@Param("id") int id) {
        return JSONObject.toJSONString(sysUserService.querybyId(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };

    @RequestMapping("/user/questPage")
    public String questPage() {
        return "/background/user-on/administration";
    }

    //更改用户信息
    @RequestMapping(value = "/useraction/adminUpdateUser", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String adminUpdateUser(SysUser user) {
        int i = sysUserService.updateUser(user);
        if (i >0) {
            return "yes";
        } else {
            return "no";
        }
    }

    ;

    //根据用户用户名和日期查询某用户的申请
    @RequestMapping(value = "/useraction/queryRequestspbyuser", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryRequestspbyuser(@Param("name") String name, @RequestParam(required = false) Date StartTime,
                                       @RequestParam(required = false) Date EndTime,
                                       @RequestParam(required = false, defaultValue = "0") int pageIndex) {
        if (name == null || name == "") {
            name = null;
        }
        if (StartTime == null) {
            StartTime = null;
        }
        if (EndTime == null  ) {
            EndTime = null;
        }
        return JSONObject.toJSONString(sysUserService.queryRequestbyuserid(name, StartTime, EndTime, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    ;

    //根据申请ID查看申请
    @RequestMapping(value = "/useraction/queryRequestspbyid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryRequestspbyid(@RequestParam(required = false, defaultValue = "0") int id) {
        return JSONObject.toJSONString(sysUserService.queryRequestbyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    //根据申请ID查看申请
    @RequestMapping(value = "/useraction/updateRequestspbyid", produces = "application/json; charset=utf-8")
    public String updateRequestspbyid(@Param("id") int id,Model model) {
        int a=sysRequestspService.updatetRequestsp(id,"同意！");
        model.addAttribute("id",id);
        if(a>0){
            return "/background/user-on/user-adminstration";
        }else {
            return "";
        }

    };
    //根据申请ID查看申请
    @RequestMapping(value = "/useraction/unRequestspbyid", produces = "application/json; charset=utf-8")
    public String unRequestspbyid(@Param("id") int id) {
    int a=sysRequestspService.updatetRequestsp(id,"审批为被拒绝，请审核资料！");
    if(a>0){
        return "/background/user-on/administration";
    }else {
        return "";
    }

    };

//    //获取某用户某条申请的权限
//    @RequestMapping(value = "/useraction/queryErmissionbyid", produces = "application/json; charset=utf-8")
//    @ResponseBody
//    public String queryErmissionbyid(@RequestParam(required = false, defaultValue = "0") int quesid,
//                                     @RequestParam(required = false, defaultValue = "0") int userid) {
//        return JSONObject.toJSONString(sysUserService.getListErmissions(quesid, userid),
//                SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteNullStringAsEmpty);
//    }

    ;

    //查询某用户的某条申请的权限和全部权限（管理员设置用）
    @RequestMapping(value = "/useraction/getallMenuanduser", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getallMenuanduser(@Param("userid") int userid) {
        return JSONObject.toJSONString(sysUserService.getallMenu(userid),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    } ;

    //更改用户权限（管理员设置）
    @RequestMapping(value = "/useraction/updateMenu", produces = "application/json; charset=utf-8")
    @ResponseBody
    //修改所拥有权限
    public String updateMenu(@Param("userid")int userid,@Param("array") String array) {
        if(array!=null&&array!=""){
        String[] split = array.split(",");
        int[] arr = new int[split.length];
        for(int i=0;i<split.length;i++){
            arr[i] = Integer.parseInt(split[i]);
        }
        boolean b = authorityService.updateAuthority(userid, arr);
        if (b) {
            return "yes";
        } else {
            return "no";
        }
        }return "nothing";
    };


//endregion~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~管理员端结束~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


}














