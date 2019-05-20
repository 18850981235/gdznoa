package com.beans;

import lombok.Data;




@Data
public class SupplierStaff {

  private int id;
  private int supplierid;
  private String dept;
  private String role;
  private String name;
  private String phone;
  private String mobile;
  private String fax;
  private String address;
  private String email;
  private String qq;
  private String wechat;
  private String jobContent;
  private String supName;

  private SupplierTrademark supplierTrademark;

}
