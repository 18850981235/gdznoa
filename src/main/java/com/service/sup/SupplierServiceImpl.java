package com.service.sup;

import com.beans.Supplier;
import com.beans.SupplierTrademark;
import com.dao.sup.MiddleMapper;
import com.dao.sup.SupplierMapper;
import com.dao.sup.SupplierTrademarkMapper;
import com.util.FileUtils;
import com.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*许思明
* 2019.04.17*/
@Transactional
@Service("SupplierService")
public class SupplierServiceImpl implements SupplierService {

    @Resource
    SupplierMapper supplierMapper;
    @Resource
    SupplierTrademarkMapper trademarkMapper;
    @Resource
    MiddleMapper middleMapper;
    //增加供应商信息

    @Override
    public int addSupplier(Supplier supplier,String trademark, HttpServletRequest request) {
        try {

        String accessory= FileUtils.uploadFile(request,"file");
        if (accessory!=null&&!accessory.equals("")){
            supplier.setCredentialAccessory(accessory);
        }
            String template= FileUtils.uploadFile(request,"template");
            if (template!=null&&!template.equals("")){
                supplier.setTemplate(template);
            }
            int userId = (int) request.getSession().getAttribute("userId");
        supplier.setRecorder(userId);
         int a=supplierMapper.addSupplier(supplier);
          String[] temp = trademark.split(",");
        for (int i = 0; i < temp.length; i++) {
            if (!"".equals(temp[i]) && temp[i] != null){
                int supplierId=supplier.getId();
                int staffid=Integer.valueOf(temp[i]);
                middleMapper.addMeddle(supplierId,staffid);
            }
        }
        return 1;
    }catch (Exception e) {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        e.printStackTrace();
        return 0;
    }

    };
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

    @Override
    public List<Supplier> queryAll() {
        return supplierMapper.queryAll();
    }
}
