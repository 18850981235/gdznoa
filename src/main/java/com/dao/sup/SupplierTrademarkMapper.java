package com.dao.sup;

import com.beans.SupplierTrademark;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author 许思明
 * @create 2019/4/15
 */
@Mapper
public interface SupplierTrademarkMapper {
    //添加品牌信息
    int addSrademark(SupplierTrademark supplierTrademark);
    //删除品牌信息
    int deleteSrademark(@Param("id") int id);
    //修改品牌信息
    int updateSrademark(SupplierTrademark supplierTrademark);
    //根据ID查询
     SupplierTrademark querybyid(@Param("id") int id);
    //条件查询
    List< SupplierTrademark> querybysome(@Param("name") String name, @Param("product") String product, @Param("enterpriseName") String enterpriseName, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    int querycount(@Param("name") String name, @Param("product") String product, @Param("enterpriseName") String enterpriseName);

    List<SupplierTrademark> allSupplierTrademark();
}
