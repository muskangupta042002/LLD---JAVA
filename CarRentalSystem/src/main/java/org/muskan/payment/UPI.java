package org.muskan.payment;

public class UPI implements PaymentProcessor{
    @Override
    public boolean paymentMode(double amount) {
        return true;
    }
}
