package animals;

import point.Point;
import renderables.Renderable;
import cell.Cell;

import java.util.concurrent.ThreadLocalRandom;

public class Babi extends MeatProducingFarmAnimal implements Renderable {
	public Babi() {
		int minimum = 4, maximum = 7;
		int newX = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		currentPosition.setX(newX);
		minimum = 0;
		maximum = 5;
		int newY = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		setHungryTick(10);
	}

	public Babi(int x, int y) {
		Point cur = new Point(x,y);
		setCurrentPosition(cur);
		setHungryTick(10);
	}

	public void Sound() {
		System.out.println("Oink!");
	}

	public void Eat(Cell temp) {
		if ((temp.getGrass()) && (isHungry())) {
			setHungryTick(10);
			setHungry(false);
			setProducingProduct(true);
		}
	}

	public char render(){
        return 'B';
    }
}
