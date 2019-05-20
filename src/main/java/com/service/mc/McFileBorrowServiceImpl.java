package com.service.mc;

import com.beans.McFileBorrow;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.mc.McFileBorrowMapper;
import com.dao.sys.ApprovalDetailedMapper;
import com.dao.sys.ApprovalProcessMapper;
import com.util.FileUtils;
import com.util.Page;
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
            McFileBorrow fb_update = new McFileBorrow();
            if (detailed.getState() .equals("通过")) {
                String state = "进行中";
                int processUserid = 0;
                McFileBorrow fb=  mcFileBorrowMapper.getListById(detailed.getApprovalId());
                String users = fb.getProcess().getUsersid();
                String[] userArr = users.split(",");
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(fb.getProcessUserid()))) {
                        if (i != userArr.length - 1) {
                            processUserid = Integer.parseInt(userArr[i + 1]);
                        } else {
                            state = "已结束";
                        }
                    }
                }
                fb_update.setProcessUserid(processUserid);
                fb_update.setUpdatetime(new Date());
                fb_update.setProcessState(state);
                fb_update.setId(detailed.getApprovalId());
            } else {
                fb_update.setUpdatetime(new Date());
                fb_update.setProcessState(detailed.getState());
                fb_update.setId(detailed.getApprovalId());
            }
            return mcFileBorrowMapper.updateById(fb_update);
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
            String accessory= FileUtils.uploadFile(request,"file");
            if (accessory!=null&&!accessory.equals("")){
                fileBorrow.setAccessory(accessory);
            }
            String[] arr = process.getUsersid().split(",");
            fileBorrow.setProcessid(7);
            fileBorrow.setProcessUserid(Integer.parseInt(arr[0]));
            fileBorrow.setProcessState("进行中");
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
    public Map<String, Object> getList(String name, int deptid, Date start,
                                      Date end, int usreid, int pageIndex) {
        Map<String, Object> map=new HashMap<>();
        Page page=new Page();
        try {
            if (pageIndex == 0) {
                pageIndex = 1;
            }
            page.setPageSize(10);
            page.setTotalCount(mcFileBorrowMapper.getCount(name, deptid, start, end, usreid));
            page.setCurrentPageNo(pageIndex);
            List<McFileBorrow> list=mcFileBorrowMapper.getList(name, deptid, start, end, usreid,(page.getCurrentPageNo()-1)*page.getPageSize(),page.getPageSize());
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


}