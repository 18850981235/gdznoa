package com.service.sup;

import com.beans.SupplierEvaluate;
import com.dao.sup.SupplierEvaluateMapper;
import com.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("SupplierEvaluateService")
public class SupplierEvaluateServiceImpl implements  SupplierEvaluateService {
    @Resource
   private SupplierEvaluateMapper supplierEvaluateMapper ;
    @Override
    public int addSupplierEvaluate(SupplierEvaluate supplierEvaluate) {
        return supplierEvaluateMapper.addSupplierevaluate(supplierEvaluate);
    }

    @Override
    public int deleteSupplierEvaluate(@Param("id") int id) {
        return supplierEvaluateMapper.deleteValuate(id);
    }

    @Override
    public int updatesupplierEvaluate(SupplierEvaluate supplierEvaluate) {
        return supplierEvaluateMapper.updateValuate(supplierEvaluate);
    }

    @Override
    public SupplierEvaluate queryEvaluateByid(@Param("id") int id) {
        return supplierEvaluateMapper.queryValuatebyid(id);
    }

    @Override
    public Map<String, Object> queryEvaluate(int userId, int supplierId,int pageIndex) {
        Map<String,Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if(pageIndex==0){
                pageIndex=1;
            }
            page.setPageSize(10);
            page.setTotalCount(supplierEvaluateMapper.querycount(userId, supplierId));
            page.setCurrentPageNo(pageIndex);
            List<SupplierEvaluate> list=supplierEvaluateMapper.queryValuate(userId, supplierId,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize()
            );
            map.put("page",page);
            map.put("Evaluate",list);

        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
}
