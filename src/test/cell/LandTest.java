package cell;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LandTest {

    @Test
    public void setGrass() {
        Land L = new Land();
        L.setGrass(true);
        Assert.assertEquals(true,L.getGrass());
    }

    @Test
    public void render() {
        Land L = new Land();
        L.setGrass(true);
        Assert.assertEquals('*',L.render());
    }
}