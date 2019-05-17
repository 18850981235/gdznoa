package com.service.mc;


import com.beans.McFileBorrow;
import com.beans.McPerformanceDate;
import com.dao.mc.McPerformanceDateMapper;
import com.util.FileUtils;
import com.util.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("mcPerformanceDateservice")
public class McPerformanceDateServiceImp implements McPerformanceDateService{
    @Resource
    private McPerformanceDateMapper mcPerformanceDateMapper;

    @Override
    public int addPerformanceDate(McPerformanceDate mcPerformanceDate, HttpServletRequest request) {
        try {
        String bidFile= FileUtils.uploadFile(request,"bidFile");
        if (bidFile!=null&&!bidFile.equals("")){
            mcPerformanceDate.setBiddingNotice(bidFile);
        }
        String performanceFile= FileUtils.uploadFile(request,"performanceFile");
        if (performanceFile!=null&&!performanceFile.equals("")){
            mcPerformanceDate.setPerformanceContract(performanceFile);
        }
        String acceptance= FileUtils.uploadFile(request,"acceptanceFile");
        if (acceptance!=null&&!acceptance.equals("")){
            mcPerformanceDate.setAcceptanceReport(acceptance);
        }
        String maintenanceFile= FileUtils.uploadFile(request,"maintenanceFile");
        if (maintenanceFile!=null&&!maintenanceFile.equals("")){
            mcPerformanceDate.setMaintenanceProof(maintenanceFile);
        }
            String ImpFile= FileUtils.uploadFile(request,"ImpFile");
            if (ImpFile!=null&&!maintenanceFile.equals("")){
                mcPerformanceDate.setPublicPicture(ImpFile);
            }
    } catch (Exception e) {
        e.printStackTrace();
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

        return mcPerformanceDateMapper.addPerformanceDate(mcPerformanceDate);
    }

    @Override
    public McPerformanceDate queryMcPerformanceDatebyid(int id) {
        return mcPerformanceDateMapper.queryMcPerformanceDatebyid(id);
    }

    @Override
    public int updateMcPerformanceDate(McPerformanceDate mcPerformanceDate,HttpServletRequest request) {
        try {
            String bidFile= FileUtils.uploadFile(request,"bidFile");
            if (bidFile!=null&&!bidFile.equals("")){
                mcPerformanceDate.setBiddingNotice(bidFile);
            }
            String performanceFile= FileUtils.uploadFile(request,"performanceFile");
            if (performanceFile!=null&&!performanceFile.equals("")){
                mcPerformanceDate.setPerformanceContract(performanceFile);
            }
            String acceptance= FileUtils.uploadFile(request,"acceptanceFile");
            if (acceptance!=null&&!acceptance.equals("")){
                mcPerformanceDate.setAcceptanceReport(acceptance);
            }
            String maintenanceFile= FileUtils.uploadFile(request,"maintenanceFile");
            if (maintenanceFile!=null&&!maintenanceFile.equals("")){
                mcPerformanceDate.setMaintenanceProof(maintenanceFile);
            }
            String ImpFile= FileUtils.uploadFile(request,"ImpFile");
            if (ImpFile!=null&&!maintenanceFile.equals("")){
                mcPerformanceDate.setPublicPicture(ImpFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return mcPerformanceDateMapper.updateMcPerformanceDate(mcPerformanceDate);
    }

    @Override
    public int deleteMcPerformanceDate(int id) {
        return mcPerformanceDateMapper.deleteMcPerformanceDate(id);
    }

    @Override
    public Map<String, Object> queryMcPerformanceDatebysome(String projectName, Data bidtimeStart, Data bidtimeEnd, Data accetimeStart, Data acctimeEnd, String borrow,int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        List<McPerformanceDate> list=null;
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);

                page.setTotalCount(mcPerformanceDateMapper.querycont(projectName ,bidtimeStart, bidtimeEnd, accetimeStart, acctimeEnd, borrow));
                page.setCurrentPageNo(pageIndex);
                list=mcPerformanceDateMapper.queryMcPerformanceDatebysome(projectName ,bidtimeStart, bidtimeEnd, accetimeStart, acctimeEnd, borrow,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());

            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map; }

}
