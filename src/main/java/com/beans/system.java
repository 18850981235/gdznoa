package com.beans;

import lombok.Data;

import java.util.List;

@Data
public class system {
    private int id;
    private int f_id;
    private String name;

    private List<system> system;
}
