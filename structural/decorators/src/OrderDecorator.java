public abstract class OrderDecorator implements Order {
    protected final Order order;

    protected OrderDecorator(Order order) {
        this.order = order;
    }
}
