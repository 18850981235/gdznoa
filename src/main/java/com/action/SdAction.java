package com.action;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.JSONObject;
import com.beans.*;
import com.service.bd.BdProjectService;
import com.service.sd.SdSalesContractInventoryService;
import com.service.sd.SdSalesContractservice;
import com.service.sd.SdSalesInventoryService;
import com.service.sup.SupplierTrademarkService;
import com.service.system.systemService;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/sd")
public class SdAction {

    @Resource(name = "SdSalesContractService")
    private SdSalesContractservice sdSalesContractservice;
    @Resource(name = "bdProjectService")
    private BdProjectService bdProjectService;
    @Resource(name = "systemService")
    private systemService systemService;
    @Resource(name="supplierTrademarkService")
    private SupplierTrademarkService supplierTrademarkService;
    @Resource(name="SdSalesContractInventoryService")
    private SdSalesContractInventoryService sdSalesContractInventoryService;
    @Resource(name="SdSalesInventoryService")
    private SdSalesInventoryService sdSalesInventoryService;
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }




    //region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~销售合同~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



    //获取所有项目
    @RequestMapping(value = "/SdSalesContract/getProject", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getProject() {
        return JSONObject.toJSONString(bdProjectService.getallPeoject(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);


    }

    @RequestMapping("/SdSalesContract/AddProjectPage")
    public String AddProjectPage() {
        return "/sale/contract/contractAdd";
    }

    //添加合同
    @RequestMapping(value = "/SdSalesContract/addContract", produces = "application/json; charset=utf-8")
    public String addContract(SdSalesContract sdSalesContract, HttpServletRequest reques, Model model) {
        int i = sdSalesContractservice.addSdSalesContract(sdSalesContract,reques);
        if (i ==3) {
//            model.addAttribute("success", "该项目的合同已存在！在列表查看！");
            return "/sale/contract/contractList";
        } else if (i>0){
//            model.addAttribute("success", "新增成功！");
            return "/sale/contract/contractList";
        }else {
//            model.addAttribute("error", "新增失败！");
            return"/sale/contract/contractAdd";
        }
    };
    @RequestMapping("/SdSalesContract/UpdateProjectPage")
    public String UpdateProjectPage() {
        return "/sale/contract/contractPadute";
    }

    //修改合同信息
    @RequestMapping(value = "/SdSalesContract/updateContract", produces = "application/json; charset=utf-8")
    public String updateContract(SdSalesContract sdSalesContract) {
        int i = sdSalesContractservice.updateSdSalesContract(sdSalesContract);
        if (i > 0) {
            return "/sale/contract/contractList";
        } else {
            return "/sale/contract/contractList";
        }
    } ;


//获取合同单挑数据
    @RequestMapping(value = "/SdSalesContract/getContractbyid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getContractbyid(@Param("id") int id) {
        return JSONObject.toJSONString(sdSalesContractservice.querybyId(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    //根据ID查询审批详情
    @RequestMapping("/SdSalesContract/detailProjectPage")
    public String detailProjectPage() {
        return "/sale/contract/contractParticular";
    }


    @RequestMapping(value = "/SdSalesContract/querydetailsbyid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String Querydetailsbyid(@RequestParam int id) {
        return JSONObject.toJSONString(sdSalesContractservice.querydetailbyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    @RequestMapping("/sales/query")
    public String toProjectPage() {
        return "/sale/contract/contractList";
    }
    //模糊查询合同数据
    @RequestMapping(value = "/SdSalesContract/queryContract", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryContract(@RequestParam(required = false, defaultValue = "0") int projectId,
                                @RequestParam(required = false, defaultValue = "0") int clientId,
                                @RequestParam(required = false, defaultValue = "0") int deptId,
                                @RequestParam(required = false) Date didtimestart,
                                @RequestParam(required = false) Date didtimeend,
                                @RequestParam(required = false, defaultValue = "0") int areauser,
                                @RequestParam(required = false, defaultValue = "0") int vocational,
                                @RequestParam(required = false, defaultValue = "0")int pageIndex) {

        return JSONObject.toJSONString(sdSalesContractservice.query(projectId, clientId, deptId, didtimestart,
                 areauser, vocational, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);

    }
    @RequestMapping("/sales/todetailPage")
    public String todetailPage() {
        return "/sale/contract/detailedParticular";
    }

    // 根据项目查询所有的中间表
    @RequestMapping(value = "/SdSalesContract/detailsbyprojectid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String detailsbyprojectid(@RequestParam int id) {
        return JSONObject.toJSONString(sdSalesContractInventoryService.getbyprojecti (id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    //根据中间表查询下面的清单
    @RequestMapping(value = "/SdSalesContract/QuerydetailsbyInt", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String QuerydetailsbyInt(@RequestParam(required = false, defaultValue = "0")int id ) {
        return JSONObject.toJSONString(sdSalesContractInventoryService.QuerydetailsbyInt(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }



    //我的工作：添加审批流程
    @RequestMapping("/SdSalesContract/approvalDetailed")
    public String datumParticular(SysApprovalDetailed approvalDetailed, HttpServletRequest request) {
        int userid = (int)request.getSession().getAttribute("userId");
        approvalDetailed.setApprovalUser(userid);
        approvalDetailed.setApprovalDate(new Date());
        sdSalesContractservice.addContractApproval(approvalDetailed);
        return "redirect:/showMyWork";
    }

    //endregion ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~销售合同结束~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  //region~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~合同清单~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


//获取该工程所有清单的
    @RequestMapping(value = "/Inventory/getbyprojectidandInt", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getbyprojectidandInt(@RequestParam("id")int id) {
        return JSONObject.toJSONString(sdSalesContractInventoryService.getbyprojectidandInt(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    @RequestMapping("/salesinventory/toaddPage")
    public String toaddPage() {
        return "/sale/detailed/detailedAdd";
    }

    @RequestMapping("/salesinventory/query")
    public String query() {
        return "/sale/detailed/detailedList";
    }
    @RequestMapping("/salesinventory/toDetailPage")
    public String toDetailPage() {
        return "/sale/detailed/detailedParticular";
    }
    //查詢所有的项目系统的名称
    @RequestMapping(value = "/Inventory/getallsystem", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getallsystem() {
        return JSONObject.toJSONString(systemService.allsystem(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    //根据项目ID查询是这个项目的合同
    @RequestMapping(value = "/Inventory/getContractByPid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getContractByPid(@RequestParam("id")int id) {
        return JSONObject.toJSONString(sdSalesContractservice.querybyProjectId(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //第一次添加提交的！！返回数据的
    @RequestMapping(value = "/Inventory/addContractInventory", produces = "application/json; charset=utf-8")
    public void addContractInventory(@RequestParam("projectId")int projectId,
                                       @RequestParam("system")int system,
                                       @RequestParam("type")String type,
                                       HttpServletRequest request,
                                       HttpServletResponse response) {
      sdSalesContractInventoryService.addContractInventory(projectId,  system, type, request, response);

    }

    //添加清单
    @RequestMapping(value = "/Inventory/addInvenbywight", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  addInven(@RequestBody String  list) {
        Map<String,Object> aa=JSON.parseObject(list);
        //JSONArray arrays= JSONArray.parseArray(list);
       //List<SdSalesInventory> List= JSONObject.parseArray(arrays.toJSONString(),SdSalesInventory.class);
        //System.err.println("List===>"+List);
        List<SdSalesInventory> list1=JSON.parseArray(aa.get("list").toString(),SdSalesInventory.class);
//        List<SdSalesInventory> listsd=new ArrayList<>();
//        for(int s=0;s<lists.size();s++){
//            listsd.add((SdSalesInventory)lists.get(s));
//        }
       int contractid=(int ) aa.get("contractid");
        double total=(double ) aa.get("total");
        System.err.println("listnnnn===>"+list1);
        System.err.println("contractid===>"+contractid);
        int a=sdSalesContractInventoryService.addInventory(list1,contractid,total);

      if(a>0){
          return "yes";
      }else{
          return "no";
      }
    };


    //添加Excel上传的；

    @RequestMapping(value = "/Inventory/Excelto", produces = "application/json; charset=utf-8")

    public void  Excelto(HttpServletRequest request, HttpServletResponse response ) {
        String s;
        try {
            s = sdSalesInventoryService.ExceltoSdSalesContractInventory(request, response);

        }catch (Exception e) {
            e.printStackTrace();
        }
    };
    //模糊查询的清单列表
    @RequestMapping(value = "/Inventory/queryContractInventory", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  queryContractInventory(     @RequestParam(required = false, defaultValue = "0") int projectId,
                                               @RequestParam(required = false, defaultValue = "0") int system,
                                               @RequestParam(required = false) String type,
                                               @RequestParam(required = false, defaultValue = "0")  int pageIndex) {
      if(type==null||type==""){
          type=null;
      }
        return JSONObject.toJSONString(sdSalesContractInventoryService.queryContractInventory(projectId, system,type,  pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };



    //查询一条中间表的清单
    @RequestMapping(value = "/Inventory/Inventorydetail", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  Inventorydetail(@RequestParam("id")int id) {
        return JSONObject.toJSONString(sdSalesContractInventoryService.Inventorydetail(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };


    @RequestMapping(value = "/Inventory/outExcel", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  queryDaily(HttpServletRequest request, HttpServletResponse response,
                           HttpSession session,SdSalesContractInventory sdSalesContractInventory) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssms");
        String dateStr = sdf.format(new Date());
        Map<String, Object> map = new HashMap<String, Object>();
        // 指定下载的文件名
        response.setHeader("Content-Disposition", "attachment;filename=" + dateStr + ".xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        XSSFWorkbook workbook = null;

        // 导出Excel对象
        workbook = sdSalesContractInventoryService.queryDaily(sdSalesContractInventory);

        OutputStream output;
        try {
            output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            bufferedOutPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
         return  "  s" ;
        }

    }
//endregion~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}