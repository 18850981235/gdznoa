package com.beans;


import lombok.Data;

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

  private Date biddate;

  private int clientid;

  private String capitalSource;

  private int deptid;
//业务负责人
  private int principal;
//区域负责人
  private int areaManager;

  private String content;

  private Date createtime;

  private String accessory;
//申请人
  private int userid;



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
  private SysApprovalProcess process;

}