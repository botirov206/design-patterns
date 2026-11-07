public interface PaymentFactory {
    void pay(double amount);

    static PaymentFactory create(String type) {
        if (type.equals("payme")) {
            return new Payme();
        }
        if (type.equals("click")) {
            return new Click();
        }
        throw new IllegalArgumentException("Unknown payment: " + type);
    }
}
