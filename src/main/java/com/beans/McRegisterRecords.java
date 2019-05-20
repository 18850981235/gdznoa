package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Data
public class McRegisterRecords {

  private int id;
  private int deptid;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;
  private int principal;
  private String phone;
  private String recordsType;
  private String recordsName;
  private String recordsState;
  private String caBorrow;
  private int annualPrincipal;
  private int manager;
  private String accessory;
  private int processid;
  private int processUserid;
  private String processState;
  private String deptName;
  private SysUser user;
  private SysApprovalProcess process;



}
