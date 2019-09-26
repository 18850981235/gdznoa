package com.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GaOpenTicket {
    private Integer id;

    private Integer projectid;

    private Integer userid;

    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    private BigDecimal cost;

    private String explain;

    private String type;

    private String bankaccount;

    private String bankname;

    private String accountname;

    private Integer clientid;

    private String contene;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnedMoneyTime;

    private BigDecimal returnedMoney;

    private BigDecimal debt;

    private String accessory;

    private Integer processid;

    private Integer processUserid;

    private String processState;

    private Integer processNode;

    private BdProject project;
    private SysUser user;
   }