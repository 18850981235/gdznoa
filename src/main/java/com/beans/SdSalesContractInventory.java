package com.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Data
public class SdSalesContractInventory {

  private int id;
  private int projectId;
  private String type;
  private int system;
  private int salesContract;
  private double total;


  private BdProject Project;
  private  SdSalesContract sdSalesContract;
  private  system systemBean;
  private List<SdSalesInventory> list;

}
