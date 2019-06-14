package com.beans;

import lombok.Data;

@Data
public class SdSalesInventory {
    private int id;
    private String code;
    private String name;
    private String model;
    private String parameter;
    private int trademarkid;
    private String unit;
    private int num;
    private double unitCost;

    private double subtotal;
    private String remarks;

     private  SupplierTrademark supplierTrademark;


}
