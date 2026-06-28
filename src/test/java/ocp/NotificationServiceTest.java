package ocp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {
    private NotificationService service;

    @BeforeEach
    public void setUp() {
        service = new NotificationService();
    }

    @Test
    public void testSendEmailNotification() {
        boolean result = service.sendNotification(new EmailNotification(), "Test Email");
        assertTrue(result, "El envío de Email debería retornar true.");
    }

    @Test
    public void testSendSMSNotification() {
        boolean result = service.sendNotification(new SMSNotification(), "Test SMS");
        assertTrue(result, "El envío de SMS debería retornar true.");
    }

    @Test
    public void testInvalidNotification() {
        boolean result = service.sendNotification(null, "Test");
        assertFalse(result, "Si la notificación es nula, debe retornar false y manejar el error.");
    }

    @Test
    public void testOCPExtensibility() {
        // Demostramos que podemos agregar un nuevo tipo (Telegram) sin modificar NotificationService
        Notification telegramNotification = new Notification() {
            @Override
            public boolean send(String message) {
                return true;
            }
        };
        boolean result = service.sendNotification(telegramNotification, "Test Telegram");
        assertTrue(result, "El sistema debe aceptar nuevos tipos de notificación implementando la interfaz.");
    }
}