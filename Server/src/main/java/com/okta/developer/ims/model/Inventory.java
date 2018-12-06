package com.okta.developer.ims.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@Entity
//@Builder
@Table(name = "inventory")
//@Data
public class Inventory {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public InventoryType getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(InventoryType inventoryType) {
		this.inventoryType = inventoryType;
	}

	@Column(name = "name")
	private String name;
	@Column(name = "quantity")
	private Long quantity;
	@Column(name = "created_time")
	private Timestamp createdTime;
	@Column(name = "updated_time")
	private Timestamp updatedTime;
	@Column(name = "enabled")
	private Integer enabled;
	@JoinColumn(name = "inventory_type_id", referencedColumnName = "ID")
	@ManyToOne
	private InventoryType inventoryType;
	
	@PrePersist
	void onCreate() {
		this.createdTime = new Timestamp(System.currentTimeMillis());
		this.updatedTime = new Timestamp(System.currentTimeMillis());
	}
	
	@PreUpdate
	void onUpdate() {
		this.updatedTime = new Timestamp(System.currentTimeMillis());
	}
}
