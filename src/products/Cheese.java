package products;

import java.util.HashSet;
import java.util.Set;

public class Cheese extends SideProduct {
    public Cheese(int price, int expiretick) {
        super(price, expiretick);
        Set<Product> step1 = new HashSet<>();
        step1.add(new CowMilk());
        step1.add(new GoatMilk());
        getIngredients().add(step1);
        Set<Product> step2 = new HashSet<>();
        step2.add(new CowMilk());
        step2.add(new GoatMilk());
        getIngredients().add(step2);
    }

    public Cheese() {
        super(4000,4);
        Set<Product> step1 = new HashSet<>();
        step1.add(new CowMilk());
        step1.add(new GoatMilk());
        getIngredients().add(step1);
        Set<Product> step2 = new HashSet<>();
        step2.add(new CowMilk());
        step2.add(new GoatMilk());
        getIngredients().add(step2);
    }

    @Override
    public int hashCode() {
        return 12;
    }

    @Override
    public String toString() {
        return "Cheese";
    }
}
