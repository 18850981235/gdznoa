package com.beans;

import lombok.Data;

@Data
public class pdProcurementInventory {
    private int id;
    private  String serialnum;
    private int contractid;
    private String code;
    private String name;
    private String model;
    private String parameter;
    private String trademark;
    private String unit;
    private int num;
    private double unitCost;

    private double subtotal;
    private String remarks;

     private  SupplierTrademark supplierTrademark;


}
