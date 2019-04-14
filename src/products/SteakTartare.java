package products;

import java.util.HashSet;
import java.util.Set;

public class SteakTartare extends SideProduct{

    public SteakTartare(int price, int expiretick) {
        super(price, expiretick);
        Set<Product> step1 = new HashSet<>();
        step1.add(new PorkMeat());
        step1.add(new DuckMeat());
        step1.add(new ChickenMeat());
        step1.add(new CowMeat());
        step1.add(new DuckMeat());
        step1.add(new RabbitMeat());
        getIngredients().add(step1);
        Set<Product> step2 = new HashSet<>();
        step2.add(new ChickenEgg());
        step2.add(new DuckEgg());
        getIngredients().add(step2);
    }

    public SteakTartare() {
        super(40000, 29);
    }

    @Override
    public int hashCode() {
        return 14;
    }

    @Override
    public String toString() {
        return "Steak Tartare";
    }
}
