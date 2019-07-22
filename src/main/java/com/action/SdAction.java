package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String addContract(SdSalesContract sdSalesContract,HttpServletRequest reques) {
        int i = sdSalesContractservice.addSdSalesContract(sdSalesContract,reques);
        if (i > 0) {
            return " ";
        } else {
            return " ";
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
            return "";
        } else {
            return "";
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
                didtimeend, areauser, vocational, pageIndex),
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


    @RequestMapping("/Inventory/getContractbyprojectPage")
    public String getContractbyprojectPage() {
        return "/sale/detailed/detailedParticular";
    }
    //根据工程ID查询中间表
  @RequestMapping(value = "/Inventory/getContractbyproject", produces = "application/json; charset=utf-8")
  @ResponseBody
   public String getContractbyproject(@RequestParam(required = false,defaultValue = "0") int projectId, @RequestParam(required = false, defaultValue = "0")int pageIndex) {
      return JSONObject.toJSONString(sdSalesContractInventoryService.querybyProjectid(projectId,pageIndex),
              SerializerFeature.DisableCircularReferenceDetect,
              SerializerFeature.WriteNullStringAsEmpty);
   }
    @RequestMapping("/Inventory/getInventorybyprojectPage")
    public String getInventorybyprojectPage() {
        return "/sale/detailed/detailedParticular";
    }
//直接根据ID查询详情表和清单表
    @RequestMapping(value = "/Inventory/getInventorybyproject", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getInventorybyproject(@Param("id")int id) {
        return JSONObject.toJSONString(sdSalesContractInventoryService.queryContractInventorbyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping("/Inventory/getInventorybyidPage")
    public String getInventorybyidPage() {
        return "/sale/detailed/detailedParticular";
    }
   //直接根据ID查询详情表和清单表
    @RequestMapping(value = "/Inventory/getInventorybyid", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getInventorybyid(@Param("id")int id) {
        return JSONObject.toJSONString(sdSalesInventoryService.getInventorybyId(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    //删除详情表和清单表
    @RequestMapping(value = "/Inventory/deleteInventorybyproject", produces = "application/json; charset=utf-8")
    public String deleteInventorybyproject(@Param("id")int id) {
        int s=sdSalesContractInventoryService.deletecontractInven(id);
        if(s>0){
            return " ";
        }else{
        return " ";}
    }


    //查詢供应商系统的名称
    @RequestMapping(value = "/Inventory/getInventory", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getTrademarksystem() {
        return JSONObject.toJSONString(systemService.query(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    //查詢项目系统的名称
    @RequestMapping(value = "/Inventory/getallsystem", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getallsystem() {
        return JSONObject.toJSONString(systemService.allsystem(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value = "/Inventory/getSupplierTrademark", produces = "application/json; charset=utf-8")
    @ResponseBody
    //获取供应商品牌
    public String getSupplierTrademark() {
        List<SupplierTrademark> ListTrademark=supplierTrademarkService.allSupplierTrademark();
        return JSONObject.toJSONString(ListTrademark,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    @RequestMapping("/salesinventory/query")
    public String InventorybyidPage() {
        return "/sale/detailed/detailedList";
    }
//条件查询清单
    @RequestMapping(value = "/Inventory/quyry", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String quyry(  @RequestParam(required = false, defaultValue = "0") int projectId,
                            @RequestParam(required = false) String branchName,
                            @RequestParam(required = false,defaultValue = "0") int systemId,
                            @RequestParam(required = false,defaultValue = "0") int  subitemId,
                            @RequestParam(required = false, defaultValue = "0")int pageIndex) {
        if(branchName==null||branchName==""){
            branchName=null;
        }
        return JSONObject.toJSONString( sdSalesContractInventoryService.queryInventory(projectId,branchName, systemId, subitemId, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    }
    @RequestMapping("/Inventory/AddnventorybyidPage")
    public String AddnventorybyidPage() {
        return "/sale/detailed/detailedAdd";
    }
    //添加Excel上传的；
    //条件查询清单
    @RequestMapping(value = "/Inventory/addInven", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  addInven(HttpServletRequest request, HttpServletResponse response,
                        SdSalesContractInventory sdSalesContractInventory) throws Exception{
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }

        InputStream in = file.getInputStream();
//        addInventory.addInventory(in,file);
        sdSalesContractInventoryService.addInventory(sdSalesContractInventory,in,file);
        in.close();
        PrintWriter out = null;
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码
        out = response.getWriter();
        out.print("文件导入成功！");
        out.flush();
        out.close();
    return " ";
    };


    @RequestMapping(value = "/Inventory/addInvenbywight", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  addInven(SdSalesContractInventory salesContractInventory, List<SdSalesInventory> list) throws Exception{

        int i=sdSalesContractInventoryService.addInventory(salesContractInventory, list);
        if (i==0){
             return " ";}
        else{
             return "" ;
        }

    };
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