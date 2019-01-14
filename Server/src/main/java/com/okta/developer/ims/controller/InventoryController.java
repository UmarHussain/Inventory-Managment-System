package com.okta.developer.ims.controller;

import com.okta.developer.ims.dto.InventoryDTO;
import com.okta.developer.ims.exception.BaseException;
import com.okta.developer.ims.service.InventoryService;
import com.okta.developer.ims.utils.ValidationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/inventoryService/v1")
public class InventoryController {
	
	private static final Logger LOGGER = LogManager.getLogger(InventoryController.class);
    
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/create")
	ResponseEntity<InventoryDTO> createInventory(@RequestBody InventoryDTO inventoryDTO) throws BaseException {
		LOGGER.info("Creating invenotry");
		ValidationUtils.validateInventoryDTO(inventoryDTO);
		return Optional.ofNullable(inventoryDTO)
				.map(inventoryService::createInventory)
				.map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response))
				.get();
	}

	@GetMapping("/get/{inventoryId}")
	ResponseEntity<InventoryDTO> getInventory(@PathVariable(name = "inventoryId") Long id) throws BaseException {
		LOGGER.info("Fetching Inventory by Id :" + id);
		ValidationUtils.validateInventoryId(id);
		return Optional.ofNullable(id)
				.map(inventoryService::getInventoryById)
				.map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
				.get();
	}

	@PostMapping("/update")
	ResponseEntity<InventoryDTO> updateInventory(@RequestBody InventoryDTO inventoryDTO) {
		LOGGER.info("Updating Inventory");
		return Optional.ofNullable(inventoryDTO)
				.map(inventoryService::updateInventory)
				.map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
				.get();
	}

	@DeleteMapping("/delete")
	ResponseEntity<InventoryDTO> deleteInventory(@RequestBody InventoryDTO inventoryDTO) throws BaseException {
		Long inventoryId = inventoryDTO.getInventoryId();
		LOGGER.info("Deleting Inventory for ID :" + inventoryId);
		ValidationUtils.validateInventoryId(inventoryId);
		return Optional.ofNullable(inventoryId)
				.map(inventoryService::deleteInventory)
				.map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
				.get();
	}
}
