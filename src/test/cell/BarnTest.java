package cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import renderables.*;

public class BarnTest{

    @Test
    public void available() {
        Barn B = new Barn();
        Assert.assertFalse(B.available(map));
        map.add(new Barn());
        Assert.assertTrue(B.available(map));
        Assert.assertTrue(map.contains(new Barn()));
    }
}