package org.azamat.projections.purchase;

import java.util.Date;

public interface PurchaseDateLastNameDiscountBookNameQuantity {
    int getOrder_id();
    Date getSellDate();
    int getQuantity();

    String getLastName();
    int getDiscount();

    String getBookName();
}
