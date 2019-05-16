package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class McStamp {

  private int id;

  private int deptid;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;

  private int userid;

  private String phone;

  private String content;

  private int fileNum;

  private String stampType;

  private String consignee;

  private String consigneeAddress;

  private String consigneePhone;

  private String accessory;

  private int processid;

  private int processUserid;

  private String processState;

  private int projectid;

  private String purpose;

  private String expressageName;

  private String expressageWaybill;

  private BdProject project;
  private SysDept dept;
  private SysUser user;
  private SysApprovalProcess process;
  private SysUser processUser;

}
