package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


@Data
public class PdProcurementContract {

  private int id;
  private int projectid;

  private String serialnumber;
  private String code;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;
  private int userid;
  private String address;
  private String demander;
  private int supplierid;
  private String invoicetype;

  private double total;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date checkTime;
  private double advance;
  private String paymenttype;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date arrivalTime;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date deliveryTime;
  private String consignee;
  private String consigneePhone;
  private String carriageAssume;
  private String accompanying;
  private String supplierInstall;
  private int warrantyPeriod;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startTime;
  private String elseMatter;
  private String technicalStandard;

  private String solution;
  private String demanderName;
  private String demanderAddress;
  private String demanderLegalPerson;
  private String demanderConsignor;
  private String demanderPhone;
  private String demanderFax;
  private String demanderDuty;
  private String demanderBank;
  private String demanderAccount;
  private String demanderFile;
  private String supplierName;
  private String supplierAddress;
  private String supplierLegalPerson;
  private String supplierConsignor;
  private String supplierPhone;
  private String supplierFax;
  private String supplierDuty;
  private String supplierBank;
  private String supplierAccount;
  private String supplierFile;
  private String accessory;

  private int processid;
  private int processUserid;
  private String processState;
  private int processNode;

  private  BdProject project;
  private  SysUser user;
  private SysUser processUser;
  private SysApprovalProcess process;

  private  Supplier supplier;
}
