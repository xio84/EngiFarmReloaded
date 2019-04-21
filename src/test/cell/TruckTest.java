package cell;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TruckTest {

    @Test
    public void render() {
        Truck T = new Truck();
        Assert.assertEquals('T',T.render());
    }

    @Test
    public void setCooldownTime() {
        Truck T = new Truck();
        T.setCooldownTime(15);
        Assert.assertEquals(15,T.getCooldownTime());
    }
}