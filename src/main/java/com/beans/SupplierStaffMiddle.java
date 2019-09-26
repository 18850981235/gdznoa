package com.beans;

import lombok.Data;

import java.util.List;

@Data
public class SupplierStaffMiddle {
    private int supplierId;
    private int staff;

    private SupplierTrademark supplierTrademark;
}
