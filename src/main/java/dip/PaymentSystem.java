package dip;

interface PaymentMethod {
    String processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public String processPayment(double amount) {
        return "Processing credit card payment of $" + amount;
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public String processPayment(double amount) {
        return "Processing PayPal payment of $" + amount;
    }
}

class CryptoPayment implements PaymentMethod {
    @Override
    public String processPayment(double amount) {
        return "Processing Crypto payment of $" + amount;
    }
}

class PaymentProcessor {
    private final PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String makePayment(double amount) {
        if (amount <= 0) {
            return "Invalid amount.";
        }
        return paymentMethod.processPayment(amount);
    }
}