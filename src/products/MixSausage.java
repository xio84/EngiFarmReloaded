package products;

import java.util.HashSet;
import java.util.Set;

public class MixSausage extends SideProduct{
    public MixSausage(int price, int expiretick) {
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
        step2.add(new PorkMeat());
        step2.add(new DuckMeat());
        step2.add(new ChickenMeat());
        step2.add(new CowMeat());
        step2.add(new DuckMeat());
        step2.add(new RabbitMeat());
        getIngredients().add(step2);
    }

    public MixSausage() {
        super(62000, 19);
        Set<Product> step1 = new HashSet<>();
        step1.add(new PorkMeat());
        step1.add(new DuckMeat());
        step1.add(new ChickenMeat());
        step1.add(new CowMeat());
        step1.add(new DuckMeat());
        step1.add(new RabbitMeat());
        getIngredients().add(step1);
        Set<Product> step2 = new HashSet<>();
        step2.add(new PorkMeat());
        step2.add(new DuckMeat());
        step2.add(new ChickenMeat());
        step2.add(new CowMeat());
        step2.add(new DuckMeat());
        step2.add(new RabbitMeat());
        getIngredients().add(step2);
    }

    @Override
    public int hashCode() {
        return 13;
    }

    @Override
    public String toString() {
        return "Mix Sausage";
    }
}
