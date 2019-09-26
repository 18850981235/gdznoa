package com.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GaComeGO {
    private Integer id;

    private Integer projectid;

    private Integer userid;

    private String name;

    private String unit;

    private BigDecimal paymentMoney;

    private String type;

    private String type2;

    private String matter;

    private String digest;

    private String bankname;

    private String bankaccount;

    private Integer processid;

    private Integer processUserid;

    private String processState;

    private Integer processNode;

    private String accessory;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    private BdProject project;
    private SysUser user;

}