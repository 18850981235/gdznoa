package com.action;

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
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    //region
    //增加品牌
    @RequestMapping(value="/trademark/addtrademarkpage" , produces = "text/html;charset=UTF-8")
    public String  addtrademarkpage(){
        return "添加界面";
    }
    @RequestMapping(value="/trademark/add" , produces = "text/html;charset=UTF-8")
    public int addTrademark(SupplierTrademark supplierTrademark){
        return supplierTrademarkService.addSupplierTrademark(supplierTrademark);
    }
    //删除品牌


    @RequestMapping(value="/trademark/delete",produces ="text/html;charset=UTF-8" )
    public int deleteTrademark(@RequestParam int id){
      return supplierTrademarkService.deleteTrademark(id);
    };
    //更改信息

    @RequestMapping(value="/trademark/updateTrademarkpage" , produces = "text/html;charset=UTF-8")
    public String  updateTrademarkpage(){
        return "添加界面";
    }
    @RequestMapping(value="/trademark/updateTrademark",produces ="text/html;charset=UTF-8" )
    public int  updateTrademark(SupplierTrademark supplierTrademark){
      return supplierTrademarkService.updateTrademark(supplierTrademark);
    };
    //根据ID查询

    @RequestMapping(value="/trademark/queryTrademarkpage" , produces = "text/html;charset=UTF-8")
    public String  queryTrademarkpage(){
        return "添加界面";
    }
    @RequestMapping(value = "/trademark/QueryTrademarkByid",produces = "application/json; charset=utf-8")
    public String QueryTrademarkByid(@RequestParam int id)
    {
        return JSONObject.toJSONString(supplierTrademarkService.querybyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    //模糊搜索

    @RequestMapping(value="/trademark/QueryTrademarkpage" , produces = "text/html;charset=UTF-8")
    public String  QueryTrademarkpage(){
        return "添加界面";
    }
    @RequestMapping(value = "/trademark/QueryTrademark",produces = "application/json; charset=utf-8")
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
        return "添加界面";
    }

    @RequestMapping(value="/staff/addstaff" , produces = "text/html;charset=UTF-8")
    public int addStaff(SupplierStaff SupplierStaff){
        return supplierStaffService.addstaff(SupplierStaff);
    }
    //删除联系人
    @RequestMapping(value="/staff/deletestaff",produces ="text/html;charset=UTF-8" )
    public int deleteStaff(@RequestParam int id){
        return supplierStaffService.deleteStaff(id);
    };
    //更改信息
    @RequestMapping(value="/staff/updaStaffpage" , produces = "text/html;charset=UTF-8")
    public String  updaStaffpage(){
        return "添加界面";
    }

    @RequestMapping(value="/staff/updatestaff",produces ="text/html;charset=UTF-8" )
    public int  updateStaff(SupplierStaff supplierStaff){
        return supplierStaffService.updateStaff(supplierStaff)  ;
    };
    //根据ID查询
    @RequestMapping(value="/staff/QueryStaffbyidPage" , produces = "text/html;charset=UTF-8")
    public String  QueryStaffbyidPage(){
        return "添加界面";
    }
    @RequestMapping(value = "/staff/querystaffbyid",produces = "application/json; charset=utf-8")
    public String QueryStaffbyid(@RequestParam int id)
    {
        return JSONObject.toJSONString(supplierStaffService.querybyid(id),SerializerFeature.DisableCircularReferenceDetect);
    };
    //模糊搜索
    @RequestMapping(value="/staff/queryStaffpage" , produces = "text/html;charset=UTF-8")
    public String  queryStaffpage(){
        return "添加界面";
    }
    @RequestMapping(value = "/staff/querystaff",produces = "application/json; charset=utf-8")
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
    //添加供应商信息
    @RequestMapping(value="/supplier2/addSupplierPage" , produces = "text/html;charset=UTF-8")
    public String  addSupplierPage(){
        return "添加界面";
    }
    @RequestMapping(value="/supplier2/addSupplier" , produces = "text/html;charset=UTF-8")
    public int addSupplier(Supplier Supplier, HttpServletRequest request){
        return supplierService.addSupplier(Supplier,request);
    }
    //删除供应商
    @RequestMapping(value="/supplier2/delete",produces ="text/html;charset=UTF-8" )
    public int deleteSupplier(@RequestParam int id){
        return supplierService.deleteSupplier(id);
    };
    //更改供应商信息
    @RequestMapping(value="/supplier2/updateSupplierPage" , produces = "text/html;charset=UTF-8")
    public String  updateSupplierPage(){
        return "添加界面";
    }
    @RequestMapping(value="/supplier2/updateSupplier",produces ="text/html;charset=UTF-8" )
    public int  updateSupplier(Supplier supplier){
        return supplierService.updateSupplier(supplier)  ;
    };
    //根据ID查询供应商
    @RequestMapping(value="/supplier2/QuerySupplierByIdPage" , produces = "text/html;charset=UTF-8")
    public String  QuerySupplierByIdPage(){
        return "添加界面";
    }
    @RequestMapping(value = "/supplier2/QuerySupplierById",produces = "application/json; charset=utf-8")
    public String QuerySupplierById(@RequestParam int id)
    {
        return JSONObject.toJSONString(supplierService.querybyid(id),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullStringAsEmpty);
    };
    //模糊搜索供应商
    @RequestMapping(value="/supplier2/querySupplierPage" , produces = "text/html;charset=UTF-8")
    public String  querySupplierPage(){
        return "添加界面";
    }
    @RequestMapping(value = "/supplier2/querySupplier",produces = "application/json; charset=utf-8")
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

