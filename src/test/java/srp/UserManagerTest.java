package srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {
    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        // Se ejecuta antes de cada prueba para asegurar un entorno limpio
        UserValidator validator = new UserValidator();
        UserRepository repository = new UserRepository();
        NotificationService notificationService = new NotificationService();

        userManager = new UserManager(validator, repository, notificationService);
    }

    @Test
    public void testAddUser_Success() {
        boolean result = userManager.addUser("alex@domain.com", "securePass123");
        assertTrue(result, "El usuario con credenciales válidas debería guardarse correctamente.");
    }

    @Test
    public void testAddUser_InvalidEmail() {
        boolean result = userManager.addUser("emailInvalido", "securePass123");
        assertFalse(result, "La validación debería fallar si el formato del email es incorrecto.");
    }

    @Test
    public void testAddUser_InvalidPassword() {
        boolean result = userManager.addUser("alex@domain.com", "short");
        assertFalse(result, "La validación debería fallar si la contraseña tiene menos de 8 caracteres.");
    }
}