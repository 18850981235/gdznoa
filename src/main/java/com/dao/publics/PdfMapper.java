package com.dao.publics;

import com.beans.Pdf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PdfMapper {

    int add(Pdf pdf);
    List<Pdf> getlist(@Param("name") String  name,
                      @Param("pageIndex")int pageIndex,
                      @Param("pageSize")int pageSize);
    int getCount(@Param("name") String  name);
}