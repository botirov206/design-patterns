public class PaymeFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new Payme();
    }
}
