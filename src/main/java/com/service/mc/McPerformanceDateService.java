package com.service.mc;

import com.beans.McPerformanceDate;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Map;

/*
20190508
 */
public interface McPerformanceDateService {
    int  addPerformanceDate(McPerformanceDate mcPerformanceDate, HttpServletRequest request);
    McPerformanceDate queryMcPerformanceDatebyid(int id);
    int updateMcPerformanceDate(McPerformanceDate mcPerformanceDate);
    int deleteMcPerformanceDate(int id);
    Map<String, Object> queryMcPerformanceDatebysome(String projectname, Data bidtimestart,Data bidtimeend,
                                                    Data accetimestart,Data acctimeend,String borrow,int pageIndex);


}
