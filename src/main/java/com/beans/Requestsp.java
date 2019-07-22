package com.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Requestsp {
    private  int id;
    private  int userid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private String evidence;
    private String evidencePeople;
    private String phone;
    private  String evidencePhone;
    private  String state;
    private  String ermissions;

    private  String userName;
}
