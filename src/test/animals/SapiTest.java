package animals;

import org.junit.Assert;
import org.junit.Test;

public class SapiTest {

    @Test
    public void move() {
    }

    @Test
    public void move1() {
    }

    @Test
    public void sound() {
    }

    @Test
    public void eat() {
    }

    @Test
    public void render() {
        Sapi S = new Sapi();
        Assert.assertEquals("Not equal!", 'S', S.render());
    }
}