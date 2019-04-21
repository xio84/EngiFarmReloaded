package animals;

import point.Point;
import renderables.Renderable;

import java.util.concurrent.ThreadLocalRandom;

public class Bebek extends EggProducingFarmAnimal implements Renderable {
	public Bebek() {
		int minimum = 0, maximum = 2;
		int newX = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		currentPosition.setX(newX);
		minimum = 0;
		maximum = 2;
		int newY = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		setHungryTick(8);
	}

	public Bebek(int x, int y) {
		Point cur = new Point(x,y);
		setCurrentPosition(cur);
		setHungryTick(8);
	}

	public void Sound() {
		System.out.println("Quack!");
	}

	public void Eat(/*Land _Land*/) {
		if (/*(_land->getGrass()) && */(isHungry())) {
			setHungryTick(8);
			setHungry(false);
			setProducingProduct(true);
		}
	}

	public char render(){
        return 'e';
    }
}

