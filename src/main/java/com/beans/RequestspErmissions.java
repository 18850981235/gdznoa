package com.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class RequestspErmissions {
    private  int id;
    private  int requesid;
    private  int userid;
    private int muneid;

    private SysMenu sysMenu;

}
