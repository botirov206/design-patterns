public class GiftWrapDecorator extends OrderDecorator {
    private static final double PRICE = 15_000;

    public GiftWrapDecorator(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return order.getDescription() + ", sovg'a qadoqlash";
    }

    @Override
    public double getPrice() {
        return order.getPrice() + PRICE;
    }
}
