package com.dao.mc;

import com.beans.McPerformanceDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;
@Mapper
public interface McPerformanceDateMapper {
    int addPerformanceDate(McPerformanceDate mcPerformanceDate);

    McPerformanceDate queryMcPerformanceDatebyid(@Param("id")int id);


    int updateMcPerformanceDate(McPerformanceDate mcPerformanceDate);

    int deleteMcPerformanceDate(@Param("id")int id);

    int querycont(@Param("peojectname") String projectName, @Param("bidtimestart") Data bidtimeStart, @Param("bidtimeend") Data bidtimeEnd,
                  @Param("accetimestart") Data accetimeStart, @Param("acctimeend") Data acctimeEnd, @Param("borrow") String borrow);

    List<McPerformanceDate> queryMcPerformanceDatebysome(@Param("peojectname") String projectName, @Param("bidtimestart") Data bidtimeStart, @Param("bidtimeend") Data bidtimeEnd,
                                  @Param("accetimestart") Data accetimeStart, @Param("acctimeend") Data acctimeEnd, @Param("borrow") String borrow, int pageIndex, int pageSize);
   List<McPerformanceDate> queryall();
}
