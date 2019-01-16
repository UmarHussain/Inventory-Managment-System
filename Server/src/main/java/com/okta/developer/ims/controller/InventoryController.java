package com.okta.developer.ims.controller;

import com.okta.developer.ims.dto.ClientResponse;
import com.okta.developer.ims.dto.InventoryDTO;
import com.okta.developer.ims.exception.BaseException;
import com.okta.developer.ims.service.InventoryService;
import com.okta.developer.ims.utils.factory.ClientResponseFactory;
import com.okta.developer.ims.utils.ValidationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.okta.developer.ims.utils.Constants.UserMessage.*;

@RestController
@RequestMapping("/inventoryService/v1")
public class InventoryController {
	
	private static final Logger LOGGER = LogManager.getLogger(InventoryController.class);
    
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/create")
	ClientResponse<InventoryDTO> createInventory(@RequestBody InventoryDTO inventoryDTO) throws BaseException {
		LOGGER.info("Creating invenotry");
		ValidationUtils.validateInventoryDTO(inventoryDTO);
		return Optional.ofNullable(inventoryDTO)
						.map(inventoryService::createInventory)
						.map(response -> ClientResponseFactory.getClientResponse(DATA_CREATED, response))
						.get();
	}

	@GetMapping("/get/{inventoryId}")
	ClientResponse<InventoryDTO> getInventory(@PathVariable(name = "inventoryId") Long id) throws BaseException {
		LOGGER.info("Fetching Inventory by Id :" + id);
		ValidationUtils.validateInventoryId(id);
		return Optional.ofNullable(id)
						.map(inventoryService::getInventoryById)
						.map(response -> ClientResponseFactory.getClientResponse(DATA_RETRIEVED, response))
						.get();
	}

	@PostMapping("/update")
	ClientResponse<InventoryDTO> updateInventory(@RequestBody InventoryDTO inventoryDTO) {
		LOGGER.info("Updating Inventory");
		return Optional.ofNullable(inventoryDTO)
						.map(inventoryService::updateInventory)
						.map(response -> ClientResponseFactory.getClientResponse(DATA_UPDATED, response))
						.get();
	}

	@DeleteMapping("/delete")
	ClientResponse<InventoryDTO> deleteInventory(@RequestBody InventoryDTO inventoryDTO) throws BaseException {
		Long inventoryId = inventoryDTO.getInventoryId();
		LOGGER.info("Deleting Inventory for ID :" + inventoryId);
		ValidationUtils.validateInventoryId(inventoryId);
		return Optional.ofNullable(inventoryId)
						.map(inventoryService::deleteInventory)
						.map(response -> ClientResponseFactory.getClientResponse(DATA_DELETED, response))
						.get();
	}

	@PostMapping("/search")
	ClientResponse<List<InventoryDTO>> searchInventory(@RequestBody InventoryDTO inventoryDTO) throws BaseException {
		LOGGER.info("Searching invenotry {}", inventoryDTO);
		return Optional.ofNullable(inventoryDTO)
				.map(inventoryService::searchInventory)
				.map(response -> ClientResponseFactory.getClientResponse(DATA_RETRIEVED, response))
				.get();
	}
}
