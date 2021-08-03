package com.example.demo.spareParts.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "spare_parts")
public class SparePartsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "device_model")
    private int device_model;

    @Column(name = "actual_price")
    private double actual_price;

    @Column(name = "sell_price")
    private double sell_price;

    @Column(name = "is_active")
    private int is_active;

    @Column(name = "cr_date")
    private Date cr_date;

    @Column(name = "cr_user")
    private String cr_user;
}
