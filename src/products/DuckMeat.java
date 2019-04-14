package products;

public class DuckMeat extends FarmProduct{
    public DuckMeat(int price, int expiretick) {
        super(price, expiretick);
    }

    public DuckMeat() {
        super(18000, 9);
    }

    @Override
    public String toString() {
        return "Duck Meat";
    }

    @Override
    public int hashCode() {
        return 21;
    }
}
