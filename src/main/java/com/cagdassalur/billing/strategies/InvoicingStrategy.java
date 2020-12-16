package com.cagdassalur.billing.strategies;

import com.cagdassalur.billing.beans.Shopper;

public interface InvoicingStrategy {
    void generate(Shopper shopper);
}
