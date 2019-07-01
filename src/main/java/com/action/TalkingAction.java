package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.PubTalking;
import com.service.publics.TalkingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Talking")
public class TalkingAction {

@Resource(name="TalkingService")
    private TalkingService talkingService;


//region~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~用户端~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 进入到聊天界面
@RequestMapping(value="/Talking/enterTalking" , produces = "text/html;charset=UTF-8")
@ResponseBody
    public String enterTalking(HttpSession session,
       @RequestParam(required = false, defaultValue = "0")  int pageIndex){
//        int userId=(int)session.getAttribute("userId");
    int userId=14;
        return JSONObject.toJSONString(talkingService.getTalkingByUserId(userId,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    // 进入发送信息
    @RequestMapping(value="/Talking/sentTalking" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String sentTalking(HttpSession session,PubTalking pubTalking){
//        int userId=(int)session.getAttribute("userId");
        int userId=14;
        pubTalking.setOriginator(userId);

        if( pubTalking.getReceive()==0){
            pubTalking.setReceive(1);
        }

       int i= talkingService.addTalk(pubTalking);
        if(i==0){
            return " ";
        }else {
            return "";
        }
    };


//endregion

    //region~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~管理员端~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //查询已有成员和未读消息数
    @RequestMapping(value="/Talking/queryoriginator" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryoriginator(HttpSession session ){
//        int userId=(int)session.getAttribute("userId");
        int userId=1;
        return JSONObject.toJSONString( talkingService.queryoriginator(userId),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };


    //点击成员查看与其的聊天
    @RequestMapping(value="/Talking/enterTalkingwhih" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String enterTalkingwhih(@RequestParam(required = false, defaultValue = "0")  int userId,
                               @RequestParam(required = false, defaultValue = "0")  int pageIndex){
        return JSONObject.toJSONString( talkingService.getTalkingByUserId(userId,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    //查看新的消息列表
    @RequestMapping(value="/Talking/getNewContent" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getNewContent(HttpSession session){
//        int userId=(int)session.getAttribute("userId");
        int userId=1;
        return JSONObject.toJSONString( talkingService.getNewContent(userId),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
//管理员发消息，改变信息状态！
// 进入发送信息
    @RequestMapping(value="/Talking/adminSentTalking" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String adminSentTalking(HttpSession session,PubTalking pubTalking){
//        int userId=(int)session.getAttribute("userId");
        int userId=1;
        pubTalking.setOriginator(userId);


        return JSONObject.toJSONString( talkingService.addAdminTalk(pubTalking),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };

    //成员

    //endregion
}
