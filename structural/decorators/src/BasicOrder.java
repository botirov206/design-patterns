public class BasicOrder implements Order {
    private final String product;
    private final double price;

    public BasicOrder(String product, double price) {
        this.product = product;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return product;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
