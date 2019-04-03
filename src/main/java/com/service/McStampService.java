package com.service;

import com.beans.McStamp;
import com.beans.SysApprovalDetailed;

/**
 * @author 李鹏熠
 * @create 2019/3/18 11:23
 */
public interface McStampService {
    int addProjectApproval(SysApprovalDetailed detailed);
    int add(McStamp stamp);
}
