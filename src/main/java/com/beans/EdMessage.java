package com.beans;

import lombok.Data;




@Data
public class EdMessage {

  private int id;
  private int projectid;
  private String constructionUnit;
  private String agentConstructUnit;
  private String supervisingUnit;
  private int deptid;
  private String fristDeputy;
  private String fristPhone;
  private String agentDeputy;
  private String agentPhone;
  private String supervisor;
  private String supervisorPhone;


  private String accessory;
  private int processid;
  private int processUserid;
  private int processNode;
  private String processState;
  private  int isdelete;


  private SysUser processUser;
  private SysDept dept;
  private BdProject project;
  private  BdClient client;

  private SysApprovalProcess process;


}
