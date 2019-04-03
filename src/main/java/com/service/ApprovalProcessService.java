package com.service;

import com.beans.SysApprovalProcess;

import java.util.List;

/**
 * @author 李鹏熠
 * @create 2019/3/4 10:02
 */
public interface ApprovalProcessService {
    List<SysApprovalProcess> getProcessList();
    int updateProcessById(String usersid, int id);
}
