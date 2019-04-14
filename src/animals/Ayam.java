package animals;

import point.Point;

import java.util.concurrent.ThreadLocalRandom;

class Ayam extends EggProducingFarmAnimal{
	Ayam() {
		int minimum = 0, maximum = 2;
		int newX = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		currentPosition.setX(newX);
		minimum = 0;
		maximum = 2;
		int newY = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		setHungryTick(7);
	}
	Ayam(int x, int y) {
		Point cur = new Point(x,y);
		setCurrentPosition(cur);
		hungrytick = 7;
	}
	void Sound() {
		System.out.println("Kukuruyuk");
	}
	void Eat(/*Land _Land*/) {
		if (/*(_land->getGrass()) && */(isHungry())) {
			setHungryTick(7);
			setHungry(false);
			setProducingProduct(true);
		}
	}
}
