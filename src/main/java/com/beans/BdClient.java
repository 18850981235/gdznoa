package com.beans;


import lombok.Data;


import java.util.List;


@Data
public class BdClient {

  private int id;
  private String code;
  private String name;
  private int deptid;
  private String unitType;
  private int userid;
  private String content;
  private String phone;
  private String fax;
  private String address;
  private String tfn;
  private String bankaccount;
  private String bankname;
  private String bankaddress;
  private List<BdClientContacts> contacts;
  private SysUser user;
  private  SysDept dept;


}
