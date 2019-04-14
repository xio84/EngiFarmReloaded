package animals;

import point.Point;

import java.util.concurrent.ThreadLocalRandom;

class Kambing extends MilkProducingFarmAnimal {
	Kambing() {
		int minimum = 4, maximum = 7;
		int newX = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		currentPosition.setX(newX);
		minimum = 0;
		maximum = 5;
		int newY = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		setHungryTick(9);
	}
	Kambing(int x, int y) {
		Point cur = new Point(x,y);
		setCurrentPosition(cur);
		setHungryTick(9);
	}
	void Sound() {
		System.out.println("Baa!");
	}
	void Eat(/*Land _Land*/) {
		if (/*(_land->getGrass()) && */(isHungry())) {
			setHungryTick(9);
			setHungry(false);
			setProducingProduct(true);
		}
	}
}
