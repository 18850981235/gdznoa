package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.PubTalking;
import com.service.publics.TalkingService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/Talking")
public class

TalkingAction {

@Resource(name="TalkingService")
    private TalkingService talkingService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }


//region~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~用户端~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 进入到聊天界面
@RequestMapping("/Talking/UserPage")
public String UserPage() {
    return "/";
}
//进入到用户聊天界面所需数据
@RequestMapping(value="/Talking/enterTalking" , produces = "text/html;charset=UTF-8")
@ResponseBody
    public String enterTalking(HttpServletRequest request,
                               @RequestParam(required = false, defaultValue = "0")  int pageIndex){
      int userId = (int)request.getSession().getAttribute("userId");
//            int userId=14;
        return JSONObject.toJSONString(talkingService.getTalkingByUserId(userId,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    // 进入发送信息
    @RequestMapping(value="/Talking/sentTalking" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String sentTalking(HttpServletRequest request,String content){
        int userId = (int)request.getSession().getAttribute("userId");
        PubTalking pubTalking=new PubTalking();
        pubTalking.setContent(content);
//        int userId=14;
        pubTalking.setOriginator(userId);


            pubTalking.setReceive(1);
        pubTalking.setTime(new Date());
       int i= talkingService.addTalk(pubTalking);
        if(i>0){
            return "yes";
        }else {
            return "no";
        }
    };


//endregion

//region~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~管理员端~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // 进入到聊天界面
    @RequestMapping("/Talking/AllUserPage")
    public String AllUserPage() {
        return "/";
    }
    //查询已有成员和未读消息数
    @RequestMapping(value="/Talking/queryoriginator" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryoriginator(HttpServletRequest request ){
        int userId = (int)request.getSession().getAttribute("userId");
//        int userId=1;
        return JSONObject.toJSONString( talkingService.queryoriginator(userId),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };

    @RequestMapping("/Talking/adminUserTalkPage")
    public String adminUserTalkPage() {
        return "/";
    }
    //点击成员查看与其的聊天
    @RequestMapping(value="/Talking/enterTalkingwhih" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String enterTalkingwhih(@RequestParam(required = false, defaultValue = "0")  int userId,
                               @RequestParam(required = false, defaultValue = "0")  int pageIndex){
        return JSONObject.toJSONString( talkingService.getTalkingByUserId(userId,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    @RequestMapping("/Talking/newContetPage")
    public String newContetPage() {
        return "/";
    }
    //查看新的消息列表
    @RequestMapping(value="/Talking/getNewContent" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getNewContent(HttpServletRequest request){
        int userId = (int)request.getSession().getAttribute("userId");
//        int userId=1;
        return JSONObject.toJSONString( talkingService.getNewContent(userId),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    @RequestMapping("/Talking/adminUserPage")
    public String adminUserPage() {
        return "/";
    }
//管理员发消息，改变信息状态！
// 进入发送信息
    @RequestMapping(value="/Talking/adminSentTalking" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String adminSentTalking(HttpServletRequest request,PubTalking pubTalking){
     int userId = (int)request.getSession().getAttribute("userId");
//        int userId=1;
        pubTalking.setOriginator(userId);
        pubTalking.setTime(new Date());
        return JSONObject.toJSONString( talkingService.addAdminTalk(pubTalking),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };

    //成员

    //endregion
}
