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

@RequiredArgsConstructor
@Entity
@Table(name = "inventory")
@Data
public class Inventory {

	@Id
	@Column(name = "id",columnDefinition = "INTEGER(11)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity",columnDefinition = "INTEGER(11)")
	private Long quantity;

	@Column(name = "created_time")
	private Timestamp createdTime;

	@Column(name = "updated_time")
	private Timestamp updatedTime;

	@Column(name = "enabled", columnDefinition = "BIT(1)")
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
