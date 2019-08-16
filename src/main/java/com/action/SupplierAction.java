package com.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.Supplier;
import com.beans.SupplierEvaluate;
import com.beans.SupplierStaff;
import com.beans.SupplierTrademark;
import com.service.sup.SupplierEvaluateService;
import com.service.sup.SupplierService;
import com.service.sup.SupplierStaffService;
import com.service.sup.SupplierTrademarkService;
import com.service.system.systemService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
许思明
2019.04.15
 */
@Controller
@RequestMapping("/supplier")
public class SupplierAction {
    @Resource(name="supplierTrademarkService")
   private SupplierTrademarkService supplierTrademarkService;
    @Resource(name="SupplierStaffService")
    private SupplierStaffService supplierStaffService;
    @Resource(name="SupplierService")
    private SupplierService supplierService;
    @Resource(name="SupplierEvaluateService")
    private SupplierEvaluateService supplierEvaluateService;
    @Resource(name = "systemService")
    private systemService systemService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        //true:允许输入空值，false:不能为空值
    }


    //region``````````````````````````````````````````````````````品牌开始~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping(value="/trademark/getAllSysytem" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String  getAllSysytem(){
        return JSONObject.toJSONString( systemService.allsystem(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);

    }
    //增加品牌
    @RequestMapping(value="/trademark/addtrademarkpage" , produces = "text/html;charset=UTF-8")
    public String  addtrademarkpage(){
        return "/supplier/brand/brandAdd";
    }
    @RequestMapping(value="/trademark/add" , produces = "text/html;charset=UTF-8")
    public String addTrademark(SupplierTrademark supplierTrademark){

        int a= supplierTrademarkService.addSupplierTrademark(supplierTrademark);
        if(a>0){
            return "/supplier/brand/brandList";
        }else{
            return "/supplier/brand/brandAdd";
        }
    }
    //删除品牌

    @RequestMapping(value="/trademark/delete",produces ="text/html;charset=UTF-8" )
    public int deleteTrademark(@RequestParam int id){
      return supplierTrademarkService.deleteTrademark(id);
      //0为删除失败，要么就是有关联，要么就是没删除成功！非0即成功

    };
    //更改品牌信息

    @RequestMapping(value="/trademark/updateTrademarkpage" , produces = "text/html;charset=UTF-8")
    public String  updateTrademarkpage(){
        return "/supplier/brand/brandPadute";
    }

    @RequestMapping(value="/trademark/updateTrademark",produces ="text/html;charset=UTF-8" )
    public String  updateTrademark(SupplierTrademark supplierTrademark){
      int a= supplierTrademarkService.updateTrademark(supplierTrademark);
      if (a>0){
          return "/supplier/brand/brandList";
        }else{
          return "/supplier/brand/brandAdd";
      }

    };
    //根据ID查询

    @RequestMapping(value="/trademark/queryTrademarkpage" , produces = "text/html;charset=UTF-8")
    public String  queryTrademarkpage(){
        return "/supplier/brand/brandPaticular";
    }
    @RequestMapping(value = "/trademark/QueryTrademarkByid",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String QueryTrademarkByid(@RequestParam int id)
    {
        return JSONObject.toJSONString(supplierTrademarkService.querybyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    //模糊搜索

    @RequestMapping(value="/trademark/query" , produces = "text/html;charset=UTF-8")
    public String  QueryTrademarkpage(){
        return "/supplier/brand/brandList";
    }
    @RequestMapping(value = "/trademark/QueryTrademark",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String QueryTrademark(@RequestParam(required = false) String Name, @RequestParam(required = false) String product,@RequestParam(required = false) String enterpriseName,@RequestParam(required = false, defaultValue = "0") int pageIndex) {

        if (Name == null || Name == "") {
            Name = null;
        }
        if (product == null || product == "") {
            product = null;
        }
        if (enterpriseName == null || enterpriseName == "") {
            enterpriseName = null;
        }
        return JSONObject.toJSONString(supplierTrademarkService.querybysom(Name, product, enterpriseName,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);

    }
    //endregion

    //region~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~联系人管理~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping(value="/staff/addStaffpage" , produces = "text/html;charset=UTF-8")
    public String  addStaffpage(){
        return "/supplier/contacts/contactsAdd";
    }

    @RequestMapping(value="/staff/addstaff" , produces = "text/html;charset=UTF-8")
    public String addStaff(@RequestBody String  list){

        System.err.println("List===>"+list);
        Map<String,Object> aa= JSON.parseObject(list);
        //JSONArray arrays= JSONArray.parseArray(list);
        //List<SdSalesInventory> List= JSONObject.parseArray(arrays.toJSONString(),SdSalesInventory.class);
        //System.err.println("List===>"+List);
        List<SupplierStaff> list1=JSON.parseArray(aa.get("list").toString(),SupplierStaff.class);
//        List<SdSalesInventory> listsd=new ArrayList<>();
//        for(int s=0;s<lists.size();s++){
//            listsd.add((SdSalesInventory)lists.get(s));
//        }
        int supplierid=(int ) aa.get("supplierid");
        System.err.println("listnnnn===>"+list1);
        System.err.println("supplierid===>"+supplierid);
//        return supplierEvaluateService.addSupplierEvaluate(supplierEvaluate);
//        return 1;
        if( supplierStaffService.addstaff(list1,supplierid)>0){

            return "/supplier/contacts/contactsList";
        }else{
            return "/supplier/contacts/contactsAdd";
        }

    }
    //删除联系人
    @RequestMapping(value="/staff/deletestaff",produces ="text/html;charset=UTF-8" )
    public String deleteStaff(@RequestParam int id){
         supplierStaffService.deleteStaff(id);
         return "/supplier/contacts/contactsList";
    };
    //更改信息
    @RequestMapping(value="/staff/updaStaffpage" , produces = "text/html;charset=UTF-8")
    public String  updaStaffpage(){
        return "/supplier/contacts/contactsPadute";
    }

    @RequestMapping(value="/staff/updatestaff",produces ="text/html;charset=UTF-8" )
    public String  updateStaff(SupplierStaff supplierStaff){
        int a= supplierStaffService.updateStaff(supplierStaff) ;
                if(a>0){
                    return "/supplier/contacts/contactsList";
                }else {
                    return "/supplier/contacts/contactsPadute";
                }
    };
    //根据ID查询
    @RequestMapping(value="/staff/QueryStaffbyidPage" , produces = "text/html;charset=UTF-8")
    public String  QueryStaffbyidPage(){
        return "/supplier/contacts/contactsParticular";
    }
    @RequestMapping(value = "/staff/querystaffbyid",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String QueryStaffbyid(@RequestParam int id)
    {
        return JSONObject.toJSONString(supplierStaffService.querybyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    //模糊搜索
    @RequestMapping(value="/supplier_staff/query" , produces = "text/html;charset=UTF-8")
    public String  queryStaffpage(){
        return "/supplier/contacts/contactsList";
    }
    @RequestMapping(value = "/staff/querystaff",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String queryStaffbysome(@RequestParam(required = false) String Name, @RequestParam(required = false) String supname,@RequestParam(required = false, defaultValue = "0") int pageIndex) {

        if (Name == null || Name == "") {
            Name = null;
        }
        if (supname == null || supname == "") {
            supname = null;
        }

        return JSONObject.toJSONString(supplierStaffService.querybysome(Name, supname, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);

    }
    //endregion
    //region~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~供应商~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    //查询所有供应商信息
    @RequestMapping(value="/supplier/getAllSupplier" , produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String  getAllSupplier(){
        return JSONObject.toJSONString( supplierService.queryAll(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);

    }



   //查询所有品牌信息
   @RequestMapping(value="/trademark/getAllTrademark" , produces = "text/html;charset=UTF-8")
   @ResponseBody
   public String  getAllTrademark(){
       return JSONObject.toJSONString( supplierTrademarkService.allSupplierTrademark(),
               SerializerFeature.DisableCircularReferenceDetect,
               SerializerFeature.WriteNullStringAsEmpty);

   }

    //添加供应商信息
    @RequestMapping(value="/supplier2/addSupplierPage" , produces = "text/html;charset=UTF-8")
    public String  addSupplierPage(){
        return "/supplier/merchant/merchantAdd";
    }

    @RequestMapping(value="/supplier2/addSupplier" , produces = "text/html;charset=UTF-8")
    public String  addSupplier(Supplier Supplier,    @RequestParam(required = false) String trademark, HttpServletRequest request){
        int a= supplierService.addSupplier(Supplier,trademark,request);
        if(a>0){
            return "/supplier/merchant/merchantList";
        }else {
          return "/supplier/merchant/merchantAdd";
        }
    }
    //删除供应商
    @RequestMapping(value="/supplier2/delete",produces ="text/html;charset=UTF-8" )
    public String  deleteSupplier(@RequestParam int id){
        if( supplierService.deleteSupplier(id)>0){
            return "/supplier/merchant/merchantList";
        }else{
            return "/supplier/merchant/merchantList";
        }
    };
    //更改供应商信息
    @RequestMapping(value="/supplier2/updateSupplierPage" , produces = "text/html;charset=UTF-8")
    public String  updateSupplierPage(){
        return "/supplier/merchant/merchantPadute";
    }
    @RequestMapping(value="/supplier2/updateSupplier",produces ="text/html;charset=UTF-8" )
    public int  updateSupplier(Supplier supplier){
        return supplierService.updateSupplier(supplier)  ;
    };
    //根据ID查询供应商
    @RequestMapping(value="/supplier2/QuerySupplierByIdPage" , produces = "text/html;charset=UTF-8")
    public String  QuerySupplierByIdPage(){
        return "/supplier/merchant/merchantParticular";
    }
    @RequestMapping(value = "/supplier2/QuerySupplierById",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String QuerySupplierById(@RequestParam int id)
    {
        return JSONObject.toJSONString(supplierService.querybyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    //模糊搜索供应商
    @RequestMapping(value="/supplier2/query" , produces = "text/html;charset=UTF-8")
    public String  querySupplierPage(){
        return "/supplier/merchant/merchantList";
    }
    @RequestMapping(value = "/supplier2/querySupplier",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String querySupplier(@RequestParam(required = false) String code, @RequestParam(required = false) String traname,@RequestParam(required = false) String name,@RequestParam(required = false, defaultValue = "0") int pageIndex) {

        if (code == null || code == "") {
            code = null;
        }
        if (name == null || name == "") {
            name = null;
        }
        if (traname == null || traname == "") {
            traname = null;
        }
        return JSONObject.toJSONString(supplierService.querybysome(code, name,traname,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);

    }
    //endregion~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   //region~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~评价~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //添加评价
   @RequestMapping(value="/evaluate/addpage" , produces = "text/html;charset=UTF-8")
   public String  addSupplierevaluatepage(){
       return "添加界面";
   }

    @RequestMapping(value="/evaluate/add" , produces = "text/html;charset=UTF-8")
    public int addSupplierevaluate(SupplierEvaluate supplierEvaluate){
        return supplierEvaluateService.addSupplierEvaluate(supplierEvaluate);
    }
    @RequestMapping(value="/evaluate/delete" , produces = "text/html;charset=UTF-8")
    public int deleteSupplierevaluate(@Param("id") int id){
        return supplierEvaluateService.deleteSupplierEvaluate(id);
    }
    @RequestMapping(value="/evaluate/updatepage" , produces = "text/html;charset=UTF-8")
    public String  updateupplierevaluatepage(){
        return "修改界面";
    }


    @RequestMapping(value="/evaluate/update" , produces = "text/html;charset=UTF-8")
    public int updateSupplierevaluate(SupplierEvaluate supplierEvaluate){
        return supplierEvaluateService.updatesupplierEvaluate(supplierEvaluate);
    }
    @RequestMapping(value="/evaluate/Evaluatedetail" , produces = "text/html;charset=UTF-8")
    public String  querySupplierevaluatebyid(){
        return "详情界面";
    }

    @RequestMapping(value="/evaluate/EvaluateByid" , produces = "text/html;charset=UTF-8")
    public String querySupplierevaluatebyid(@Param("id")int id){
               return JSONObject.toJSONString(supplierEvaluateService.queryEvaluateByid(id),
                        SerializerFeature.DisableCircularReferenceDetect,
                        SerializerFeature.WriteNullStringAsEmpty);
    }

    @RequestMapping(value="/evaluate/querySupplierEvaluatepage" , produces = "text/html;charset=UTF-8")
    public String  querySupplierEvaluatepage(){
        return "详情界面";
    }
    //模糊搜索供应商
    @RequestMapping(value = "/evaluate/querySupplierEvaluate",produces = "application/json; charset=utf-8")
    public String querySupplierEvaluate(@RequestParam(required = false, defaultValue = "0") int userId,
                                        @RequestParam(required = false, defaultValue = "0") int supplierId,
                                        @RequestParam(required = false, defaultValue = "0") int pageIndex) {


        return JSONObject.toJSONString(supplierEvaluateService.queryEvaluate(userId, supplierId,pageIndex),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);

    }
    //endregion~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}

