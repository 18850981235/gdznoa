package com.dao.sup;

import com.beans.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 许思明
 * @create 2019/4/17
 */
@Mapper
public interface SupplierMapper {
    //增加供应商信息
    int addSupplier(Supplier supplier);
    //删除供应商信息
    int deleteSupplier(@Param("id") int id);
    //更改供应商信息
    int  updateSupplier(Supplier supplier);
    //查询供应商信息
    Supplier querybyid(@Param("id") int id);
    //模糊查询供应商信息
    List<Supplier> querybysome(@Param("code") String code, @Param("name") String name, @Param("traname") String traname, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
    int querycount(@Param("code") String code, @Param("name") String name, @Param("traname") String traname);

    List<Supplier> queryAll();
}
