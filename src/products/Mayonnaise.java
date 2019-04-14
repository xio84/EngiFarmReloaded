package products;

import java.util.HashSet;
import java.util.Set;

public class Mayonnaise extends SideProduct {
    public Mayonnaise(int price, int expiretick) {
        super(price, expiretick);
        Set<Product> step1 = new HashSet<>();
        step1.add(new ChickenEgg());
        step1.add(new DuckEgg());
        getIngredients().add(step1);
        Set<Product> step2 = new HashSet<>();
        step2.add(new ChickenEgg());
        step2.add(new DuckEgg());
        getIngredients().add(step2);
    }

    public Mayonnaise() {
        super(27000, 20);
        Set<Product> step1 = new HashSet<>();
        step1.add(new ChickenEgg());
        step1.add(new DuckEgg());
        getIngredients().add(step1);
        Set<Product> step2 = new HashSet<>();
        step2.add(new ChickenEgg());
        step2.add(new DuckEgg());
        getIngredients().add(step2);
    }

    @Override
    public int hashCode() {
        return 10;
    }

    @Override
    public String toString() {
        return "Mayonnaise";
    }
}
