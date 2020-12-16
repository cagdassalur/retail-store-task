package com.cagdassalur.billing.services.impls;

import com.cagdassalur.billing.constants.ApplicationConstants;
import com.cagdassalur.billing.strategies.InvoicingStrategy;
import com.cagdassalur.billing.beans.Shopper;
import com.cagdassalur.billing.helpers.Utility;
import com.cagdassalur.billing.services.InvoiceService;

import java.util.Collection;

public class MyInvoiceService implements InvoiceService {
    private final InvoicingStrategy invoicingStrategy;

    public MyInvoiceService(InvoicingStrategy invoicingStrategy) {
        this.invoicingStrategy = invoicingStrategy;
    }

    @Override
    public void generate(Shopper shopper) {
        invoicingStrategy.generate(shopper);
    }

    @Override
    public void print(Shopper shopper) {
        //Bill Header
        Utility.printBuffer();
        Utility.printCenter(ApplicationConstants.BILL_HEADER.getApplicationConstant().toString(),
                ApplicationConstants.BILL_PADDING.getApplicationConstant().toString());
        Utility.printBuffer();
        Utility.println(" ");

        //Bill & User Info
        Utility.printBillMeta(shopper);
        Utility.println(" ");

        //Bill Products Info
        Utility.printBuffer();
        Utility.printCenter(ApplicationConstants.BILL_PRODUCT_HEADER.getApplicationConstant().toString(),
                ApplicationConstants.BILL_PADDING.getApplicationConstant().toString());
        Utility.printProducts(shopper.getShoppingCart().getProductsInCart().getProducts().values());
        Utility.printColumn("Total Discount = $" + ApplicationConstants.df.format(shopper.getInvoice().getDiscount()),
                "Discounted Bill = $" + ApplicationConstants.df.format(shopper.getInvoice().getAmount()),
                ApplicationConstants.BILL_SPACE.getApplicationConstant().toString());
        Utility.printBuffer();
    }


}
