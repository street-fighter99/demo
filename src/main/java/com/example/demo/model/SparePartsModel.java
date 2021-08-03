package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class SparePartsModel {

    private int id;
    private String name;
    private int device_model;
    private double actual_price;
    private double sell_price;
    private int is_active;
    private Date cr_date;
    private String cr_user;
    private Double qty;
    private String category;
}
