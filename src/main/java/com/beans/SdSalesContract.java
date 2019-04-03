package com.beans;

import lombok.Data;



@Data
public class SdSalesContract {

  private int id;
  private String code;
  private int projectid;
  private int clientid;
  private String invoiceType;
  private double cooperateCost;
  private double advance;
  private String contractcompliance;
  private double contractcomplianceCost;
  private String advanceAssure;
  private double assureCost;
  private double contractCost;
  private String accessory;
  private int processid;
  private int processUserid;
  private String processState;

}
