package com.example.demo.Controllers;

import com.example.demo.model.SparePartsModel;
import com.example.demo.services.SparePartsServices;
import com.example.demo.spareParts.Entity.SparePartsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spare")
public class SparePartsController {


    @Autowired
    SparePartsServices sparePartsServices;

    @PostMapping("/addNewSpare")
    ResponseEntity AddNewSpare(@RequestBody SparePartsModel spareModel){

        ResponseEntity<SparePartsEntity> responseEntity= sparePartsServices.AddNewItem(spareModel);
        return responseEntity;

    }

}
