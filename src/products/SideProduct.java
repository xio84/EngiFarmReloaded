package products;

import linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.Set;

/**
 * Class of SideProduct to be made in mixer
 *
 * @author Oksidian Tafly
 * @version 1.1
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

    public boolean available(LinkedList<Product> inventory){
        boolean result = true;
        int temp = -1;
        for (Set<Product> p: ingredients
        ) {
            result = false;
            for (int i = 0; i<inventory.size(); i++) {
                Product q = inventory.get(i);
                if (p.contains(q)){
                    result = true;
                    madeOf.add(q);
                    temp = i;
                }
            }
            if (!result){
                break;
            }
            else{
                inventory.delIndex(temp);
            }
        }
        for (Product x : madeOf
        ) {
            inventory.add(x);
        }
        madeOf.clear();
        return result;
    }

    public void make(LinkedList<Product> inventory){
        if (available(inventory)) {
            for (Set<Product> p: ingredients
            ) {
                for (int i=0; i<inventory.size(); i++) {
                    Product q = inventory.get(i);
                    if (p.contains(q)){
                        madeOf.add(q);
                    }
                }
            }
            for (Product q : madeOf
            ) {
                int i = inventory.find(q);
                inventory.delIndex(i);
            }
            ready = true;
        }
    }

    @Override
    public boolean sellable() {
        return expired()&&ready;
    }
}
