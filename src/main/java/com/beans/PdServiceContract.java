package com.beans;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


@Data
public class PdServiceContract {

  private int id;
  private int projectid;
  private String code;
  private String name;
  private String firstParty;
  private String secondParty;
  private String constructionRange;
  private String constructionAddress;
  private double contractAmount;
  private int reportDay;
  private int auditTime;
  private int auditDay;
  private double paymentCost;
  private int allAccomplishDay;
  private double allPaymentCost;
  private int residueCostDay;
  private String secondPartyBankaccount;
  private String secondPartyBankname;
  private String secondPartyName;
  private int unqualifiedDay;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date projectStartTime;
  @JsonFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date projectOverTime;
  private String firstPartyRepresentative;
  private String secondPartyRepresentative;
  private double projectDelayOne;
  private int deregulationDay;
  private int contractNum;
  private int bothContractNum;
  private String solution;
  private String accessoryName;
  private String firstPartyAddress;
  private String secondPartyIdentityCard;
  private String accessory;
  private int processid;
  private int processUserid;
  private String processState;

}
