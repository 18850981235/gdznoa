package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.List;


@Data
public class Supplier {

  private int id;
  private String name;
  private String code;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date establishTime;
  private String registeredCapital;
  private String legalPerson;
  private String registeredAddress;
  private String phone;
  private String fax;
  private String postalCode;
  private String email;
  private String url;
  private String type;
  private String grade;
  private String cooperationRecords;
  private String credentialAccessory;
  private String credentialExplain;
  private String tfn;
  private String bankaccount;
  private String bankname;
  private String bankaddress;
  private String cashAccount;
  private String cashAccountName;
  private String template;
  private int recorder;
  private SysUser sysUser;

  private List<SupplierStaffMiddle> supplierTrademarks;

}
