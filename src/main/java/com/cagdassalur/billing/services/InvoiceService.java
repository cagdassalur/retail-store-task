package com.cagdassalur.billing.services;

import com.cagdassalur.billing.beans.Shopper;

public interface InvoiceService {
    void generate(Shopper shopper);
    void print(Shopper shopper);
}
