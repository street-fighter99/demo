package com.example.demo.spareParts;

import com.example.demo.spareParts.Entity.SparePartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparePartsReposetory extends JpaRepository<SparePartsEntity,Integer> {
    SparePartsEntity getByName(String name);
}
