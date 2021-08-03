package com.example.demo.services;


import com.example.demo.inventory.Entity.InventoryEntity;
import com.example.demo.inventory.InventoryReposetory;
import com.example.demo.model.InventoryModel;
import com.example.demo.model.SparePartsModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class InventoryService {
    @Autowired
    InventoryReposetory inventoryReposetory;


    private final ModelMapper modelMapper=new ModelMapper();


    public void AddInventory(SparePartsModel spareModel) {
        InventoryEntity inventoryEntity=modelMapper.map(spareModel,InventoryEntity.class);

        inventoryEntity.setSpare_id(spareModel.getId());
        inventoryEntity.setCategory(spareModel.getCategory());
        if (spareModel.getCategory()=="in"){

            inventoryEntity.setIn(spareModel.getQty());
            inventoryEntity.setOut(0);

        }else
        {
            inventoryEntity.setOut(spareModel.getQty());
            inventoryEntity.setIn(0);
        }
        inventoryEntity.setDate(new Timestamp(new Date().getTime()));
        double total=spareModel.getQty()*spareModel.getSell_price();
        inventoryEntity.setTotal_amount(total);

       inventoryReposetory.saveAndFlush(inventoryEntity);
    }
}
