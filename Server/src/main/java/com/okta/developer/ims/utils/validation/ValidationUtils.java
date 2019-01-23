package com.okta.developer.ims.utils.validation;

import java.util.Objects;
import java.util.Optional;

import com.okta.developer.ims.exception.BaseException;
import com.okta.developer.ims.utils.constants.Constants;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.util.StringUtils;

import com.okta.developer.ims.dto.InventoryDTO;
import com.okta.developer.ims.enums.InventoryTypes;

public class ValidationUtils {
	
	private ValidationUtils() {}

	public static void validateInventoryDTO(InventoryDTO inventoryDTO) throws BaseException {
		validateInventoryName(inventoryDTO.getName());
		validateInventoryQuantity(inventoryDTO.getQuantity());
		validateInventoryType(inventoryDTO.getInventoryType());
	}

	public static void validateInventoryName(String name) throws BaseException {
		Optional.ofNullable(name)
				.filter(ValidationUtils::isStringNotEmpty)
				.orElseThrow(() -> new BaseException(Constants.ErrorMessage.MANDATORY_DATA,
						           new String[]{Constants.ModelFields.INVENTORY_NAME}));
	}

	public static void validateInventoryQuantity(Long quantity) throws BaseException {
		Optional.ofNullable(quantity)
				.filter(ValidationUtils::isObjectNotNull)
				.filter(ValidationUtils::isPositive)
				.orElseThrow(() -> new BaseException(Constants.ErrorMessage.MANDATORY_DATA,
						           new String[]{Constants.ModelFields.INVENTORY_QUANTITY}));
	}

	public static void validateInventoryType(String type) throws BaseException {
		Optional.ofNullable(type)
				.filter(ValidationUtils::isValidInventoryType)
				.orElseThrow(() -> new BaseException(Constants.ErrorMessage.MANDATORY_DATA,
						           new String[]{Constants.ModelFields.INVENTORY_TYPE}));
	}

	public static void validateInventoryId(Long id) throws BaseException {
		Optional.ofNullable(id)
				.orElseThrow(() -> new BaseException(Constants.ErrorMessage.MANDATORY_DATA,
						           new String[]{Constants.ModelFields.INVENTORY_TYPE}));
	}

	public static Boolean isStringNotEmpty(String string){
		return !StringUtils.isEmpty(string);
	}

	public static Boolean isObjectNotNull(Object object){
		return !Objects.isNull(object);
	}

	public static Boolean isPositive(Long number){
		return number >= 0;
	}

	public static Boolean isValidInventoryType(String type){
		return Optional.ofNullable(type)
						.filter(ValidationUtils::isStringNotEmpty)
						.filter(e -> EnumUtils.isValidEnum(InventoryTypes.class, e))
						.isPresent();
	}

//	public static void validateUser(UserDTO userDTO) throws BaseException {
//		Optional.ofNullable(userDTO)
//				.filter(e -> ValidationUtils.isStringNotEmpty(e.getUserName()))
//				.filter(e -> ValidationUtils.isStringNotEmpty(e.getPassword()))
//				.filter(e -> ValidationUtils.)
//				.orElseThrow(() -> new BaseException(Constants.ErrorMessage.MANDATORY_DATA,
//						new String[]{Constants.ModelFields.INVENTORY_TYPE}));
//	}
}
