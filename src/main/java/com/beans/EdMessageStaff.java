package com.beans;

import lombok.Data;

@Data
public class EdMessageStaff {
    private int id;
    private String name;
    private String phone;
    private int messageid;
    private String staffRole;
    private String idfile;
    private String identityCard;
    private String photo;
    private String buyState;
    private String buyfile;
    private String attendanceTime;
    private String security;
    private String securityfile;
    private String contracts;
    private String contractsfile;
    private String chargeer;
    private String remarks;
    private int isdelete;

    private BdProject project;

}
