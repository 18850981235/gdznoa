package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.service.MyWorkService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 李鹏熠
 * @create 2019/4/18 14:23
 */
@Controller
public class MyWork {

    @Resource(name = "myWorkService")
    private MyWorkService myWorkService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }

    @RequestMapping("/myWork")
    @ResponseBody
    public String myWork(@RequestParam(required = false, defaultValue = "0") int processid,
                         @RequestParam(required = false, defaultValue = "0") int id,
                         @RequestParam(required = false) Date start,
                         @RequestParam(required = false) Date end,
                         @RequestParam(required = false, defaultValue = "0") int pageIndex,
                         HttpSession session) {
        int userid = (int) session.getAttribute("userId");
        //int userid=6;
        return JSONObject.toJSONString(myWorkService.getList(userid, processid, id, start, end, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping("/showMyWork")
    public String showMyWork() {
        return "/mc/top/my-work";
    }





    @RequestMapping("/mc/borrow/approval")
    public String showMyBorrow() {
        return "/mc/top/myBorrow";
    }

    @RequestMapping("/mc/dispatched/approval")
    public String showMyDispatch() {
        return "/mc/top/myDispatch";
    }

    @RequestMapping("/mc/materials/approval")
    public String showMyMaterial() {
        return "/mc/top/myMaterial";
    }

    @RequestMapping("/bd/project/approval")
    public String showMyProject() {
        return "/mc/top/myProject";
    }

    @RequestMapping("/mc/stamp/approval")
    public String showMyStamp() {
        return "/mc/top/myStamp";
    }
}