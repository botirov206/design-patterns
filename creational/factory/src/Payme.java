public class Payme implements PaymentFactory {
    @Override
    public void pay(double amount) {
        System.out.println("Payme: paid " + amount);
    }
}
