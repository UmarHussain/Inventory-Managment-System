package com.okta.developer.ims.repository;

import org.springframework.data.repository.CrudRepository;
import com.okta.developer.ims.model.InventoryType;

public interface InventoryTypeRepository extends CrudRepository<InventoryType, Long> {
	InventoryType findByType(String type);
}
