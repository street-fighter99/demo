package com.example.demo.services;

import com.example.demo.model.SparePartsModel;
import com.example.demo.spareParts.Entity.SparePartsEntity;
import com.example.demo.spareParts.SparePartsReposetory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class SparePartsServices {

    @Autowired
    SparePartsReposetory sparePartsReposetory;

    @Autowired
    InventoryService inventoryService;


    private final ModelMapper modelMapper=new ModelMapper();
    public ResponseEntity AddNewItem(SparePartsModel spareModel) {


        SparePartsEntity spareEntity=isExisitingSpare(spareModel);

        if (spareEntity==null){
            spareEntity=modelMapper.map(spareModel,SparePartsEntity.class);
            spareEntity.setName(spareModel.getName());
            spareEntity.setDevice_model(spareModel.getDevice_model());
            spareEntity.setActual_price(spareModel.getActual_price());
            spareEntity.setSell_price(spareModel.getSell_price());
            spareEntity.setIs_active(spareModel.getIs_active());
            spareEntity.setCr_user(spareModel.getCr_user());
            spareEntity.setCr_date(new Timestamp(new Date().getTime()));
            sparePartsReposetory.saveAndFlush(spareEntity);
            inventoryService.AddInventory(spareModel);


            return  new ResponseEntity<>("Product is added", HttpStatus.ACCEPTED);

        }else{

            inventoryService.AddInventory(spareModel);
            return new ResponseEntity<>("This Product is ALready Exists",HttpStatus.CONFLICT);
        }

    }

    private SparePartsEntity isExisitingSpare(SparePartsModel spareModel) {
        SparePartsEntity sparePartsEntity=sparePartsReposetory.getByName(spareModel.getName());
        return sparePartsEntity;
    }
}
