package com.cagdassalur.billing.strategies;

import com.cagdassalur.billing.beans.Products;

public interface StoreDBStrategy {
    ThreadLocal<Products> getProductInventory();
}
