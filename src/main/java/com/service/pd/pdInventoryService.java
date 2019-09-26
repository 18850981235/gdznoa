package com.service.pd;

import com.beans.pdProcurementInventory;

import java.util.List;

public interface pdInventoryService {
    int AddpdInventory(List<pdProcurementInventory> list,int contractid,double total);
}
