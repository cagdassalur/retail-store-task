package com.cagdassalur.billing.services;

import com.cagdassalur.billing.exceptions.InventoryShortageException;
import com.cagdassalur.billing.beans.Product;
import com.cagdassalur.billing.beans.ShoppingCart;

import java.util.Set;
import java.util.UUID;

public interface ShoppingCartService {
    boolean addProduct(Product product, ShoppingCart shoppingCart);

    boolean addProductBatch(Set<Product> products, ShoppingCart shoppingCart);

    boolean removeProduct(UUID pid, ShoppingCart shoppingCart);

    boolean updateProduct(Product product, ShoppingCart shoppingCart);

    Product getProduct(UUID pid, ShoppingCart shoppingCart);

    Set<Product> getAllProducts(ShoppingCart shoppingCart);

    boolean loadNEachFromInventory(int loadQuantity, ShoppingCart shoppingCart) throws InventoryShortageException;

    ShoppingCart getNewShoppingCart();
}
