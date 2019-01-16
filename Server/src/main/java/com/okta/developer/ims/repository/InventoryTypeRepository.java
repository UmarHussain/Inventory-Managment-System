package com.okta.developer.ims.repository;

import com.okta.developer.ims.repository.base.BaseRepository;
import org.springframework.data.repository.CrudRepository;
import com.okta.developer.ims.model.InventoryType;

public interface InventoryTypeRepository extends BaseRepository<InventoryType, Long> {
	InventoryType findByType(String type);
}
