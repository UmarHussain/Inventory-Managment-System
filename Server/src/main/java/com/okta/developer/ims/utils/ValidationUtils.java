package com.okta.developer.ims.utils;

import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.util.StringUtils;

import com.okta.developer.ims.dto.InventoryDTO;
import com.okta.developer.ims.enums.InventoryTypes;

public class ValidationUtils {
	
	private ValidationUtils() {}
	
	public static Boolean validateInventoryDTO(InventoryDTO inventoryDTO) {
	 	return Optional.ofNullable(inventoryDTO)
				.filter(e -> !StringUtils.isEmpty(e.getName()))
				.filter(e -> !Objects.isNull(e.getQuantity()))
				.filter(e -> !Objects.isNull(e.getInventoryType()))
				.filter(e -> EnumUtils.isValidEnum(InventoryTypes.class, e.getInventoryType()))
				.isPresent();
	}

	public static Boolean validateInventoryId(Long id) {
		return Optional.ofNullable(id)
						.isPresent();
	}
}
