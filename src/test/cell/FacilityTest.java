package cell;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FacilityTest {

    @Test
    public void getGrass() {
        Facility F = new Facility();
        Assert.assertEquals(true,F.getGrass());
    }
}