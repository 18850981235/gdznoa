package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class McPersonnelDispatched {
  private int id;

  private int projectid;

  private int deptid;

  private int userid;
  @JsonFormat(pattern = "yyyy-MM-dd  ")
  @JSONField(format = "yyyy-MM-dd  ")
  @DateTimeFormat(pattern = "yyyy-MM-dd  ")
  private Date createtime;

  private String demand;
  @JsonFormat(pattern = "yyyy-MM-dd  ")
  @JSONField(format = "yyyy-MM-dd  ")
  @DateTimeFormat(pattern = "yyyy-MM-dd  ")
  private Date evectionTime;

  private String personnelCondition;

  private BigDecimal costStandard;

  private BigDecimal evectionBudget;
  @JsonFormat(pattern = "yyyy-MM-dd  ")
  @JSONField(format = "yyyy-MM-dd  ")
  @DateTimeFormat(pattern = "yyyy-MM-dd  ")
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
