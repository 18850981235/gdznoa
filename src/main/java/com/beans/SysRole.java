package com.beans;


import lombok.Data;


import java.io.Serializable;


@Data
public class SysRole implements Serializable {

  private static final long serialVersionUID = 3809563557147269204L;
  private int id;
  private String name;


}
