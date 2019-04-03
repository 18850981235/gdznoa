package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


@Data
public class McFileBorrow {

  private int id;
  private int deptid;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;
  private int userid;
  private String phone;
  private String name;
  private int fileNum;
  private String purpose;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date returntime;
  private String consignee;
  private String consigneeAddress;
  private String consigneePhone;
  private String accessory;
  private int processid;
  private int processUserid;
  private String processState;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updatetime;

  private SysDept dept;
  private SysUser user;
  private SysApprovalProcess process;
  private SysUser processUser;


}
