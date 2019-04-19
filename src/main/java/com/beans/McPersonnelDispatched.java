package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class McPersonnelDispatched {

  private int id;
  private int deptid;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;
  private int projectid;
  private String demand;
  private int userid;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date evectionTime;
  private double evectionCost;
  private String accessory;
  private int processid;
  private int processUserid;
  private String processState;
  private SysDept dept;
  private SysUser user;
  private String projectName;
  private SysApprovalProcess process;
  private SysUser processUser;

}
