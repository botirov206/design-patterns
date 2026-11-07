public class Main {
    public static void main(String[] args) {
        PaymentFactory payme = PaymentFactory.create("payme");
        PaymentFactory click = PaymentFactory.create("click");

        payme.pay(50000);
        click.pay(25000);
    }
}
