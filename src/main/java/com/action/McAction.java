package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.McStamp;
import com.service.mc.McFileBorrowService;
import com.service.mc.McPersonnelDispatchedService;
import com.service.mc.McStampService;
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
 * @create 2019/3/20 8:48
 */
@Controller
@RequestMapping("/mc")
public class McAction {

    @Resource(name = "mcPersonnelDispatchedService")
    private McPersonnelDispatchedService mcPersonnelDispatchedService;
    @Resource(name = "mcFileBorrowService")
    private McFileBorrowService mcFileBorrowService;
    @Resource(name = "mcStampService")
    private McStampService mcStampService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }
    @RequestMapping("/stamp/query")
    public String showStamp(){
        return "";
    }
    @RequestMapping(value = "/stamp/query.html", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String StampList(@RequestParam(required = false)String stampType,
                            @RequestParam(required = false, defaultValue = "0")int deptid,
                            @RequestParam(required = false)Date start,
                            @RequestParam(required = false)Date end,
                            @RequestParam(required = false, defaultValue = "0")int pageIndex,
                            HttpSession session){
        int userid=(int) session.getAttribute("userId");
        mcStampService.getList(stampType,deptid,userid,start,end,pageIndex);
        return JSONObject.toJSONString(mcStampService.getList(stampType,deptid,userid,start,end,pageIndex), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping("/stamp/add")
    public String showAddStamp(){
        return "";
    }
    @RequestMapping("/stamp/add.html")
    public String AddStamp(McStamp mcStamp){
        mcStampService.add(mcStamp);
        return "";
    }
}