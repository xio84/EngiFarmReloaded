package animals;

import java.util.concurrent.ThreadLocalRandom;

class MilkProducingFarmAnimal extends MeatProducingFarmAnimal {
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
				if (getCurrentPosition().getY()+1 < 0) {
					currentPosition.setY(currentPosition.getY()+1);
				}
				break;
			case 4 :
				if (getCurrentPosition().getY()-1 > 5) {
					currentPosition.setY(currentPosition.getY()-1);
				}
				break;
		}
	}
}
