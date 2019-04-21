package cell;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void setGrass() {
        Cell C = new Cell();
        C.setGrass(true);
        Assert.assertEquals(true,C.getGrass());
    }
}