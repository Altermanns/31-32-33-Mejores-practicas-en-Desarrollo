package ocp;

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        System.out.println("--- Ejecutando Notificaciones Base ---");
        service.sendNotification(new EmailNotification(), "Hello via Email!");
        service.sendNotification(new SMSNotification(), "Hello via SMS!");
        service.sendNotification(new PushNotification(), "Hello via Push Notification!");

        System.out.println("\n--- Demostrando OCP (Extensión sin modificar código) ---");

        Notification faxNotification = message -> {
            System.out.println("Sending Fax: " + message);
            return true;
        };
        service.sendNotification(faxNotification, "Hello via Fax!");
    }
}