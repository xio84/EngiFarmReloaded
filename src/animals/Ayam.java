package animals;

import point.Point;

import java.util.concurrent.ThreadLocalRandom;

class Ayam extends EggProducingFarmAnimal implements Renderable {
	public Ayam() {
		int minimum = 0, maximum = 2;
		int newX = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		currentPosition.setX(newX);
		minimum = 0;
		maximum = 2;
		int newY = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		setHungryTick(7);
	}

	public Ayam(int x, int y) {
		Point cur = new Point(x,y);
		setCurrentPosition(cur);
		hungrytick = 7;
	}

	public void Sound() {
		System.out.println("Kukuruyuk");
	}
	
	public void Eat(/*Land _Land*/) {
		if (/*(_land->getGrass()) && */(isHungry())) {
			setHungryTick(7);
			setHungry(false);
			setProducingProduct(true);
		}
	}

	public char render(){
        return 'c';
    }
}
