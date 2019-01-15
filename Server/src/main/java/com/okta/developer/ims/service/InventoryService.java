package com.okta.developer.ims.service;

import com.okta.developer.ims.dto.InventoryDTO;
import com.okta.developer.ims.model.Inventory;

import java.util.List;

public interface InventoryService {
	public InventoryDTO createInventory(InventoryDTO inventoryDTO);

	public InventoryDTO getInventoryById(Long inventoryId);

	public InventoryDTO updateInventory(InventoryDTO inventoryDTO);

	public InventoryDTO deleteInventory(Long inventoryId);

	public List<InventoryDTO> searchInventory(InventoryDTO inventoryDTO);
}
