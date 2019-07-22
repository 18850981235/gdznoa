package com.dao.mc;

import com.beans.McMaterials;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface McMaterialsMapper {
    //添加商务材料申请
    int add(McMaterials materials);

    //修改商务材料申请
    int updateById(McMaterials materials);

    //按id查询商务材料
    McMaterials getListById(int id);

    int delete(@Param("id")int id);

    int getCount(@Param("offerTpye") String offerTpye,
                 @Param("deptid") int deptid,
                 @Param("start") Date start,
                 @Param("end") Date end,
                 @Param("userid") int usreid);

    List<McMaterials> getList(@Param("projectName") String projectName,
                              @Param("deptid") int deptid,
                              @Param("start") Date start,
                              @Param("end") Date end,
                              @Param("userid") int usreid,
                              @Param("pageIndex") int pageIndex,
                              @Param("pageSize") int pageSize);
}