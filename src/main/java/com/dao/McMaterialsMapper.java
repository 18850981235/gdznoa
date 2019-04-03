package com.dao;

import com.Generator.bean.McMaterialsExample;
import com.beans.McMaterials;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface McMaterialsMapper {
    //添加商务材料申请
    int add(McMaterials materials);
    //修改商务材料申请
    int updateById(McMaterials materials);
}