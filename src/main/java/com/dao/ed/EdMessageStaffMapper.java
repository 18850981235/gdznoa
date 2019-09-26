package com.dao.ed;

import com.beans.EdMessage;
import com.beans.EdMessageStaff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EdMessageStaffMapper {
    int addMessagestaffMapper(EdMessageStaff messageStaff);

    int updateMessagestaffMapper(EdMessageStaff messageStaff);

    int  deleteMassageStaff(@Param("id")int id);

    EdMessageStaff  queryAllById(@Param("id")int id);

    int querycountBySome(@Param("projectid")int projectid,@Param("name")String  name,@Param("userid") int userid,
                         @Param("identityCard")String identityCard,@Param("staffRole")String staffRole);
    List<EdMessageStaff>  queryAllBySome(@Param("projectid")int projectid,@Param("name")String  name,@Param("userid") int userid,
                                         @Param("identityCard")String identityCard,@Param("staffRole")String staffRole,
                                         @Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);


}
