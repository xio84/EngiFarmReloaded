package products;

import java.util.HashSet;
import java.util.Set;

public class CheeseSteak extends SideProduct{
    public CheeseSteak(int price, int expiretick) {
        super(price, expiretick);
        Set<Product> step1 = new HashSet<>();
        step1.add(new Cheese());
        getIngredients().add(step1);
        Set<Product> step2 = new HashSet<>();
        step2.add(new PorkMeat());
        step2.add(new DuckMeat());
        step2.add(new ChickenMeat());
        step2.add(new CowMeat());
        step2.add(new GoatMeat());
        step2.add(new RabbitMeat());
        getIngredients().add(step2);
    }

    public CheeseSteak() {
        super(31000, 24);
        Set<Product> step1 = new HashSet<>();
        step1.add(new Cheese());
        getIngredients().add(step1);
        Set<Product> step2 = new HashSet<>();
        step2.add(new PorkMeat());
        step2.add(new DuckMeat());
        step2.add(new ChickenMeat());
        step2.add(new CowMeat());
        step2.add(new GoatMeat());
        step2.add(new RabbitMeat());
        getIngredients().add(step2);
    }

    @Override
    public int hashCode() {
        return 11;
    }

    @Override
    public String toString() {
        return "Cheese Steak";
    }
}
