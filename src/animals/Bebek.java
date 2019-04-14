package animals;

import point.Point;

import java.util.concurrent.ThreadLocalRandom;

class Bebek extends EggProducingFarmAnimal{
	Bebek() {
		int minimum = 0, maximum = 2;
		int newX = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		currentPosition.setX(newX);
		minimum = 0;
		maximum = 2;
		int newY = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		setHungryTick(8);
	}
	Bebek(int x, int y) {
		Point cur = new Point(x,y);
		setCurrentPosition(cur);
		setHungryTick(8);
	}
	void Sound() {
		System.out.println("Quack!");
	}
	void Eat(/*Land _Land*/) {
		if (/*(_land->getGrass()) && */(isHungry())) {
			setHungryTick(8);
			setHungry(false);
			setProducingProduct(true);
		}
	}
}

