package org.muskan.payment;

import org.muskan.common.PaymentStatus;

public class CreditCardPayment implements PaymentStrategy{
    @Override
    public PaymentStatus processPayment(double amount) {
        System.out.println("Processing credit card payment of " + amount);
        return PaymentStatus.PAID;
    }
}
