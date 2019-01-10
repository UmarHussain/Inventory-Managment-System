package com.okta.developer.ims.dto;


import lombok.Builder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Builder
public class InventoryDTO implements Serializable{
	@NotNull
	private String name;
	@NotNull
	private Long quantity;
	@NotNull
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
