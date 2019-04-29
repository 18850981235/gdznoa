package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class McFileBorrow {

  private int id;

  private int deptid;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;

  private int userid;

  private String phone;

  private int projectid;

  private String name;

  private String purpose;

  private String consignee;

  private String consigneePhone;

  private int processid;

  private int processUserid;

  private int  processNode;

  private String processState;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updatetime;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date sendtime;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date returntime;

  private String sendExpressageName;

  private String sendExpressageWaybill;

  private String sendAddress;

  private String returnExpressageName;

  private String returnExpressageWaybill;

  private String returnAddress;


  private SysDept dept;
  private SysUser user;
  private BdProject project;
  private SysApprovalProcess process;
  private SysUser processUser;


}
