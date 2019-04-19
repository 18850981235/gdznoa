package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


@Data
public class BdProject {

  private int id;
  private String code;
  private String name;
  private String abbreviation;
  private int principal;
  private String site;
  private String type;
  private String stage;
  private double budget;
  private String biddingType;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date biddate;
  private int clientid;
  private String cooperationType;
  private String cooperationUnit;
  private String cooperationName;
  private String cooperationRole;
  private String cooperationPhone;
  @DateTimeFormat(pattern = "yyyy-MM-dd") //入参
  @JSONField(format = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")//出参
  private Date createtime;
  private String examine;
  private String leader;
  private String content;
  private String accessory;
  private int processid;
  private int processUserid;
  private String processState;
  private SysUser principalUser;
  private BdClient client;
  private SysUser processUser;
  private SysApprovalProcess process;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updatetime;

}