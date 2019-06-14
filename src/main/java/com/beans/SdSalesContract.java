package com.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class SdSalesContract {

  private int id;
  private String code;
  private int projectid;
  private int clientid;
  private int deptid;
  private int principal;
  private int branchuser;
  private int areaManager;
  private String invoiceType;
  private double contractAmount;
  private String  contractList;
  private  double addAmount;
  private  String addList;
  private  double reductionAmount;
  private  String reductionList;
  private  double managementRate;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date bidiingTime;
  private String accessory;
  private int processid;
  private int processUserid;
  private String processState;

  private SysDept dept;
  private BdProject project;
  private SysApprovalProcess process;

}
