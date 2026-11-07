public class ClickFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
        return new Click();
    }
}
