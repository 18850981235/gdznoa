package com.beans;

import lombok.Data;

@Data
public class GaIncome {
    private Integer id;

    private Integer projectid;

    private String payer;

    private String purpose;

    private String type;

    private String money;

    private String remark;

    private String accessory;

    private Integer processid;

    private Integer processUserid;

    private String processState;

    private Integer processNode;

}