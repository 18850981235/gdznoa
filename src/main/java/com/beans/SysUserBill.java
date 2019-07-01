package com.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SysUserBill {
    private  int id;
    private  int userId;
    private  String userName;
    private String type;
    private  int amount;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JSONField(format = "yyyy-MM-dd  hh:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd  hh:mm:ss")
    private Date tradeDate;
    private  String reciprocal;

}
