package ocp;

// 1. Interfaz que define el contrato (Abierta a la extensión)
interface Notification {
    boolean send(String message);
}

// 2. Implementaciones concretas para cada tipo de notificación
class EmailNotification implements Notification {
    @Override
    public boolean send(String message) {
        System.out.println("Sending Email: " + message);
        return true;
    }
}

class SMSNotification implements Notification {
    @Override
    public boolean send(String message) {
        System.out.println("Sending SMS: " + message);
        return true;
    }
}

class PushNotification implements Notification {
    @Override
    public boolean send(String message) {
        System.out.println("Sending Push Notification: " + message);
        return true;
    }
}

// 3. Servicio principal (Cerrado a la modificación)
// Ya no necesita condicionales IF/ELSE. Utiliza polimorfismo.
public class NotificationService {
    public boolean sendNotification(Notification notification, String message) {
        if (notification == null || message == null || message.isEmpty()) {
            System.out.println("Invalid notification or message!");
            return false;
        }
        // Delega la ejecución a la implementación concreta
        return notification.send(message);
    }
}