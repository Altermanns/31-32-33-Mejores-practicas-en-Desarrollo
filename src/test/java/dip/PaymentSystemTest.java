package dip;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentSystemTest {

    @Test
    public void testCreditCardProcessing() {
        PaymentProcessor processor = new PaymentProcessor(new CreditCardPayment());
        String result = processor.makePayment(100.0);
        assertEquals("Processing credit card payment of $100.0", result, "Debe procesar el pago con tarjeta.");
    }

    @Test
    public void testPayPalProcessing() {
        PaymentProcessor processor = new PaymentProcessor(new PayPalPayment());
        String result = processor.makePayment(50.0);
        assertEquals("Processing PayPal payment of $50.0", result, "Debe procesar el pago con PayPal.");
    }

    @Test
    public void testCryptoProcessing() {
        PaymentProcessor processor = new PaymentProcessor(new CryptoPayment());
        String result = processor.makePayment(200.0);
        assertEquals("Processing Crypto payment of $200.0", result, "Debe procesar el pago con Criptomonedas.");
    }

    @Test
    public void testInvalidAmount() {
        // La validación del monto recae en el procesador, no en el método de pago
        PaymentProcessor processor = new PaymentProcessor(new CreditCardPayment());
        String result = processor.makePayment(-10.0);
        assertEquals("Invalid amount.", result, "Debe rechazar montos negativos o en cero.");
    }
}