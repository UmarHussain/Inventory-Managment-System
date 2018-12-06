package com.okta.developer.ims.utils;

import java.util.Optional;

import com.okta.developer.ims.dto.InventoryDTO;
import com.okta.developer.ims.enums.InventoryTypes;
import com.okta.developer.ims.model.Inventory;

public class DTOConversionUtils {
	
	public static Inventory convertInventoryDTOToInventory(InventoryDTO inventoryDTO) {
		Inventory inventory = new Inventory();
		inventory.setName(inventoryDTO.getName());
		inventory.setQuantity(inventoryDTO.getQuantity());
		inventory.setEnabled(1);
		return inventory;
	}
	
	public static InventoryDTO convertInventoryToInventoryDTO(Inventory inventory) {
		return InventoryDTO.builder().name(inventory.getName())
									.inventoryType(inventory.getInventoryType().getType())
									.quantity(inventory.getQuantity())
									.build();
	}
}
