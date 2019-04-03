package com.beans;


import lombok.Data;


import java.util.List;


@Data
public class SysDept {

  private int id;
  private String name;
  private List<SysUser> users;

}
