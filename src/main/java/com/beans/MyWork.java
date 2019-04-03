package com.beans;

import lombok.Data;


import java.util.Date;

/**
 * @author 李鹏熠
 * @create 2019/3/18 14:26
 */

@Data
public class MyWork {
    private int id;
    private SysApprovalProcess process;
    private SysUser user;
    private Date createtime;
    private SysUser processUser;


}