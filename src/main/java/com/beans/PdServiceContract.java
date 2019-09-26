package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


@Data
public class PdServiceContract {

  private int id;
  private int projectid;
  private String projectaddres;
  private String code;
  private String serialnumber;
  private int userid;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;
  private String address;
  private String  fristParty;
  private int  secondParty;


  private String  fristRepresentative;
  private String   fristName;
  private String  fristAddress;
  private String  fristLegalPerson;
  private String  fristConsignor;
  private String  fristPhone;
  private String  fristFax;
  private String  fristDuty;
  private String  fristBank;
  private String  fristAccount;
  private String  fristFile;
  private String secondRepresentative;
  private String secondName;
  private String secondAddress;
  private String secondLegalPerson;
  private int secondConsignor;
  private String secondPhone;
  private String secondFax;
  private String secondDuty;
  private String secondBank;
  private String secondAccount;
  private String secondFile;

  private  double total;
  private String invoicetype;
  private String paymenttype;
  private double advance;
  private String resultsType;
  private String  satisfaction;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date servicetime;
  private String results;
  private String technicalStandard;
  private String acceptanceCriteria;

  private int warrantyPeriod;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startTime;
  private String solution;
  private String elseMatter;


  private String accessory;
  private int processid;
  private int processUserid;
  private int processNode;
  private String processState;

  private  BdProject project;
  private  SysUser user;
  private SysUser processUser;
  private  SysUser consignorUser;

  private  Supplier supplier;

  private SysApprovalProcess process;


}
