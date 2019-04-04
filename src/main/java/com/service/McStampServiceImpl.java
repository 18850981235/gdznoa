package com.service;

import com.beans.McStamp;
import com.beans.SysApprovalDetailed;
import com.beans.SysApprovalProcess;
import com.dao.ApprovalDetailedMapper;
import com.dao.ApprovalProcessMapper;
import com.dao.McStampMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 李鹏熠
 * @create 2019/3/18 11:23
 */
@Transactional
@Service("mcStampService")
public class McStampServiceImpl implements McStampService {
    @Resource
    private McStampMapper mcStampMapper;
    @Resource
    private ApprovalProcessMapper approvalProcessMapper;
    @Resource
    private ApprovalDetailedMapper approvalDetailedMapper;


    /**
     * 添加盖章审批详情
     * @param detailed  审批详情实体类
     * @return 是否添加成功
     */
    @Override
    public int addProjectApproval(SysApprovalDetailed detailed) {
        detailed.setApprovalName("商务盖章");
        try {
            approvalDetailedMapper.add(detailed);
            McStamp stamp_update = new McStamp();
            if (detailed.getState() == "通过") {
                String state = "进行中";
                int processUserid = 0;
                McStamp stamp = mcStampMapper.getListById(detailed.getApprovalId());
                String users = stamp.getProcess().getUsersid();
                String[] userArr = users.split(",");
                for (int i = 0; i < userArr.length; i++) {
                    if (userArr[i].equals(String.valueOf(stamp.getProcessUserid()))) {
                        if (i != userArr.length - 1) {
                            processUserid = Integer.parseInt(userArr[i + 1]);
                        } else {
                            state = "已结束";
                        }
                    }
                }
                stamp_update.setProcessUserid(processUserid);
                stamp_update.setUpdatetime(new Date());
                stamp_update.setProcessState(state);
                stamp_update.setId(detailed.getApprovalId());
            } else {
                stamp_update.setUpdatetime(new Date());
                stamp_update.setProcessState(detailed.getState());
                stamp_update.setId(detailed.getApprovalId());
            }
            return mcStampMapper.updateById(stamp_update);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    /**
     * 添加盖章申请
     * @param  stamp 盖章实体类
     * @return 是否添加成功
     */
    @Override
    public int add(McStamp stamp) {
        int num = 0;
        try {
            SysApprovalProcess process = approvalProcessMapper.getProcessById(12);
            String[] arr = process.getUsersid().split(",");
            stamp.setProcessid(12);
            stamp.setProcessUserid(Integer.parseInt(arr[0]));
            num = mcStampMapper.add(stamp);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return num;
    }

}