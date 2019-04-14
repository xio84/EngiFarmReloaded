package products;

public class GoatMeat extends FarmProduct{
    public GoatMeat(int price, int expiretick) {
        super(price, expiretick);
    }

    public GoatMeat() {
        super(14000, 12);
    }

    @Override
    public String toString() {
        return "Goat Meat";
    }
}
