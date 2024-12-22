package org.muskan.payment;

public class DebitCard implements PaymentProcessor{
    @Override
    public boolean paymentMode(double amount) {
        return true;
    }
}
