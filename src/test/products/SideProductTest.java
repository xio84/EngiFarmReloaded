package products;

import linkedlist.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import products.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class SideProductTest {

    @Before
    public void setUp(){
        Integer i=0;
        Mayonnaise M = new Mayonnaise();
        for (Set<Product> S: M.getIngredients()
             ) {
            for (Product P : S
                 ) {
                //System.out.println(P.toString());
//                if (P.equals(new DuckEgg())){
//                    System.out.println(P.toString());
//                }
            }
//            System.out.println(i);
            Assert.assertTrue(i.toString(),S.contains(new DuckEgg()));
            Assert.assertTrue(S.contains(new ChickenEgg()));
            i++;
        }
    }

    @Test
    public void available() {
        Mayonnaise M = new Mayonnaise();
        LinkedList<Product> inventory = new LinkedList<>();
        inventory.add(new DuckEgg());
        inventory.add(new DuckMeat());
        Assert.assertFalse(M.available(inventory));
        inventory.add(new ChickenEgg());
        Assert.assertTrue(M.available(inventory));
        Assert.assertTrue(inventory.find(new DuckEgg()) != -1);
        Assert.assertTrue(inventory.find(new ChickenEgg()) != -1);
    }

    @Test
    public void make() {
        Mayonnaise M = new Mayonnaise();
        LinkedList<Product> inventory = new LinkedList<>();
        inventory.add(new DuckEgg());
        inventory.add(new DuckMeat());
        M.make(inventory);
        Assert.assertFalse(M.isReady());
        Assert.assertTrue(inventory.find(new DuckEgg()) != -1);
        inventory.add(new ChickenEgg());
        M.make(inventory);
        Assert.assertFalse(inventory.find(new DuckEgg()) != -1);
        Assert.assertTrue(M.isReady());
    }
}