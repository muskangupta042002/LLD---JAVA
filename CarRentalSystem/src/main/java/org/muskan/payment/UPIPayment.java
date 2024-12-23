package org.muskan.payment;

import org.muskan.common.PaymentStatus;

public class UPIPayment implements PaymentStrategy{
    @Override
    public PaymentStatus processPayment(double amount) {
        System.out.println("Processing wallet payment of " + amount);
        return PaymentStatus.PAID;
    }
}
