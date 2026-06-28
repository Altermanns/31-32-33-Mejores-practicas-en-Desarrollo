package srp;

public class Main {
    public static void main(String[] args) {
        UserValidator validator = new UserValidator();
        UserRepository repository = new UserRepository();
        NotificationService notificationService = new NotificationService();

        UserManager userManager = new UserManager(validator, repository, notificationService);

        System.out.println("Iniciando sistema de gestión de usuarios...");
        userManager.addUser("isaac@udla.edu.ec", "securePass123");
    }
}