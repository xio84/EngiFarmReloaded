package products;

import java.util.ArrayList;
import java.util.Set;

/**
 * Class of SideProduct to be made in mixer
 *
 * @author Oksidian Tafly
 * @version 1.0
 * @since 2019-04-14
 */
public class SideProduct extends Product {
    private ArrayList<Set<Product>> ingredients;//Ingredients to make the product, filled with empty products.
    private ArrayList<Product> madeOf;//Ingredients that were used to make this product, taken form inventory.
    private boolean ready;//If not ready, it can't be sold.

    /**
     * SideProduct Constructor
     * @param price : The selling price of SideProduct
     * @param expiretick : Ticks before SideProduct expires
     */
    SideProduct(int price, int expiretick) {
        super(price, expiretick);
        ingredients = new ArrayList<>();
        madeOf = new ArrayList<>();
        ready = false;
    }

    public ArrayList<Set<Product>> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Set<Product>> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Product> getMadeOf() {
        return madeOf;
    }

    public void setMadeOf(ArrayList<Product> madeOf) {
        this.madeOf = madeOf;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean available(ArrayList<Product> inventory){
        boolean result = true;
        Product temp = new Mayonnaise();
        for (Set<Product> p: ingredients
             ) {
            result = false;
            for (Product q: inventory
                 ) {
                if (p.contains(q)){
                    result = true;
                    madeOf.add(q);
                    temp = q;
                }
            }
            if (!result){
                break;
            }
            else{
                inventory.remove(temp);
            }
        }
        inventory.addAll(madeOf);
        madeOf.clear();
        return result;
    }

    public void make(ArrayList<Product> inventory){
        if (available(inventory)) {
            for (Set<Product> p: ingredients
            ) {
                for (Product q: inventory
                ) {
                    if (p.contains(q)){
                        madeOf.add(q);
                    }
                }
            }
            for (Product q : madeOf
            ) {
                inventory.remove(q);
            }
            ready = true;
        }
    }

    @Override
    public boolean sellable() {
        return expired()&&ready;
    }
}
