package com.service;

import com.beans.SysApprovalProcess;
import com.dao.ApprovalProcessMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/3/4 10:02
 */
@Transactional
@Service("approvalProcessService")
public class ApprovalProcessServiceImpl implements ApprovalProcessService {
    @Resource()
    private ApprovalProcessMapper approvalProcessMapper;


    /**
     * 查询所有审批流程
     * @return 权限集合
     */
    @Override
    public List<SysApprovalProcess> getProcessList() {
        return approvalProcessMapper.getProcessList();
    }

    /**
     * 修改审批流程
     * @param usersid 审批人员id(多个)
     * @param id 审批流程id
     * @return 是否修改成功
     */
    @Override
    public int updateProcessById(String usersid, int id) {
        return approvalProcessMapper.updateProcessById(usersid,id);
    }
}