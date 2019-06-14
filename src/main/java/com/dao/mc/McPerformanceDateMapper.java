package com.dao.mc;

import com.beans.McPerformanceDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Mapper
public interface McPerformanceDateMapper {
    int addPerformanceDate(McPerformanceDate mcPerformanceDate);

    McPerformanceDate queryMcPerformanceDatebyid(@Param("id")int id);


    int updateMcPerformanceDate(McPerformanceDate mcPerformanceDate);

    int deleteMcPerformanceDate(@Param("id")int id);

    int querycont(@Param("projectName") String projectName, @Param("bidtimeStart") Date bidtimeStart, @Param("bidtimeEnd") Date bidtimeEnd,
                  @Param("accetimeStart") Date accetimeStart, @Param("accetimeEnd") Date acctimeEnd, @Param("borrow") String borrow);

    List<McPerformanceDate> queryMcPerformanceDatebysome(@Param("projectName") String projectName, @Param("bidtimeStart") Date bidtimeStart, @Param("bidtimeEnd") Date bidtimeEnd,
                                                         @Param("accetimeStart") Date accetimeStart, @Param("accetimeEnd") Date acctimeEnd, @Param("borrow") String borrow, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
   List<McPerformanceDate> queryall(@Param("projectName")String projectName);


}
