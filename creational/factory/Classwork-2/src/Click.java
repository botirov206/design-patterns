public class Click implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Click: paid " + amount);
    }
}
