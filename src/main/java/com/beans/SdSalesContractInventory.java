package com.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
public class SdSalesContractInventory {

  private int id;
  private int projectId;
  private String branchName;
  private int salesContract;
  private int systemId;
  private int subitemId;

  private double total;

  private system system;
  private system subitem;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date stateTime;

  private BdProject Project;

}
