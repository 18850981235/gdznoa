package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


@Data
public class GaHarvestTicket {

  private int id;
  private int projectid;
  private String companyName;
  private String name;
  private String content;
  private String type;
  private int type2;
  private double cost;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;
  private String bankaccount;
  private String bankname;
  private String accountname;
  private String accessory;
  private int processid;
  private int processUserid;
  private String processState;



}
