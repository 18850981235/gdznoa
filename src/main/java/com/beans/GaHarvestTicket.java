package com.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GaHarvestTicket {
    private Integer id;

    private Integer projectid;

    private Integer userid;

    private String companyName;

    private String name;

    private String content;

    private String type;

    private String inorout;

    private BigDecimal cost;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    private String bankaccount;

    private String bankname;

    private String accountname;

    private String accessory;

    private Integer processid;

    private Integer processUserid;

    private String processState;

    private Integer processNode;

    private String identifyNumber;

    private String phone;

    private Integer contractid;

    private String payaccount;

    private String proceedsaccount;

    private BdProject project;
    private SysUser user;
}