package isp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeviceSystemTest {

    @Test
    public void testPhoneCapabilities() {
        Phone phone = new Phone();

        assertEquals("Phone is turning on.", phone.turnOn(), "El teléfono debe encender.");
        assertEquals("Phone is charging.", phone.charge(), "El teléfono debe cargar.");

        assertTrue(phone instanceof Switchable, "El teléfono debe ser Switchable");
        assertTrue(phone instanceof Chargeable, "El teléfono debe ser Chargeable");
    }

    @Test
    public void testDisposableCameraCapabilities() {
        DisposableCamera camera = new DisposableCamera();

        assertEquals("Disposable camera is turning on.", camera.turnOn(), "La cámara debe encender.");

        assertTrue(camera instanceof Switchable, "La cámara debe ser Switchable");
        assertFalse(camera instanceof Chargeable, "La cámara NO debe implementar Chargeable");
    }
}