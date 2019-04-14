package products;

public class ChickenMeat extends FarmProduct{
    public ChickenMeat(int price, int expiretick) {
        //TODO add chicken as source
        super(price, expiretick);
    }

    public ChickenMeat() {
        super(12000, 7);
    }

    @Override
    public String toString() {
        return "Chicken Meat";
    }

    @Override
    public int hashCode() {
        return 22;
    }
}
