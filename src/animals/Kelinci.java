package animals;

import point.Point;
import renderables.Renderable;

import java.util.concurrent.ThreadLocalRandom;

class Kelinci extends MeatProducingFarmAnimal implements Renderable {
	public Kelinci() {
		int minimum = 1, maximum = 19;
		int newX = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		currentPosition.setX(newX);
		int newY = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		setHungryTick(6);
	}

	public Kelinci(int x, int y) {
		Point cur = new Point(x,y);
		setCurrentPosition(cur);
		setHungryTick(6);
	}

	public void Sound() {
		System.out.println("Squeak! Drum!");
	}

	public void Eat(/*Land _Land*/) {
		if (/*(_land->getGrass()) && */(isHungry())) {
			setHungryTick(6);
			setHungry(false);
			setProducingProduct(true);
		}
	}

	public char render(){
        return 'k';
    }
}

