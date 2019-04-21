package cell;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WellTest {

    @Test
    public void render() {
        Well W = new Well();
        Assert.assertEquals('w',W.render());
    }
}