package cell;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoopTest {

    @Test
    public void render() {
        Coop C = new Coop();
        Assert.assertEquals('o',C.render());
    }
}