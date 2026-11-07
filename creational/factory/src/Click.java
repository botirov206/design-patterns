public class Click implements PaymentFactory {
    @Override
    public void pay(double amount) {
        System.out.println("Click: paid " + amount);
    }
}
