package products;

public class ChickenEgg extends FarmProduct {
    public ChickenEgg(int price, int expiretick) {
        //TODO add chicken as source
        super(price, expiretick);
    }

    public ChickenEgg() {
        super(4000,4);
    }

    @Override
    public String toString() {
        return "Chicken Egg";
    }

    @Override
    public int hashCode() {
        return 25;
    }
}
