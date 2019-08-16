package com.service.sup;

import com.beans.SupplierStaff;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @author 许思明
 * @create 2019/4/16
 */
public interface SupplierStaffService {
    //增加联系人
    int addstaff(List<SupplierStaff> supplierStaff,int supplierid);
    //删除联系人
    int deleteStaff(@Param("id") int id);
    //更改联系人
    int updateStaff(SupplierStaff supplierStaff);
    // 根据ID查询联系人
    List<SupplierStaff> querybyid(@Param("id") int id);
    //根据条件查询
   Map<String,Object> querybysome(@Param("name") String name, @Param("supname") String supname, @Param("pageIndex") int pageIndex);
}
