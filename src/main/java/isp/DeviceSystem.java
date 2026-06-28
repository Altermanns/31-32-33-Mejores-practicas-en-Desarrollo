package isp;

// 1. Interfaz segregada para dispositivos que se pueden encender y apagar
interface Switchable {
    String turnOn();
    String turnOff();
}

// 2. Interfaz segregada para dispositivos que poseen batería recargable
interface Chargeable {
    String charge();
}

// 3. Implementación de un dispositivo complejo (Usa ambas interfaces)
class Phone implements Switchable, Chargeable {
    @Override
    public String turnOn() {
        return "Phone is turning on.";
    }

    @Override
    public String turnOff() {
        return "Phone is turning off.";
    }

    @Override
    public String charge() {
        return "Phone is charging.";
    }
}

// 4. Implementación de un dispositivo simple (Solo usa lo que necesita)
class DisposableCamera implements Switchable {
    @Override
    public String turnOn() {
        return "Disposable camera is turning on.";
    }

    @Override
    public String turnOff() {
        return "Disposable camera is turning off.";
    }
    // No implementa Chargeable, por lo que no está obligada a lanzar excepciones.
}