package com.okta.developer.ims.controller;

import com.okta.developer.ims.dto.InventoryDTO;
import com.okta.developer.ims.service.InventoryService;
import com.okta.developer.ims.utils.ValidationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/inventoryService/v1")
public class InventoryController {
	
	private static final Logger LOGGER = LogManager.getLogger(InventoryController.class);
    
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/create")
	ResponseEntity<InventoryDTO> createInventory(@RequestBody InventoryDTO inventoryDTO) {
		LOGGER.info("Creating invenotry");
		if(!ValidationUtils.validateInventoryDTO(inventoryDTO)) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return Optional.ofNullable(inventoryDTO)
				.map(inventoryService::createInventory)
				.map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response))
				.get();
	}
	
	@GetMapping("/get/{inventoryId}")
	ResponseEntity<InventoryDTO> createInventory(@PathVariable(name ="inventoryId") Long id) {
		LOGGER.info("Fetching Inventory by Id :" + id);
		if(!ValidationUtils.validateInventoryId(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return Optional.ofNullable(id)
				.map(inventoryService::getInventoryById)
				.map(response -> ResponseEntity.status(HttpStatus.OK).body(response))
				.get();
	}
}
