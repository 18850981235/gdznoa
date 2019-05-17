package com.beans;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class McPersonnelDispatched {
  private int id;

  private int projectid;

  private int deptid;

  private int userid;

  private Date createtime;

  private String demand;

  private Date evectionTime;

  private String personnelCondition;

  private String costStandard;

  private BigDecimal evectionBudget;

  private Date practicalTime;

  private String evectionCondition;

  private BigDecimal travelCost;

  private BigDecimal evectionCost;

  private int processid;

  private int processUserid;

  private String processState;

  private int processNode;

  private SysDept dept;
  private SysUser user;
  private BdProject project;
  private SysApprovalProcess process;
  private SysUser processUser;

}
