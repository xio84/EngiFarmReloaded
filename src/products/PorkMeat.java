package products;

public class PorkMeat extends FarmProduct{
    public PorkMeat(int price, int expiretick) {
        super(price, expiretick);
    }

    public PorkMeat() {
        super(5000,6);
    }

    @Override
    public String toString() {
        return "Pork Meat";
    }

    @Override
    public int hashCode() {
        return 20;
    }
}
