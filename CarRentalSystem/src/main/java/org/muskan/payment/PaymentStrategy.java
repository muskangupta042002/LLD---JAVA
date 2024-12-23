package org.muskan.payment;

import org.muskan.common.PaymentStatus;

public interface PaymentStrategy {
    PaymentStatus processPayment(double amount);
}
