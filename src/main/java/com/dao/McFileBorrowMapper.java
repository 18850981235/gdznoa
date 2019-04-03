package com.dao;

import com.Generator.bean.McFileBorrowExample;
import com.beans.McFileBorrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface McFileBorrowMapper {
    int add(McFileBorrow fileBorrow);
    int updateById(McFileBorrow fileBorrow);
    McFileBorrow getListById(int id);
}