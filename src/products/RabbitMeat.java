package products;

public class RabbitMeat extends FarmProduct{
    public RabbitMeat(int price, int expiretick) {
        super(price, expiretick);
    }

    public RabbitMeat() {
        super(7000, 9);
    }

    @Override
    public String toString() {
        return "Rabbit Meat";
    }

    @Override
    public int hashCode() {
        return 27;
    }
}
