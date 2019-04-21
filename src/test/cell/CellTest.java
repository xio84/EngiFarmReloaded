package cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import renderables.*;

public class CellTest{

    @Test
    public void available() {
        Cell C = new Cell();

        Assert.assertEqual("Not Equal", false, C.getGrass());
        Assert.assertEqual("Not Equal", ".", C.render());
        C.setGrass(true);
        Assert.assertEqual("Not Equal", true, C.getGrass());
        Assert.assertEqual("Not Equal", "*", C.render());

    }
}