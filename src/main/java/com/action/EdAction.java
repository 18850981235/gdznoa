package com.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.*;
import com.service.ed.EdMessageService;
import com.service.ed.EdMessageStaffService;
import com.service.sd.SdSalesContractInventoryService;
import com.service.sd.SdSalesContractservice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ed")
public class EdAction {

    @Resource(name="EdMessageService")
    private EdMessageService edMassageService;
    @Resource(name="MessageStaffService")
   private EdMessageStaffService edMessageStaffService;
    @Resource(name="SdSalesContractInventoryService")
    private SdSalesContractInventoryService sdSalesContractInventoryService;
    @Resource(name = "SdSalesContractService")
    private SdSalesContractservice sdSalesContractservice;



    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~工程基础信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //我的工作：添加审批流程
    @RequestMapping("/EdMassage/EdMassageParticular")
    public String EdMassageParticular(SysApprovalDetailed approvalDetailed, HttpServletRequest request) {
        int userid = (int)request.getSession().getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        edMassageService.addMassageApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }


    //添加工程基础
    @RequestMapping("/EdMassage/toAddMassagePage")
    public String toAddMassagePage() {
        return "/engineering/basics/basicsAdd";
    }

    @RequestMapping("/EdMassage/AddMassage")
    public String AddMassage(EdMessage edMessage, HttpServletRequest request) {
        int a=edMassageService.addPdProcurement(edMessage, request);
        if(a>0){
            return "/engineering/basics/basicsList";
        }else {
            return "/engineering/basics/basicsAdd";
        }
    }
    //删除工程基础
    @RequestMapping("/EdMassage/deleteMassage")
    public String deleteMassage(@Param("id")int id) {
        int a=edMassageService.deletePdProcurement(id);
        if(a>0){
            return "/engineering/basics/basicsList";
        }else {
            return "/engineering/basics/basicsList";
        }
    }
    //修改工程基础

    @RequestMapping("/EdMassage/toupdateMassagePage")
    public String toupdateMassagePage() {
        return "/engineering/basics/basicsPadute";
    }

    @RequestMapping("/EdMassage/updateMassage")
    public String updateMassage(EdMessage edMessage, HttpServletRequest request) {
        int a=edMassageService.updateProcurement(edMessage, request);
        if(a>0){
            return "/engineering/basics/basicsList";
        }else {
            return "/engineering/basics/basicsPadute";
        }
    }

    @RequestMapping("/EdMassage/MassageParticular")
    @ResponseBody
    public String MassageParticular(@RequestParam int id) {
        return JSONObject.toJSONString(edMassageService.getDetailById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //单挑详情工程基础
    @RequestMapping("/EdMassage/toQueryOneMassagePage")
    public String toQueryOneMassagePage() {
        return "/engineering/basics/basicsParticular";
    }

    @RequestMapping("/EdMassage/QueryOneMassage")
    @ResponseBody
    public String QueryOneMassage(@Param("id")int id) {
        return JSONObject.toJSONString(edMassageService.queryById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }




    //单挑详情工程基础
    @RequestMapping("/message/query")
    public String QuerySomeMassagePage() {
        return "/engineering/basics/basicsList";
    }

    @RequestMapping("/EdMassage/QuerySomeMassage")
    @ResponseBody
    public String QuerySomeMassage(@RequestParam(required = false, defaultValue = "0") int projectid,
                                   @RequestParam(required = false) String  site,
                                   @RequestParam(required = false, defaultValue = "0") int  deptid ,
                                   @RequestParam(required = false, defaultValue = "0") int clientid,
                                   @RequestParam(required = false, defaultValue = "0")int pageIndex,
                                    HttpServletRequest request) {
//        SysUser user = (SysUser) request.getSession().getAttribute("user");
//        int userid=user.getId();
//
//        if (user.getRoleid()==8){
//            userid=0;
//        }
            int userid=0;
        if(site==null||site==""){
            site=null;
        }
        return JSONObject.toJSONString(edMassageService.queryBySome(projectid, site,userid, deptid, clientid, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }




    //endregion ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~工程基础信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~工程施工人员信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



    //添加工程人员基础
    @RequestMapping("/EdMassageStaff/toAddMassageStaffPage")
    public String toAddMassageStaffPage() {
        return "/engineering/personnel/personnelAdd";
    }

    @RequestMapping("/EdMassageStaff/AddMassageStaff")
    public String AddMassageStaff(EdMessageStaff edMessageStaff, HttpServletRequest request) {
        int a=edMessageStaffService.addMessageStaff(edMessageStaff, request);
        if(a>0){
            return "/engineering/personnel/personnelList";
        }else {
            return "/engineering/personnel/personnelAdd";
        }
    }
    //删除工程人员基础
    @RequestMapping("/EdMassageStaff/deleteMassageStaff")
    public String deleteMassageStaff(@Param("id")int id,Model model) {

        int a=edMessageStaffService.deleteMessageStaff(id);
        if(a>0){
            model.addAttribute("error", "修改成功！");
            return "/engineering/personnel/personnelList";
        }else {
            model.addAttribute("error", "修改失败！");
            return "/engineering/personnel/personnelList";
        }
    }
    //修改工程人员基础

    @RequestMapping("/EdMassageStaff/toupdateMassageStaffPage")
    public String toupdateMassageStaffPage() {
        return "/engineering/personnel/personnelPadute";
    }

    @RequestMapping("/EdMassageStaff/updateMassageStaff")
    public String updateEdMassageStaff(EdMessageStaff messageStaff, HttpServletRequest request, Model model) {

        int a=edMessageStaffService.updateMessageStaff(messageStaff, request);
        if(a>0){
            model.addAttribute("error", "修改成功！");
            return "/engineering/personnel/personnelList";
        }else {
            model.addAttribute("error", "修改失败！");
            return "/engineering/personnel/personnelPadute";
        }
    }

    //单挑详情工程人员基础
    @RequestMapping("/EdMassageStaff/toQueryOneMassageStaffPage")
    public String toQueryOneMassageStaffPage() {
        return "/engineering/personnel/personnelParticular";
    }

    @RequestMapping("/EdMassageStaff/QueryOneMassageStaff")
    @ResponseBody
    public String QueryOneMassageStaff(@Param("id")int id) {
        return JSONObject.toJSONString(edMessageStaffService.queryOneById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //单挑详情工程人员基础
    @RequestMapping("/message_staff/query")
    public String QuerySomeMassageStaffPage() {
        return "/engineering/personnel/personnelList";
    }

    @RequestMapping("/EdMassageStaff/QuerySomeMassageStaff")
    @ResponseBody
    public String QuerySomeMassageStaff(@RequestParam(required = false, defaultValue = "0") int projectid,
                                   @RequestParam(required = false) String  name,
                                   @RequestParam(required = false) String  identityCard ,
                                   @RequestParam(required = false) String staffRole,
                                   @RequestParam(required = false, defaultValue = "0")int pageIndex,
                                   HttpServletRequest request) {

//        SysUser user = (SysUser) request.getSession().getAttribute("user");
//        int userid=user.getId();
//        if (user.getRoleid()==8){
//            userid=0;
//        }
        int userid=0;
        if(name==null||name==""){
            name=null;
        }
        if(identityCard==null||identityCard==""){
            identityCard=null;
        }
        if(staffRole==null||staffRole==""){
            staffRole=null;
        }
        return JSONObject.toJSONString(edMessageStaffService.queryBySome(projectid,name, userid, identityCard, staffRole, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }




    //endregion ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~工程人员信息~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~增补清单~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //获取该工程所有清单的
    @RequestMapping(value = "/Quantity/getbyprojectidandInt", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getbyprojectidandInt(@RequestParam("id")int id) {
        return JSONObject.toJSONString(sdSalesContractInventoryService.getbyprojectidandInt(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }


    @RequestMapping("/Quantity/toaddPage")
    public String toaddPage() {
        return "/engineering/supplement/supplementAdd";
    }
    @RequestMapping("/Quantity/toupdatePage")
    public String todetailPage() {
        return "/engineering/supplement/supplementPadute";
    }
    @RequestMapping("/Quantity/todetailPage")
    public String toupdatePage() {
        return "/engineering/supplement/supplementParticular";
    }

    //根据项目ID查询是这个项目的合同
    @RequestMapping(value = "/Quantity/getContractByPid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getContractByPid(@RequestParam("id")int id) {
        return JSONObject.toJSONString(sdSalesContractservice.querybyProjectId(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/quantity_manage/query")
    public String toaddmanagePage() {
        return "/engineering/supplement/supplementList";
    }


    //第一次添加提交的！！返回数据的
    @RequestMapping(value = "/Quantity/addContractInventory", produces = "application/json; charset=utf-8")
    public void addContractInventory(@RequestParam("projectId")int projectId,
                                     @RequestParam("system")int system,
                                     @RequestParam("system")String type,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {

        sdSalesContractInventoryService.addContractInventory(projectId,  system, type, request, response);

    }
    //模糊查询的清单列表
    @RequestMapping(value = "/Inventory/queryContractInventory", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  queryContractInventory(     @RequestParam(required = false, defaultValue = "0") int projectId,
                                               @RequestParam(required = false, defaultValue = "0") int system,
                                               @RequestParam(required = false, defaultValue = "0")  int pageIndex) {

        return JSONObject.toJSONString(sdSalesContractInventoryService.queryContractInventory(projectId, system,  pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
 //增补清单存库看sdAction ;
    //增补清单查询在SDAction



    //endregion ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~增补清单结束~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




}
