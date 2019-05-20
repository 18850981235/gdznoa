package com.service.sup;

import com.beans.Supplier;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/*许思明
* 2019.04.17*/
public interface SupplierService {
    //增加供应商信息
    int addSupplier(Supplier supplier, HttpServletRequest request);

    //删除供应商信息
    int deleteSupplier(@Param("id") int id);

    //更改供应商信息
    int updateSupplier(Supplier supplier);

    //查询供应商信息
    Supplier querybyid(@Param("id") int id);

    //模糊查询供应商信息
    Map<String,Object> querybysome(@Param("code") String code, @Param("name") String name, @Param("traname") String traname, @Param("pageIndex") int pageIndex);
}