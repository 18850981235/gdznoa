package com.service.ed;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface edQuantityManageService {
    //查询单挑数据和清单
    Map<String,Object> querybyid(@Param("id") int id);


}
