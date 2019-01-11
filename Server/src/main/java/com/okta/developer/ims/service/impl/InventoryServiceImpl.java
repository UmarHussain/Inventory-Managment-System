package com.okta.developer.ims.service.impl;

import java.util.Optional;

import com.okta.developer.ims.utils.Adapter;
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
		Inventory inventory = Adapter.getInstance().convert(inventoryDTO, Inventory.class);
		inventory.setEnabled(Constants.ENABLED);
		inventory.setInventoryType(inventoryType);
		return Adapter.getInstance().convert(inventoryRepository.save(inventory), InventoryDTO.class);
	}

	@Override
	public InventoryDTO getInventoryById(Long inventoryId) {
		return Optional.ofNullable(inventoryId)
				.map(e -> inventoryRepository.findByIdAndEnabled(e, Constants.ENABLED))
				.map(e -> Adapter.getInstance().convert(e, InventoryDTO.class))
				.get();
	}

	@Override
	public InventoryDTO updateInventory(InventoryDTO inventoryDTO) {
		LOGGER.info("starting updateInventory method of InventoryServiceImpl");
		Inventory savedEntity = inventoryRepository.findByIdAndEnabled(inventoryDTO.getInventoryId(), Constants.ENABLED);
		Adapter.getInstance().convert(inventoryDTO, savedEntity);
		return Optional.ofNullable(savedEntity)
				.map(inventoryRepository::save)
				.map(e -> Adapter.getInstance().convert(e, InventoryDTO.class))
				.get();
	}

	@Override
	public InventoryDTO deleteInventory(Long inventoryId) {
		LOGGER.info("starting deleteInventory method of InventoryServiceImpl");
		Inventory savedEntity = inventoryRepository.findByIdAndEnabled(inventoryId, Constants.ENABLED);
		savedEntity.setEnabled(Constants.DISABLED);
		return Optional.ofNullable(savedEntity)
				.map(inventoryRepository::save)
				.map(e -> Adapter.getInstance().convert(e, InventoryDTO.class))
				.get();
	}

}
