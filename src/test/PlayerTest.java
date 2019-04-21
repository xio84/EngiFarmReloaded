import animals.Ayam;
import animals.FarmAnimal;
import linkedlist.LinkedList;
import org.junit.Assert;
import org.junit.Test;
import point.Point;
import products.ChickenEgg;
import products.Product;
import cell.*;
import products.ChickenMeat;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void setMoney() {
        Player P = new Player();
        P.setMoney(10);
        Assert.assertEquals(10, P.getMoney());
    }

    @Test
    public void setWater() {
        Player P = new Player();
        P.setWater(10);
        Assert.assertEquals(10, P.getWater());
    }

    @Test
    public void setCurrentPosition() {
        Player P = new Player();
        Point new_point = new Point();
        P.setCurrentPosition(new_point);
        Assert.assertEquals(new_point, P.getCurrentPosition());
    }

    @Test
    public void setInventory() {
        Player P = new Player();
        LinkedList<Product> new_inventory = new LinkedList<Product>();
        P.setInventory(new_inventory);
        Assert.assertEquals(new_inventory, P.getInventory());
    }

    @Test
    public void move() {
        Player P = new Player();
        Point new_point = new Point();
        P.setCurrentPosition(new_point);
        P.move('A');
        P.getCurrentPosition();
        Assert.assertNotSame(new_point,P.getCurrentPosition());
    }

    @Test
    public void kill() {
        Player P = new Player();
        Ayam A = new Ayam();
        ChickenMeat CM = new ChickenMeat();
        P.kill(A);
        Assert.assertTrue(P.getInventory(0).equals(CM));
    }

    @Test
    public void interactAnimal() {
        Player P = new Player();
        Ayam A = new Ayam();
        ChickenEgg CE = new ChickenEgg();
        P.interactAnimal(A);
        Assert.assertTrue(P.getInventory(0).equals(CE));
    }

    @Test
    public void interactFacility() {
        Player P = new Player();
        Well W = new Well();
        P.interactFacility(W);
        Assert.assertEquals(10, P.getWater());
    }

    @Test
    public void grow() {
        Player P = new Player();
        Cell C = new Cell();
        P.setWater(1);
        P.grow(C);
        Assert.assertEquals(true, C.getGrass());
    }

    @Test
    public void cut() {
        Player P = new Player();
        Cell C = new Cell();
        C.setGrass(true);
        P.cut(C);
        Assert.assertEquals(false, C.getGrass());
    }
}