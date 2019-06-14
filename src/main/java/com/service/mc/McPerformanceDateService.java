package com.service.mc;

import com.beans.McPerformanceDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Map;

/*
20190508
 */

public interface McPerformanceDateService {
    int  addPerformanceDate(McPerformanceDate mcPerformanceDate, HttpServletRequest request);
    McPerformanceDate queryMcPerformanceDatebyid(int id);
    int updateMcPerformanceDate(McPerformanceDate mcPerformanceDate,HttpServletRequest request);
    int deleteMcPerformanceDate(int id);
    Map<String, Object> queryMcPerformanceDatebysome(String projectname, Date bidtimestart, Date bidtimeend,
                                                     Date accetimestart, Date acctimeend, String borrow, int pageIndex);

}
