package cell;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MixerTest {

    @Test
    public void render() {
        Mixer M = new Mixer();
        Assert.assertEquals('M',M.render());
    }
}