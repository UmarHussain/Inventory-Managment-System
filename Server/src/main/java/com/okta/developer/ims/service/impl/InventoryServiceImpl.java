package com.okta.developer.ims.service.impl;

import java.util.Optional;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okta.developer.ims.dto.InventoryDTO;
import com.okta.developer.ims.model.Inventory;
import com.okta.developer.ims.model.InventoryType;
import com.okta.developer.ims.repository.InventoryRepository;
import com.okta.developer.ims.repository.InventoryTypeRepository;
import com.okta.developer.ims.service.InventoryService;
import com.okta.developer.ims.utils.Constants;
import com.okta.developer.ims.utils.DTOConversionUtils;

@Service
public class InventoryServiceImpl implements InventoryService {

	private static final Logger LOGGER = LogManager.getLogger(InventoryServiceImpl.class);
	
	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private InventoryTypeRepository inventoryTypeRepository;
	
	@Override
	public InventoryDTO createInventory(InventoryDTO inventoryDTO) {
		LOGGER.info("starting createInventory method of InventoryServiceImpl");
		InventoryType inventoryType = inventoryTypeRepository.findByType(inventoryDTO.getInventoryType());
		Inventory inventory = DTOConversionUtils.convertInventoryDTOToInventory(inventoryDTO);
		inventory.setInventoryType(inventoryType);
		return DTOConversionUtils.convertInventoryToInventoryDTO(inventoryRepository.save(inventory));
	}

	@Override
	public InventoryDTO getInventoryById(Long inventoryId) {
		return Optional.ofNullable(inventoryId)
			.map(e->inventoryRepository.findByIdAndEnabled(e, Constants.ENABLED))
			.map(DTOConversionUtils::convertInventoryToInventoryDTO)
			.get();
	}

	@Override
	public void updateInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		
	}

}
