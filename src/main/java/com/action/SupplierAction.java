package com.action;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beans.Supplier;
import com.beans.SupplierStaff;
import com.beans.SupplierTrademark;
import com.service.sup.SupplierService;
import com.service.sup.SupplierStaffService;
import com.service.sup.SupplierTrademarkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/*
许思明
2019.04.15
 */
@Controller
@RequestMapping("/supplier")
public class SupplierAction {
    //1231231
    @Resource(name="supplierTrademarkService")
   private SupplierTrademarkService supplierTrademarkService;
    @Resource(name="SupplierStaffService")
    private SupplierStaffService supplierStaffService;
    @Resource(name="SupplierService")
    private SupplierService supplierService;
    //增加品牌
    @RequestMapping(value="/trademark/add" , produces = "text/html;charset=UTF-8")
    public int addTrademark(SupplierTrademark supplierTrademark){
        return supplierTrademarkService.addSupplierTrademark(supplierTrademark);
    }
    //删除品牌
    @RequestMapping(value="/trademark/delete",produces ="text/html;charset=UTF-8" )
    public int delete(@RequestParam int id){
      return supplierTrademarkService.deleteTrademark(id);
    };
    //更改信息
    @RequestMapping(value="/trademark/update",produces ="text/html;charset=UTF-8" )
    public int  update(SupplierTrademark supplierTrademark){
      return supplierTrademarkService.updateTrademark(supplierTrademark)  ;
    };
    //根据ID查询
    @RequestMapping(value = "/trademark/querybyid",produces = "application/json; charset=utf-8")
    public String Query(@RequestParam int id)
    {
        return JSONObject.toJSONString(supplierTrademarkService.querybyid(id));
    };
    //模糊搜索
    @RequestMapping(value = "/trademark/querybynametype",produces = "application/json; charset=utf-8")
    public String querybynametype(@RequestParam(required = false) String Name, @RequestParam(required = false) String product,@RequestParam(required = false) String enterpriseName,@RequestParam(required = false, defaultValue = "0") int pageIndex) {

        if (Name == null || Name == "") {
            Name = null;
        }
        if (product == null || product == "") {
            product = null;
        }
        if (enterpriseName == null || enterpriseName == "") {
            enterpriseName = null;
        }
        return JSONObject.toJSONString(supplierTrademarkService.querybysom(Name, product, enterpriseName,
                pageIndex),
                SerializerFeature.DisableCircularReferenceDetect);

    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~联系人管理~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @RequestMapping(value="/supplier_staff/add" , produces = "text/html;charset=UTF-8")
    public int addStaff(SupplierStaff SupplierStaff){
        return supplierStaffService.addstaff(SupplierStaff);
    }
    //删除品牌
    @RequestMapping(value="/supplier_staff/delete",produces ="text/html;charset=UTF-8" )
    public int deleteStaff(@RequestParam int id){
        return supplierStaffService.deleteStaff(id);
    };
    //更改信息
    @RequestMapping(value="/supplier_staff/update",produces ="text/html;charset=UTF-8" )
    public int  updateStaff(SupplierStaff supplierStaff){
        return supplierStaffService.updateStaff(supplierStaff)  ;
    };
    //根据ID查询
    @RequestMapping(value = "/supplier_staff/querybyid",produces = "application/json; charset=utf-8")
    public String QueryStaffbyid(@RequestParam int id)
    {
        return JSONObject.toJSONString(supplierStaffService.querybyid(id));
    };
    //模糊搜索
    @RequestMapping(value = "/supplier_staff/querye",produces = "application/json; charset=utf-8")
    public String queryStaffbysome(@RequestParam(required = false) String Name, @RequestParam(required = false) String supname,@RequestParam(required = false, defaultValue = "0") int pageIndex) {

        if (Name == null || Name == "") {
            Name = null;
        }
        if (supname == null || supname == "") {
            supname = null;
        }

        return JSONObject.toJSONString(supplierStaffService.querybysome(Name, supname, pageIndex),
                SerializerFeature.DisableCircularReferenceDetect);

    }
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~供应商~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    //添加供应商信息
    @RequestMapping(value="/supplier2/add" , produces = "text/html;charset=UTF-8")
    public int addSupplier(Supplier Supplier){
        return supplierService.addSupplier(Supplier);
    }
    //删除供应商
    @RequestMapping(value="/supplier2/delete",produces ="text/html;charset=UTF-8" )
    public int deleteSupplier(@RequestParam int id){
        return supplierService.deleteSupplier(id);
    };
    //更改供应商信息
    @RequestMapping(value="/supplier2/update",produces ="text/html;charset=UTF-8" )
    public int  updateSupplier(Supplier supplier){
        return supplierService.updateSupplier(supplier)  ;
    };
    //根据ID查询供应商
    @RequestMapping(value = "/supplier2/querybyid",produces = "application/json; charset=utf-8")
    public String QuerySupplier(@RequestParam int id)
    {
        return JSONObject.toJSONString(supplierService.querybyid(id));
    };
    //模糊搜索供应商
    @RequestMapping(value = "/supplier2/querye",produces = "application/json; charset=utf-8")
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
                SerializerFeature.DisableCircularReferenceDetect);

    }
    //添加评价
    @RequestMapping(value="/evaluate/add" , produces = "text/html;charset=UTF-8")
    public int addSupplierevaluate(SupplierStaff SupplierStaff){
        return supplierStaffService.addstaff(SupplierStaff);
    }

}
