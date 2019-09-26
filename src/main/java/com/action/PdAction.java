package com.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.*;
import com.service.bd.BdProjectService;
import com.service.pd.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pd")
public class PdAction {

    @Resource(name = "bdProjectService")
    private BdProjectService bdProjectService;
    @Resource(name = "PdProcurementService")
    private PdProcurementContractService PdProcurementService;
    @Resource(name = "pdInventoryService")
    private pdInventoryService pdInventoryService;
    @Resource(name = "PdserviceContractService")
    private PdserviceContractService servicecontractService;
    @Resource(name = "pdServiceInventoryService")
    private pdServiceInventoryService pdServiceInventory;


    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~采购合同~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //查询所有的采购合同
    @RequestMapping(value = "/Procurement/getProcurementAll", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getProcurementAll() {
        return JSONObject.toJSONString(PdProcurementService.queryAll(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //查询项目ID相关的采购合同
    @RequestMapping(value = "/Procurement/getProcurementByProject", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getProcurementByProject(@Param("id") int id) {
        return JSONObject.toJSONString(PdProcurementService.queryByProject(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }


    //添加合同(新增）
    @RequestMapping("/Procurement/toaddProcurementPage")
    public String toaddProcurementPage() {
        return "/purchase/contract/contractAdd";
    }

    @RequestMapping(value = "/Procurement/addProcurement", produces = "application/json; charset=utf-8")
    @ResponseBody
    public int    addProcurement(PdProcurementContract procurementContract, HttpServletRequest reques) {
        System.err.println("进来新增了！");
       int a= PdProcurementService.addPdProcurement(procurementContract,reques);
    return a;
    };


    //添加清单（新增，修改）
    @RequestMapping(value = "/Inventory/addInvenbywight", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  addInven(@RequestBody String  list) {
        System.err.println("list===>"+list);
        Map<String,Object> aa= JSON.parseObject(list);
        //JSONArray arrays= JSONArray.parseArray(list);
        //List<SdSalesInventory> List= JSONObject.parseArray(arrays.toJSONString(),SdSalesInventory.class);
        //System.err.println("List===>"+List);
        List<pdProcurementInventory> list1=JSON.parseArray(aa.get("list").toString(), pdProcurementInventory.class);
//        List<SdSalesInventory> listsd=new ArrayList<>();
//        for(int s=0;s<lists.size();s++){
//            listsd.add((SdSalesInventory)lists.get(s));
//        }
        int contractid=(int) aa.get("contractid");
        double total=(double) aa.get("total");
        System.err.println("listnnnn===>"+list1);
        System.err.println("contractid===>"+contractid);
        int a=pdInventoryService.AddpdInventory(list1, contractid,total);
        if(a>0){
            return "yes";
        }else{
            return "no";
        }
    };

    //获取合同单条数据(含清单）
    @RequestMapping("/Procurement/togetProcurementPage")
    public String togetProcurementPage() {
        return "/purchase/contract/contractParticular";
    }
    //清单详情
    @RequestMapping(value = "/SdSalesContract/querydetailsbyid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String Querydetailsbyid(@RequestParam int id) {
        return JSONObject.toJSONString(PdProcurementService.querydetailbyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }



    //修改合同单条数据(含清单）
    @RequestMapping("/Procurement/toupdateProcurementPage")
    public String toupdateProcurementPage() {
        return "/purchase/contract/contractPadute";
    }

    @RequestMapping(value = "/Procurement/getProcurement", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getProcurement(@Param("id") int id) {
        return JSONObject.toJSONString(PdProcurementService.querybyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/Procurement/updateProcurement", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateProcurement(PdProcurementContract procurementContract,HttpServletRequest request) {
       int a=PdProcurementService.updatePdProcurement(procurementContract,request);
       if(a>0){
           return "/purchase/contract/contractList";
       }else {
           return "/purchase/contract/contractList";
       }

    }
    //删除合同和清单（逻辑删除）
    @RequestMapping(value = "/Procurement/deleteProcurement", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteProcurement(@Param("id")int id) {
        int a=PdProcurementService.deletePdProcurement(id);
        if(a>0){
            return "/purchase/contract/contractList";
        }else {
            return "/purchase/contract/contractList";
        }
    }

    //模糊查询列表
    @RequestMapping("/procuremen/query")
    public String toqueryProcurementPage() {
        return "/purchase/contract/contractList";
    }



    @RequestMapping(value = "/Procurement/queryProcurement", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryProcurement(@RequestParam(required = false, defaultValue = "0") int projectid,
                                   @RequestParam(required = false) String  serialnumber,
                                   @RequestParam(required = false) String  code,
                                   @RequestParam(required = false, defaultValue = "0") int supplierid,
                                   @RequestParam(required = false, defaultValue = "0")int pageIndex,
                                   HttpServletRequest request ){

        if(serialnumber==null||serialnumber==""){
            serialnumber=null;
        }
        if (code==null||code==""){
            code=null;
        }

        SysUser user = (SysUser) request.getSession().getAttribute("user");
        int userid=user.getId();
        if (user.getRoleid()==8){
            userid=0;
        }

        return JSONObject.toJSONString( PdProcurementService.queryBySome(projectid, serialnumber, code, supplierid, userid ,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //我的工作：添加审批流程
    @RequestMapping("/PdContract/PdContractParticular")
    public String PdContractParticular(SysApprovalDetailed approvalDetailed, HttpServletRequest request) {
        int userid = (int)request.getSession().getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        PdProcurementService.addContractApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }




    //endregion ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~采购合同~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~服务合同~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //查询所有的劳务合同
    @RequestMapping(value = "/Service/getserviceAll", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getserviceAll() {
        return JSONObject.toJSONString(servicecontractService.queryAll (),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    //查询项目ID相关的采购合同
    @RequestMapping(value = "/Service/getServiceByProject", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getServiceByProject(@Param("id") int id) {
        return JSONObject.toJSONString(servicecontractService.queryByProject(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }



    //添加服务合同(新增）
    @RequestMapping("/Service/toaddserviceProcurementtPage")
    public String toaddserviceProcurementtPage() {
        return "/purchase/affair/affairAdd";
    }

    @RequestMapping(value = "/Service/addserviceProcurement", produces = "application/json; charset=utf-8")
    @ResponseBody
    public int    addserviceProcurement(PdServiceContract serviceContract, HttpServletRequest reques) {
        System.err.println("进来新增了！");
        int a= servicecontractService.addPdProcurement(serviceContract,reques);
        return a;
    };
    //添加服务的清单（新增，修改）

    @RequestMapping(value = "/service/addserviceInven", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  addserviceInven(@RequestBody String  list) {
        System.err.println("list===>"+list);
        Map<String,Object> aa= JSON.parseObject(list);
        //JSONArray arrays= JSONArray.parseArray(list);
        //List<SdSalesInventory> List= JSONObject.parseArray(arrays.toJSONString(),SdSalesInventory.class);
        //System.err.println("List===>"+List);
        List<PdServiceInventory> list1=JSON.parseArray(aa.get("list").toString(), PdServiceInventory.class);
//        List<SdSalesInventory> listsd=new ArrayList<>();
//        for(int s=0;s<lists.size();s++){
//            listsd.add((SdSalesInventory)lists.get(s));
//        }
        int contractid=(int) aa.get("contractid");
        System.err.println("listnnnn===>"+list1);
        System.err.println("contractid===>"+contractid);
        int a=pdServiceInventory.AddpdInventory(list1, contractid);
        if(a>0){
            return "yes";
        }else{
            return "no";
        }
    };
    //获取服务的合同单条数据(含清单）
    @RequestMapping("/Service/togetServiceProcurementPage")
    public String togetServiceProcurementPage() {
        return "/purchase/affair/affairParticular";
    }

    //清单详情
    @RequestMapping(value = "/SdSalesContract/Queryservicedetailsbyid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String Queryservicedetailsbyid(@RequestParam int id) {
        return JSONObject.toJSONString(servicecontractService.querydetailbyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }


    //修改合同单条数据
    @RequestMapping("/Service/toupdateserviceProcurementPage")
    public String toupdateserviceProcurementPage() {
        return "/purchase/affair/affairPadute";
    }

    @RequestMapping(value = "/service/getServiceProcurement", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getServiceProcurement(@Param("id") int id) {
        return JSONObject.toJSONString(servicecontractService.queryById(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    @RequestMapping(value = "/service/updateserviceProcurement", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateserviceProcurement(PdServiceContract pdServiceContract,HttpServletRequest request) {
        int a=servicecontractService.updateProcurement(pdServiceContract,request);
        if(a>0){
            return "/purchase/affair/affairList";
        }else {
            return "/purchase/affair/affairList";
        }

    }

    //删除合同和清单（逻辑删除）
    @RequestMapping(value = "/Service/deleteServiceProcurement", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String deleteServiceProcurement(@Param("id")int id) {
        int a=servicecontractService.deletePdProcurement(id);
        if(a>0){
            return "/purchase/affair/affairList";
        }else {
            return "/purchase/affair/affairList";
        }
    }

    //模糊查询列表
    @RequestMapping("/service/query")
    public String toqueryPage() {
        return "/purchase/affair/affairList";
    }


    @RequestMapping(value = "/Service/queryServiceProcurement", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryServiceProcurement(@RequestParam(required = false, defaultValue = "0") int projectid,
                                   @RequestParam(required = false) String  serialnumber,
                                   @RequestParam(required = false) String  code,
                                   @RequestParam(required = false) String secondName,
                                   @RequestParam(required = false, defaultValue = "0")int pageIndex,
                                   HttpServletRequest request){

        if(serialnumber==null||serialnumber==""){
            serialnumber=null;
        }
        if (code==null||code==""){
            code=null;
        }

        if (secondName==null||secondName==""){
            secondName=null;
        }
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        int userid=user.getId();
        if (user.getRoleid()==8){
            userid=0;
        }

        return JSONObject.toJSONString( servicecontractService.queryBySome(projectid, serialnumber, code, secondName, userid, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //我的工作：添加审批流程
    @RequestMapping("/Service/PdServiceParticular")
    public String PdServiceParticular(SysApprovalDetailed approvalDetailed, HttpServletRequest request) {
        int userid = (int)request.getSession().getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        servicecontractService.addPdServiceApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }



    //endregion ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~服务合同~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


}
