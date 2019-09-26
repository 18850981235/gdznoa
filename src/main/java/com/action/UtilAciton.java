package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.SysUser;
import com.service.bd.BdClientService;
import com.service.bd.BdProjectService;
import com.service.publics.PdfService;
import com.service.sys.ApprovalProcessService;
import com.service.sys.DeptService;
import com.service.sys.UserService;
import com.util.DeleteFileUtil;
import com.util.FileUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author 李鹏熠
 * @create 2019/3/22 11:05
 */
@Controller
@RequestMapping("/util")
public class UtilAciton {
    @Resource(name = "deptService")
    private DeptService deptService;
    @Resource(name = "bdClientService")
    private BdClientService bdClientService;
    @Resource(name = "bdProjectService")
    private BdProjectService bdProjectService;
    @Resource(name = "approvalProcessService")
    private ApprovalProcessService approvalProcessService;
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "pdfService")
    private PdfService pdfService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }


    @RequestMapping(value = "/getDeptUsers",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getDeptUsers(){
        return JSONObject.toJSONString(deptService.getDeptUsers(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/getDept",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getDept(){
        return JSONObject.toJSONString(deptService.getDeptList(0),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/getClient",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getClient(){
        return JSONObject.toJSONString(bdClientService.getClientName(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/fileDown")
    public void fileDown(HttpServletResponse response, @RequestParam String file,HttpSession session){
        FileUtils.downloadFile(response,file);
        if(file.endsWith(".pdf")){
            SysUser user=(SysUser)session.getAttribute("user");
            pdfService.add(user.getName(),file);
        }
    }
        //文件删除
    @RequestMapping(value = "/fileDelete")
    @ResponseBody
    public String  deleteFile(@RequestParam String file){
       boolean a= DeleteFileUtil.deleteFile(file);
        if(a){
           return "success";
        }else{
            return "false";
        }
    }
    @RequestMapping(value = "/getProject",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getProjectName(){
        return JSONObject.toJSONString(bdProjectService.getProjectName(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    @RequestMapping(value = "/approvalProcess",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getApprovalProcess(){
        return JSONObject.toJSONString(approvalProcessService.getProcessList(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/areaManagerUser",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAreaManagerUser(){
        return JSONObject.toJSONString(userService.areaManagerUser(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/getUser",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getUser(HttpServletRequest request){
        SysUser user=(SysUser)request.getSession().getAttribute("user");
        return JSONObject.toJSONString(user,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //查看财务模块项目权限
    @RequestMapping(value = "/getGCProject",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getGCProject(HttpSession session){
        int userid=(int)session.getAttribute("userId");
//        int userid=1;
        return JSONObject.toJSONString(bdProjectService.getGCProject(userid),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }


}
