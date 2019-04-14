package products;

public class CowMeat extends FarmProduct{
    public CowMeat(int price, int expiretick) {
        super(price, expiretick);
    }

    public CowMeat() {
        super(16000,8);
    }

    @Override
    public String toString() {
        return "Cow Meat{}";
    }

    @Override
    public int hashCode() {
        return 23;
    }
}
