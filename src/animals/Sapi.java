package animals;

import point.Point;

import java.util.concurrent.ThreadLocalRandom;

class Sapi extends MilkProducingFarmAnimal {
	Sapi() {
		int minimum = 4, maximum = 7;
		int newX = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		currentPosition.setX(newX);
		minimum = 0;
		maximum = 5;
		int newY = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		setHungryTick(11);
	}
	Sapi(int x, int y) {
		Point cur = new Point(x,y);
		setCurrentPosition(cur);
		setHungryTick(11);
	}
	void Sound() {
		System.out.println("Moo!");
	}
	void Eat(/*Land _Land*/) {
		if (/*(_land->getGrass()) && */(isHungry())) {
			setHungryTick(11);
			setHungry(false);
			setProducingProduct(true);
		}
	}
}
