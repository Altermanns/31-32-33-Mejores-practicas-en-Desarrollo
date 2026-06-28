package isp;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistema de Dispositivos (Aplicando ISP) ---");

        Phone phone = new Phone();
        DisposableCamera camera = new DisposableCamera();

        System.out.println("\nDemostrando funcionalidades del Teléfono:");
        System.out.println(phone.turnOn());
        System.out.println(phone.charge());
        System.out.println(phone.turnOff());

        System.out.println("\nDemostrando funcionalidades de la Cámara Desechable:");
        System.out.println(camera.turnOn());
        System.out.println(camera.turnOff());

        System.out.println("\nEjecución completada sin excepciones de operaciones no soportadas.");
    }
}