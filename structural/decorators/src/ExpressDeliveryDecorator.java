public class ExpressDeliveryDecorator extends OrderDecorator {
    private static final double PRICE = 25_000;

    public ExpressDeliveryDecorator(Order order) {
        super(order);
    }

    @Override
    public String getDescription() {
        return order.getDescription() + ", tezkor yetkazib berish";
    }

    @Override
    public double getPrice() {
        return order.getPrice() + PRICE;
    }
}
