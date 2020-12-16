package com.cagdassalur.billing.services;

import com.cagdassalur.billing.beans.Product;

import java.util.Set;
import java.util.UUID;

public interface StoreDBService {
    Set<Product> getInventory();

    boolean isTransactionAllowed(UUID pid, int quantity);

    void updateInventory(Set<Product> cartProducts);
}
