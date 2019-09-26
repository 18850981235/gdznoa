package com.dao.sup;

import com.beans.SupplierStaffMiddle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MiddleMapper {
    List<SupplierStaffMiddle> querybysupplierId(int supplierid);

    int queryCountbyStaff(@Param("id") int id );

    int addMeddle(@Param("supplierId") int supplierId,@Param("staff") int staff);
}
