package com.okta.developer.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.okta.developer.ims.model.base.BaseEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
@Table(name = "inventory")
@Data
public class Inventory extends BaseEntity {

	@Id
	@Column(name = "id",columnDefinition = "INTEGER(11)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity",columnDefinition = "INTEGER(11)")
	private Long quantity;

	@Column(name = "enabled", columnDefinition = "BIT(1)")
	private Integer enabled;

	@JoinColumn(name = "inventory_type_id", referencedColumnName = "ID")
	@ManyToOne
	private InventoryType inventoryType;
	

}
