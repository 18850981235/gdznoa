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


    @Override
    public List<SysApprovalProcess> getProcessList() {
        return approvalProcessMapper.getProcessList();
    }

    @Override
    public int updateProcessById(String usersid, int id) {
        return approvalProcessMapper.updateProcessById(usersid,id);
    }
}