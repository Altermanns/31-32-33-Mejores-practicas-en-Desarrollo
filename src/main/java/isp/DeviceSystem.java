package isp;

interface Switchable {
    String turnOn();
    String turnOff();
}

interface Chargeable {
    String charge();
}

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

class DisposableCamera implements Switchable {
    @Override
    public String turnOn() {
        return "Disposable camera is turning on.";
    }

    @Override
    public String turnOff() {
        return "Disposable camera is turning off.";
    }
}