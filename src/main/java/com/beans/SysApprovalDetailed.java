package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Data
public class SysApprovalDetailed {

  private int id;
  private String approvalName;
  private int approvalId;//id号
  private int approvalUser;
  private String state;//通过不通过
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date approvalDate;
  private String opinion;//审批内容
  private String approvalIdentity;
  private SysUser user;

}
