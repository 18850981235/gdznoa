package com.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class GaOuterTubePass {
    private Integer id;

    private Integer deptid;

    private Integer userid;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    private Integer projectid;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date accomplishTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date validTime;

    private String consignee;

    private String consigneeAddress;

    private String consigneePhone;

    private String relevantDocument;

    private String accessory;

    private Integer processid;

    private Integer processUserid;

    private String processState;

    private Integer processNode;

    private String remark;

    private SysDept dept;
    private SysUser user;
    private BdProject project;

}