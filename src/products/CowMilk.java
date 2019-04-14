package products;

public class CowMilk extends FarmProduct{
    public CowMilk(int price, int expiretick) {
        super(price, expiretick);
    }

    public CowMilk() {
        super(8000, 10);
    }

    @Override
    public String toString() {
        return "Cow Milk";
    }

    @Override
    public int hashCode() {
        return 24;
    }
}
