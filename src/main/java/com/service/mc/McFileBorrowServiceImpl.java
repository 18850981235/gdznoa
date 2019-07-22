package com.service.mc;

import com.beans.*;
import com.dao.mc.McFileBorrowMapper;
import com.dao.mc.McPerformanceDateMapper;
import com.dao.mc.McQualificationMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.dao.sys.UserMapper;
import com.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李鹏熠
 * @create 2019/3/22 9:30
 */
@Transactional
@Service("mcFileBorrowService")
public class McFileBorrowServiceImpl implements McFileBorrowService{

    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;
    @Resource
    private McFileBorrowMapper mcFileBorrowMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private McQualificationMapper mcQualificationMapper;
    @Resource
    private McPerformanceDateMapper mcPerformanceDateMapper;

    /**
     * 添加原文件借用审批详情 修改人员派遣下一个审批人审批状态
     * @param detailed  审批详情实体类
     * @return 是否添加成功
     */
    @Override
    public int addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("商务原文件借用");
        try {
            approvalDetailedMapper.add(detailed);
            McFileBorrow update = new McFileBorrow();
            int processUserid = 0;
            McFileBorrow fb = mcFileBorrowMapper.getListById(detailed.getApprovalId());
            String state = "审批中";
            String users = fb.getProcess().getUsersid();
            String[] userArr = users.split(",");
            if (detailed.getState().equals("同意")) {
                fb.setProcessNode(fb.getProcessNode()+1);
            } else {
                fb.setProcessNode(fb.getProcessNode()-1);
            }

            if(fb.getProcessNode()==1){
                processUserid =Integer.parseInt(userArr[0]);
            }
            if(fb.getProcessNode()==2){
                processUserid =Integer.parseInt(userArr[1]);
            }
            if(fb.getProcessNode()==3){
                processUserid = userMapper.DeptroleUser(fb.getDeptid()).get(0).getId();
            }
            if(fb.getProcessNode()==4){
                processUserid=fb.getUserid();
            }
            if(fb.getProcessNode()==5){
                processUserid =Integer.parseInt(userArr[4]);
                state="审批结束";
            }
            update.setProcessNode(fb.getProcessNode());
            update.setProcessState(state);
            update.setProcessUserid(processUserid);
            update.setId(detailed.getApprovalId());
            return mcFileBorrowMapper.updateById(update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }


    /**
     * 添加文件借用申请
     * @param  fileBorrow  文件借用实体类
     * @return 是否添加成功
     */
    @Override
    public int add(McFileBorrow fileBorrow, HttpServletRequest request) {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(7);
            String[] arr = process.getUsersid().split(",");
            fileBorrow.setProcessid(7);
            fileBorrow.setProcessUserid(Integer.parseInt(arr[0]));
            fileBorrow.setProcessState("未审批");
            num = mcFileBorrowMapper.add(fileBorrow);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }

    @Override
    public int update(McFileBorrow fileBorrow) {
        return mcFileBorrowMapper.updateById(fileBorrow);
    }

    @Override
    public int delete(int id) {
        return mcFileBorrowMapper.delete(id);
    }

    @Override
    public Map<String, Object> getList(String projectName,String name, int deptid, Date start,
                                      Date end, int usreid, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        List<McFileBorrow> list=null;
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            if(projectName==null){
                page.setTotalCount(mcFileBorrowMapper.getCount(name, deptid, start, end, usreid));
                page.setCurrentPageNo(pageIndex);
                list=mcFileBorrowMapper.getList(name, deptid, start, end, usreid,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            }else{
                page.setTotalCount(mcFileBorrowMapper.getCountProject(projectName,name, deptid, start, end, usreid));
                page.setCurrentPageNo(pageIndex);
                list=mcFileBorrowMapper.getListProject(projectName,name, deptid, start, end, usreid,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
            }
            map.put("page",page);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }

    @Override
    public McFileBorrow getListById(int id) {
        return mcFileBorrowMapper.getListById(id);
    }

    @Override
    public Map<String, Object> getParticular1ById(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            McFileBorrow borrow = mcFileBorrowMapper.getListById(id);
            List<SysApprovalDetailed> list = approvalDetailedMapper.getListByapprovalId(id, "商务原文件借用");
            map.put("borrow",borrow);
            map.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }
    @Override
    public Map<String, Object> queryMailFile( @Param("projectName")String projectName) {
        Map<String, Object> map = new HashMap<>();
        try {
           List<McQualificationCertificate>   ListQ = mcQualificationMapper.queryall(projectName);
            List<McPerformanceDate> listP = mcPerformanceDateMapper.queryall(projectName);
            System.err.print(listP);
            map.put("McQualificationCertificate",ListQ);
            map.put("McPerformanceDate",listP);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return map;
    }



}