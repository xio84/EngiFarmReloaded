package cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import renderables.*;

public class CellTest{

    @Test
    public void available() {
        Cell C = new Cell();

        Assert.assertFalse("Not Equal", C.getGrass());
        Assert.assertEquals("Not Equal", ".", C.render());
        C.setGrass(true);
        Assert.assertTrue("Not Equal", C.getGrass());
        Assert.assertEquals("Not Equal", "*", C.render());

    }
}