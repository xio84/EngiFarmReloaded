package cell;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GrasslandTest {

    @Test
    public void render() {
        Grassland G = new Grassland();
        Assert.assertEquals('.',G.render());
    }

    @Test
    public void setGrass() {
        Grassland G = new Grassland();
        G.setGrass(true);
        Assert.assertEquals(true,G.getGrass());
    }
}