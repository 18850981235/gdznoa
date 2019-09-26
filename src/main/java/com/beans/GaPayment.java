package com.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class GaPayment {
    private Integer id;

    private Integer projectid;

    private Integer userid;

    private String name;

    private String unit;

    private BigDecimal paymentMoney;

    private String type;

    private String matter;

    private String digest;

    private String bankname;

    private String bankaccount;

    private Integer processid;

    private Integer processUserid;

    private String processState;

    private Integer processNode;

    private String accessory;

    private Integer marketid;

    private Integer procurementid;

    private Integer labourid;

    private BigDecimal paid;

    private BigDecimal ticket;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    private BdProject project;
    private SysUser user;

    //销售
    private SdSalesContract salesContract;
    //采收
    private PdProcurementContract pdProcurementContract;
    //劳务
    private PdServiceContract serviceContract;


}