package animals;

import cell.Cell;
import point.Point;

import java.util.concurrent.ThreadLocalRandom;

public class FarmAnimal {
	protected boolean hungry;
	protected int hungrytick;
	protected final int defaulthungrytick = 5;
	protected boolean producingproduct;
	protected Point currentPosition;

	public int getHungryTick() {
		return hungrytick;
	}

	public void setHungryTick(int _hungrytick){
		hungrytick = _hungrytick;
	}

	public void move(){
		int minimum = 1, maximum = 4;
		int chooseMoveType = ThreadLocalRandom.current().nextInt(minimum, maximum + 1);
		hungrytick -= 1;
		if (hungrytick <= defaulthungrytick) {
			hungry = true;
		}
		switch (chooseMoveType) {
			case 1 :
				if (getCurrentPosition().getX()-1 > 4) {
					currentPosition.setX(currentPosition.getX()-1);
				}
				break;
			case 2 :
				if (getCurrentPosition().getX()+1 < 7) {
					currentPosition.setX(currentPosition.getX()+1);
				}
				break;
			case 3 :
				if (getCurrentPosition().getY()+1 < 11) {
					currentPosition.setY(currentPosition.getY()+1);
				}
				break;
			case 4 :
				if (getCurrentPosition().getY()-1 > 0) {
					currentPosition.setY(currentPosition.getY()-1);
				}
				break;
		}
	}
	
	protected boolean isProducingProduct() {
		return producingproduct;
	}

	protected void setProducingProduct(boolean _producingproduct){
		producingproduct = _producingproduct;
	}

	protected boolean isHungry(){
		return hungry;
	}

	protected void setHungry(boolean _hungry){
		hungry = _hungry;
	}

	public Point getCurrentPosition(){
		return currentPosition;
	}

	protected void setCurrentPosition(Point _currentPosition){
		currentPosition = _currentPosition;
	}

	public void Eat(Cell temp) {
		System.out.println("No eating implemented");
	}

	public char render() {
		return '?';
	}

	public void Sound() {
		System.out.println("No sound implemented");
	}
}
