package com.example.demo.inventory.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "spare_id")
    private int spare_id;

    @Column(name = "in")
    private double in;

    @Column(name = "out")
    private double out;

    @Column(name = "date")
    private Date date;

    @Column(name = "category")
    private String category;

    @Column(name = "total_amount")
    private Double total_amount;

}
