package com.beans;

import lombok.Data;




@Data
public class SdSalesContractInventory {

  private int id;
  private int salesContract;
  private String code;
  private String name;
  private String model;
  private String parameter;
  private int trademarkid;
  private String unit;
  private int num;
  private double unitCost;
  private double total;

}
