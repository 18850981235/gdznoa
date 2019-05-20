package com.service.sup;

import com.beans.SupplierEvaluate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Map;

/*许思明
* 2019.04.17*/
public interface SupplierEvaluateService {
    int addSupplierEvaluate(SupplierEvaluate supplierEvaluate);

    int  deleteSupplierEvaluate(int id);

    int updatesupplierEvaluate(SupplierEvaluate supplierEvaluate);

    SupplierEvaluate queryEvaluateByid(int id);

    Map<String,Object> queryEvaluate(@Param("userId") int userId,@Param("supplierId") int supplierId,int pageIndex);
}
