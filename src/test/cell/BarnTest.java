package cell;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarnTest {

    @Test
    public void render() {
        Barn B = new Barn();
        Assert.assertEquals('b',B.render());
    }
}