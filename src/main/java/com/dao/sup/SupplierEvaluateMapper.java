package com.dao.sup;

import com.beans.SupplierEvaluate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SupplierEvaluateMapper {
    int addSupplierevaluate(SupplierEvaluate supplierEvaluate);

    int deleteValuate(@Param("id") int id);

    int  updateValuate(SupplierEvaluate supplierEvaluate);

    SupplierEvaluate queryValuatebyid(@Param("id") int id);

    int querycount(@Param("userId") int userId,@Param("supplierId") int supplierId);

    List<SupplierEvaluate> queryValuate(@Param("userId") int userId,@Param("supplierId") int supplierId, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
}
