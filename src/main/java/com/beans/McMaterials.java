package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Data
public class McMaterials {

  private int id;
  private int deptid;
  private int userid;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;
  private int projectid;
  private String content;
  private String purpose;
  private String accessory;
  private String phone;

  private int processid;
  private int processUserid;
  private String processState;
  private String projectName;

  private SysDept dept;
  private SysUser user;
  private BdProject project;
  private SysApprovalProcess process;
  private SysUser processUser;


}
