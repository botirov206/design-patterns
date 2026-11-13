public class Main {
    public static void main(String[] args) {
        PaymentFactory paymeFactory = getPaymentFactory("payme");
        Payment payme = paymeFactory.createPayment();
        payme.pay(50000);

        PaymentFactory clickFactory = getPaymentFactory("click");
        Payment click = clickFactory.createPayment();
        click.pay(25000);
    }

    private static PaymentFactory getPaymentFactory(String type) {
        if (type.equals("payme")) {
            return new PaymeFactory();
        }
        if (type.equals("click")) {
            return new ClickFactory();
        }
        throw new IllegalArgumentException("Unknown payment: " + type);
    }
}
