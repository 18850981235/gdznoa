package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


@Data
public class McQualificationCertificate {
  private int id;
  private int deptid;
  private int userid;
  private String type;
  private String name;
  private String content;
  private String state;
  private String borrow;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date annualTime;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endTime;
  private int security;
  private int annualPrincipal;
  private int applicant;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date applicantTime;
  private String filename;
  private String watermark;
  private String accessory;
  private int processid;
  private int processUserid;
  private int processNode;
  private String processState;
  private String deptName;
  private int  pdf_outtime;

  private SysUser user;
  private SysUser annualUser;
  private SysApprovalProcess process;
  private SysDept dept;


}
