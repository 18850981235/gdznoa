package com.beans;

import lombok.Data;




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
  private BdProject Project;

}
