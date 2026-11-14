public class Main {
    public static void main(String[] args) {
        Order basic = new BasicOrder("Kitob", 80_000);
        print(basic);

        Order withGift = new GiftWrapDecorator(basic);
        print(withGift);

        Order withExpress = new ExpressDeliveryDecorator(basic);
        print(withExpress);

        Order withGiftAndExpress = new GiftWrapDecorator(withExpress);
        print(withGiftAndExpress);
    }

    private static void print(Order order) {
        System.out.println(order.getDescription() + " — " + order.getPrice() + " so'm");
    }

}
