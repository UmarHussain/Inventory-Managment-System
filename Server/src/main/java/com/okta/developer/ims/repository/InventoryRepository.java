package com.okta.developer.ims.repository;

import com.okta.developer.ims.model.Inventory;
import com.okta.developer.ims.repository.base.BaseRepository;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends BaseRepository<Inventory, Long> {
	
	Inventory findByIdAndEnabled(Long id, Integer enabled);
}
