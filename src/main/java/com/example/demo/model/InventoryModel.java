package com.example.demo.model;


import lombok.Data;

import javax.persistence.Column;

@Data
public class InventoryModel {
    private int spare_id;
    private double in;
    private double out;
    private String category;
    private Double total_amount;

}
