package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


@Data
public class McDatumCost {

  private int id;
  private int deptid;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;
  private int userid;
  private int projectid;
  private double budget;
  private double mcVerifyCost;
  private double principalCost;
  private String accessory;
  private int processid;
  private int processUserid;
  private String processState;


}
