package com.dao.sys;


import com.beans.RequestspErmissions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface requestspErmissionsMapper {
        List<RequestspErmissions> queryErmissions(@Param("reqid") int  reqid, @Param("userid")int userid);

        int   querycount(@Param("reqid")int  reqid,@Param("userid")int userid);

        int  addErmissions(RequestspErmissions requestspErmissions);
}
