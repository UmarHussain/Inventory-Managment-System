package com.okta.developer.ims.model;

import javax.persistence.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
@Table(name = "inventory_type")
@Data
public class InventoryType {

	@Id
	@Column(name = "id",columnDefinition = "INTEGER(11)")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "type")
	private String type;
}
