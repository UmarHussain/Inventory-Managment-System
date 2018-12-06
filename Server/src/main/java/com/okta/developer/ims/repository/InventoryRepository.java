package com.okta.developer.ims.repository;

import com.okta.developer.ims.model.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Long> {
	
	Inventory findByIdAndEnabled(Long id, Integer enabled);
}
