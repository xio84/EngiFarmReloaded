package products;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class CheeseTest {

    @Before
    public void setUp() {
        Integer i=0;
        Cheese M = new Cheese();
        for (Set<Product> S: M.getIngredients()
        ) {
            for (Product P : S
            ) {
                //System.out.println(P.toString());
                if (P.equals(new GoatMilk())){
                    System.out.println(P.toString());
                }
            }
            System.out.println(i);
            Assert.assertTrue(i.toString(),S.contains(new GoatMilk()));
            Assert.assertTrue(S.contains(new CowMilk()));
            i++;
        }
    }

    @Test
    public void available() {
    }

    @Test
    public void make() {
    }
}