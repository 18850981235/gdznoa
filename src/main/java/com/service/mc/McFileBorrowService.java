package com.service.mc;

import com.beans.McFileBorrow;
import com.beans.SysApprovalDetailed;

/**
 * @author 李鹏熠
 * @create 2019/3/22 9:30
 */
public interface McFileBorrowService {
    int addProjectApproval(SysApprovalDetailed detailed);
    int add(McFileBorrow fileBorrow);
}
