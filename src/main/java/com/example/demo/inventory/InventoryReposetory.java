package com.example.demo.inventory;

import com.example.demo.inventory.Entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryReposetory extends JpaRepository<InventoryEntity,Integer> {
}
