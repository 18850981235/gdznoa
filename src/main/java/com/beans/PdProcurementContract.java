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
  private String code;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;
  private String address;
  private String demander;
  private int supplierid;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date deliveryTime;
  private String deliveryAddress;
  private String addressType;
  private String consignee;
  private String consigneePhone;
  private String transportationType;
  private String carriageAssume;
  private String paymenttype;
  private double advance;
  private String invoicetype;
  private String packaging;
  private String technicalStandard;
  private String supplierInstall;
  private int warrantyPeriod;
  private Date startTime;
  private int warrantyDuration;
  private double defaultDeliveryOne;
  private double defaultDeliveryTen;
  private double serveOverdue;
  private double paymentOverdue;
  private String elseMatter;
  private String solution;
  private String demanderName;
  private String demanderAddress;
  private String demanderLegalPerson;
  private String demanderConsignor;
  private String demanderPhone;
  private String demanderFax;
  private String supplierName;
  private String supplierAddress;
  private String supplierLegalPerson;
  private String supplierConsignor;
  private String supplierPhone;
  private String supplierFax;
  private String accessory;
  private int processid;
  private int processUserid;
  private String processState;

}
