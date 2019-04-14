package products;

public class GoatMilk extends FarmProduct{
    public GoatMilk(int price, int expiretick) {
        super(price, expiretick);
    }

    public GoatMilk() {
        super(15000, 9);
    }

    @Override
    public String toString() {
        return "Goat Milk";
    }

    @Override
    public int hashCode() {
        return 28;
    }
}
