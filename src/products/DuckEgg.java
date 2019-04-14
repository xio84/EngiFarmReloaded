package products;

public class DuckEgg extends FarmProduct{
    public DuckEgg(int price, int expiretick) {
        super(price, expiretick);
    }

    public DuckEgg() {
        super(12000, 5);
    }

    @Override
    public String toString() {
        return "Duck Egg";
    }

    @Override
    public int hashCode() {
        return 26;
    }
}
