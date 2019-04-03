package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


@Data
public class GaOpenTicket {

  private int id;
  private int projectid;
  private String name;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createtime;
  private double cost;
  private String type;
  private String bankaccount;
  private String bankname;
  private String accountname;
  private int clientid;
  private String contene;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date returnedMoneyTime;
  private double returnedMoney;
  private double debt;
  private String accessory;
  private int processid;
  private int processUserid;
  private String processState;



}
