package com.cagdassalur.billing.strategies.impls;

import com.cagdassalur.billing.beans.Product;
import com.cagdassalur.billing.exceptions.InventoryShortageException;
import com.cagdassalur.billing.helpers.Utility;
import com.cagdassalur.billing.strategies.CartLoadingStrategy;

import java.util.LinkedHashSet;
import java.util.Set;

public class MyCartLoadingStrategy implements CartLoadingStrategy {
    @Override
    public Set<Product> loadNEachFromInventory(Set<Product> inventory, int loadQuantity)
            throws InventoryShortageException {
        Set<Product> cartProducts = new LinkedHashSet<>();
        for (Product p : inventory) {
            Product clone = null;
            try {
                clone = (Product) p.clone();
            } catch (CloneNotSupportedException e) {
                Utility.println(e.getMessage());
                e.printStackTrace();
            }
            if(loadQuantity <= p.getQuantity()){
                clone.setQuantity(loadQuantity);
            }
            else {
                throw new InventoryShortageException();
            }
            cartProducts.add(clone);
        }
        return cartProducts;
    }
}
