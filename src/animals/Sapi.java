package animals;

import point.Point;
import renderables.Renderable;

import java.util.concurrent.ThreadLocalRandom;

class Sapi extends MilkProducingFarmAnimal implements Renderable {
	public Sapi() {
		int minimum = 4, maximum = 7;
		int newX = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
//		currentPosition.setX(newX);
		minimum = 0;
		maximum = 5;
		int newY = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
//		currentPosition.setY(newY);
		setCurrentPosition(new Point(newX,newY));
		setHungryTick(11);
	}

	public Sapi(int x, int y) {
		Point cur = new Point(x,y);
		setCurrentPosition(cur);
		setHungryTick(11);
	}

	public void Sound() {
		System.out.println("Moo!");
	}

	public void Eat(/*Land _Land*/) {
		if (/*(_land->getGrass()) && */(isHungry())) {
			setHungryTick(11);
			setHungry(false);
			setProducingProduct(true);
		}
	}

	public char render(){
		return 'S';
	}
}
