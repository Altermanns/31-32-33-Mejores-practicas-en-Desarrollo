package srp;

import java.util.regex.Pattern;


class UserValidator {
    public boolean isValidEmail(String email) {
        return Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email);
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }
}

class UserRepository {
    public void saveToDatabase(String email, String password) {
        System.out.println("Saving user to the database...");
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }
}

class NotificationService {
    public void sendWelcomeEmail(String email) {
        System.out.println("Sending welcome email to " + email);
    }
}


public class UserManager {
    private final UserValidator validator;
    private final UserRepository repository;
    private final NotificationService notificationService;

    public UserManager(UserValidator validator, UserRepository repository, NotificationService notificationService) {
        this.validator = validator;
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public boolean addUser(String email, String password) {
        if (validator.isValidEmail(email) && validator.isValidPassword(password)) {
            repository.saveToDatabase(email, password);
            notificationService.sendWelcomeEmail(email);
            return true;
        } else {
            System.out.println("Invalid email or password. User not added.");
            return false;
        }
    }
}