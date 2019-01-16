package com.okta.developer.ims.utils.factory;

import com.okta.developer.ims.dto.InventoryDTO;
import com.okta.developer.ims.model.Inventory;
import com.okta.developer.ims.utils.Constants;
import com.okta.developer.ims.utils.Constants.ModelFields;
import com.okta.developer.ims.utils.Constants.ModelSQLFields;
import com.okta.developer.ims.utils.ValidationUtils;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class InventorySpecificationFactory {

    private InventorySpecificationFactory() {
    }

    public static Specification<Inventory> isEqual(String attribute, Object value) {
        return (root, query, cb) -> cb.equal(root.get(attribute), value);
    }

    public static Specification<Inventory> isNotEqual(String attribute, Object value) {
        return (root, query, cb) -> cb.notEqual(root.get(attribute), value);
    }

    public static Specification<Inventory> isIn(String attribute, List<String> attributeList) {
        return (root, query, cb) -> root.get(attribute).in(attributeList);
    }

    public static Specification<Inventory> isNotIn(String attribute, List<String> attributeList) {
        return (root, query, cb) -> root.get(attribute).in(attributeList).not();
    }

    public static Specification<Inventory> isEqualAndOrderBy(String attribute, Object value,
                                                             String orderByAtrribute1) {
        return (root, query, cb) -> {
            query.orderBy(cb.asc(root.get(orderByAtrribute1)));
            return cb.equal(root.get(attribute), value);
        };
    }

    public static Specification<Inventory> isOneLevelNestedEqual(String attributeParent,
                                                                 String attribute, Object value) {
        return (root, query, cb) -> cb.equal(root.get(attributeParent).get(attribute), value);
    }

    public static Specification<Inventory> searchInventory(InventoryDTO inventory) {

        List<Specification> specifications = new ArrayList<>();

        // this is added as we will search for enabled data
        specifications.add(isEqual(ModelSQLFields.INVENTORY_ENABLED, Constants.ENABLED));

        if (ValidationUtils.isObjectNotNull(inventory.getQuantity())) {
            specifications.add(isEqual(ModelSQLFields.INVENTORY_QUANTITY, inventory.getQuantity()));
        }

        if (ValidationUtils.isStringNotEmpty(inventory.getName())) {
            specifications.add(isEqual(ModelSQLFields.INVENTORY_NAME, inventory.getName()));
        }

        if (ValidationUtils.isValidInventoryType(inventory.getInventoryType())) {
            specifications.add(isOneLevelNestedEqual(ModelFields.INVENTORY_TYPE, ModelSQLFields.INVENTORY_TYPE, inventory.getInventoryType()));
        }

        Specification<Inventory> result = specifications.get(0);

        for (int i = 1; i < specifications.size(); i++) {
            result = Specification.where(result).and(specifications.get(i));
        }
        return result;
    }

}
