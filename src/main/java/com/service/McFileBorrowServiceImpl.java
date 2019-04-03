package com.service;

import com.beans.McFileBorrow;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.ApprovalDetailedMapper;
import com.dao.ApprovalProcessMapper;
import com.dao.McFileBorrowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;

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

    @Override
    public int addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("商务原文件借用");
        try {
            approvalDetailedMapper.add(detailed);
            McFileBorrow fb_update = new McFileBorrow();
            if (detailed.getState() == "通过") {
                String state = "进行中";
                int processUserid = 0;
                //McStamp stamp = mcStampMapper.getListById(detailed.getApprovalId());
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

    @Override
    public int add(McFileBorrow fileBorrow) {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(7);
            String[] arr = process.getUsersid().split(",");
            fileBorrow.setProcessid(7);
            fileBorrow.setProcessUserid(Integer.parseInt(arr[0]));
            num = mcFileBorrowMapper.add(fileBorrow);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }
}