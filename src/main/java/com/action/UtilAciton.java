package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.service.bd.BdClientService;
import com.service.bd.BdProjectService;
import com.service.sys.ApprovalProcessService;
import com.service.sys.DeptService;
import com.util.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


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

    @RequestMapping("/foundUser")
    @ResponseBody
    public String foundUser(String name,int id){
        Map map=new HashMap();
        map.put("name",name);
        map.put("id",id);
        return JSONObject.toJSONString(map);
    }

    @RequestMapping(value = "/getDeptUsers",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getDeptUsers(){
        return JSONObject.toJSONString(deptService.getDeptUsers(),SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/getDept",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getDept(){
        return JSONObject.toJSONString(deptService.getDeptList(0),SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/getClient",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getClient(){
        return JSONObject.toJSONString(bdClientService.getClientName(),SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping(value = "/fileDown")
    public void fileDown(HttpServletResponse response, @RequestParam String file){
        FileUtils.downloadFile(response,file);
    }
    @RequestMapping(value = "/getProject",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getProjectName(){
        return JSONObject.toJSONString(bdProjectService.getProjectName(),SerializerFeature.DisableCircularReferenceDetect);
    }
    @RequestMapping(value = "/approvalProcess",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getApprovalProcess(){
        return JSONObject.toJSONString(approvalProcessService.getProcessList(),SerializerFeature.DisableCircularReferenceDetect);
    }
}
