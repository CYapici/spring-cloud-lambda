package domain;

public class User {
    private Pin pin;

    public Pin getPin() {
        return pin;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public User(Pin pin) {
        this.pin = pin;
    }

    public User() {
    }
}
