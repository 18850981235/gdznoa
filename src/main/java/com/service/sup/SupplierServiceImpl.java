package com.service.sup;

import com.beans.Supplier;
import com.dao.sup.SupplierMapper;
import com.util.FileUtils;
import com.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*许思明
* 2019.04.17*/
@Service("SupplierService")
public class SupplierServiceImpl implements SupplierService {

    @Resource
    SupplierMapper supplierMapper;
    //增加供应商信息

    @Override
    public int addSupplier(Supplier supplier, HttpServletRequest request) {
        String accessory= FileUtils.uploadFile(request,"file");
        if (accessory!=null&&!accessory.equals("")){
            supplier.setCredentialAccessory(accessory);
        }
        return supplierMapper.addSupplier(supplier);
    }
//删除供应商消息
    @Override
    public int deleteSupplier(@Param("id") int id) {
        return supplierMapper.deleteSupplier(id);
    }
//更改供应商信息
    @Override
    public int updateSupplier(Supplier supplier) {
        return supplierMapper.updateSupplier(supplier);
    }
//根据ID查询信息
    @Override
    public Supplier querybyid(@Param("id") int id) {
        return supplierMapper.querybyid(id);
    }
//根据条件模糊查询供应商信息
    @Override
    public Map<String, Object> querybysome(String code, String name, String traname, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(supplierMapper.querycount(code,name,traname));
            page.setCurrentPageNo(pageIndex);
            List<Supplier> list=supplierMapper.querybysome(code,name,traname,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
}
