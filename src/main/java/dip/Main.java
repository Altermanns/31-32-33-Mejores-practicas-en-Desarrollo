package dip;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistema de Pagos (Aplicando DIP) ---");

        PaymentMethod creditCard = new CreditCardPayment();
        PaymentMethod paypal = new PayPalPayment();
        PaymentMethod crypto = new CryptoPayment();

        PaymentProcessor processor1 = new PaymentProcessor(creditCard);
        PaymentProcessor processor2 = new PaymentProcessor(paypal);
        PaymentProcessor processor3 = new PaymentProcessor(crypto);

        System.out.println(processor1.makePayment(150.0));
        System.out.println(processor2.makePayment(45.50));
        System.out.println(processor3.makePayment(0.005));
    }
}