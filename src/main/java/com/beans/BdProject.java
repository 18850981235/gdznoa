package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class BdProject {

  private int id;

  private String code;

  private String abbreviation;

  private String name;

  private String site;

  private String type;

  private String stage;

  private BigDecimal budget;

  private String biddingType;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date biddate;

  private int clientid;

  private String capitalSource;

  private int deptid;
//业务负责人
  private int principal;
//区域负责人
  private int areaManager;

  private String projectManager;

  private String content;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;

  private String accessory;
//申请人
  private int userid;

  private int processNode;

  private int processid;

  private int processUserid;

  private String processState;




  private SysDept dept;
  private BdClient client;
  //业务负责人
  private SysUser principalUser;
  //申请人
  private SysUser user;
  //区域负责人
  private SysUser areaManagerUser;

  private SysUser processUser;

  private SysApprovalProcess process;

  private SysUser branchuser;

  private  Pdf pdf;
  private  int PDfconut;

}