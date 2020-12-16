package com.cagdassalur.billing.strategies;

import com.cagdassalur.billing.beans.Product;
import com.cagdassalur.billing.exceptions.InventoryShortageException;

import java.util.Set;

public interface CartLoadingStrategy {
    Set<Product> loadNEachFromInventory(Set<Product> inventory, int loadQuantity) throws InventoryShortageException;
}
