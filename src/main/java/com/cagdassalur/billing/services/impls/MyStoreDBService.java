package com.cagdassalur.billing.services.impls;

import com.cagdassalur.billing.beans.Product;
import com.cagdassalur.billing.daos.StoreDao;
import com.cagdassalur.billing.services.StoreDBService;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

public class MyStoreDBService implements StoreDBService {

    StoreDao storeDao;

    public MyStoreDBService(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
    public Set<Product> getInventory() {
        return storeDao.getAllProducts();
    }

    @Override
    public boolean isTransactionAllowed(UUID pid, int quantity) {
        boolean response = false;
        Product product = storeDao.getProduct(pid);
        if (product != null && product.getQuantity() >= quantity) {
            response = true;
        }
        return response;
    }

    @Override
    public void updateInventory(Set<Product> cartProducts) {
        Set<Product> inventoryToUpdate = new LinkedHashSet<>(cartProducts.size());
        for (Product p : cartProducts) {
            Product storeProduct = storeDao.getProduct(p.getId());
            if (isTransactionAllowed(p.getId(), p.getQuantity())) {
                storeProduct.setQuantity(storeProduct.getQuantity() - p.getQuantity());
                inventoryToUpdate.add(storeProduct);
            }
        }
        if (!inventoryToUpdate.isEmpty()) {
            storeDao.updateInventoryBatch(inventoryToUpdate);
        }
    }
}
