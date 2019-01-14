package com.okta.developer.ims.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InventoryDTO implements Serializable{

	private Long inventoryId;
	private String name;
	private Long quantity;
	private String inventoryType;

}
