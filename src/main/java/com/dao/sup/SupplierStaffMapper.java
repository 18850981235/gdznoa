package com.dao.sup;

import com.beans.SupplierStaff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author 许思明
 * @create 2019/4/16
 */
import java.util.List;
    @Mapper
    public interface SupplierStaffMapper {
    //增加联系人
    int addstaff(SupplierStaff supplierStaff);
    //删除联系人
    int deleteStaff(@Param("id") int id);
    //更改联系人
    int updateStaff(SupplierStaff supplierStaff);
    // 根据ID查询联系人
    List<SupplierStaff>  querybyid(@Param("id") int id);
    //根据条件查询
    List<SupplierStaff>  querybysome(@Param("name") String name, @Param("supname") String supname, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
    int querycount(@Param("name") String name, @Param("supname") String supname);
}
