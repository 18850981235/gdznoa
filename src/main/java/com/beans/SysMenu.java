package com.beans;

import lombok.Data;




@Data
public class SysMenu {

  private int id;
  private String code;
  private String pcode;
  private String pcodes;
  private String name;
  private String url;
  private int levels;

}
