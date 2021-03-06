package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUser implements Serializable {


  private static final long serialVersionUID = 1872425575460764781L;
  private int id;
  private String name;
  private String account;
  private String password;
  private int sex;
  private String phone;
  private String email;
  private int deptid;
  private int roleid;
  private String dept;
  private String role;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;

}
