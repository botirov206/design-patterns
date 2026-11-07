public class Payme implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Payme: paid " + amount);
    }
}
