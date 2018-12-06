package com.okta.developer.ims.dto;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;

import com.okta.developer.ims.enums.InventoryTypes;
import com.okta.developer.ims.model.InventoryType;

import lombok.Builder;
import lombok.Data;

//@Data
@Builder
public class InventoryDTO implements Serializable{	
	private String name;
	private Long quantity;
	private String inventoryType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getInventoryType() {
		return inventoryType;
	}
	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}
//	private Timestamp createdTime;
//	private Timestamp updatedTime;
}
