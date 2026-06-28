package ocp;

interface Notification {
    boolean send(String message);
}

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


public class NotificationService {
    public boolean sendNotification(Notification notification, String message) {
        if (notification == null || message == null || message.isEmpty()) {
            System.out.println("Invalid notification or message!");
            return false;
        }
        return notification.send(message);
    }
}