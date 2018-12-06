package com.okta.developer.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
@Table(name = "inventory_type")
@Data
public class InventoryType {
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "type")
	private String type;
}
