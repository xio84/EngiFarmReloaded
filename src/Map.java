import linkedlist.LinkedList;
import animals.*;
import cell.*;
import java.lang.*;
import java.util.Vector;

class Map{
    /**
     * Positions is a 2D Array of Cells storing the attribute of a Cell of Map object.
     *
     * Default size:
     *  Positions[10][10].
     */
    private Cell[][] Positions;
    private int[][] AnimalExistsCount;
    private int AnimalCount;
    private LinkedList<FarmAnimal> listOfAnimal;
    private Vector listOfTruck;
    private int width, height;

    public Player Engi;
    /**
     * Construct Map class with default value.
     * Call Display class default constructor.
     *
     * Allocate Positions as 2D Array of Cells with the size of default width x height.
     */
    public Map(){
        width = 10;
        height = 10;

        Positions = new Cell [height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                Positions[i][j] = new Cell();
            }
        }

        AnimalExistsCount = new int [height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                AnimalExistsCount[i][j] = 0;
            }
        }

        AnimalCount = 0;

        listOfAnimal = new LinkedList<FarmAnimal>();
        listOfTruck = new Vector();
    }

    /**
     * Construct Map class with user-defined value.
     * Call Display class user-defined constructor.
     *
     * Allocate Positions as 2D Array of Cells with the size of _w x _h.
     */
    public Map(int _w, int _h){
        width = _w;
        height = _h;

        Positions = new Cell [height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                Positions[i][j] = new Cell();
            }
        }

        AnimalExistsCount = new int [height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                AnimalExistsCount[i][j] = 0;
            }
        }

        AnimalCount = 0;

        listOfAnimal = new LinkedList<FarmAnimal>();
        listOfTruck = new Vector();
    }

    /**
     * Destruct Map class.
     *
     * Delocate Positions.
     */

    /**
     * Get the value Cell of Positions[i][j] (Getter).
     *
     * @return the Cell stored in Positions[i][j].
     */
    public Cell getCell(int i, int j){
        return Positions[i][j];
    }

    /**
     * Set the value Cell of Positions[i][j] (Setter).
     *
     * @param _cell is Cell whose value will overwrite the Cell in Positions[i][j].
     * @param i is Integer whose value will decide the row of Positions overwritten.
     * @param j is Integer whose value will decide the column of Positions overwritten.
     */
    public void setCell(Cell _cell, int i, int j){
        Positions[i][j] = _cell;
        Truck T = new Truck();
        if(T instanceof  Cell){
//            T = dynamic_cast<Truck>(_cell);
            listOfTruck.add(T);
        }
    }


    public boolean checkAnimalAt(int i, int j){
        return (AnimalExistsCount[i][j] > 0);
    }

    public FarmAnimal getAnimalAt(int i, int j){
        for (int k = 1; k <= AnimalCount; k++){
            if ((listOfAnimal.get(k).getCurrentPosition().getX() == j) && (listOfAnimal.get(k).getCurrentPosition().getY() == i)){
                return listOfAnimal.get(k);
            }
        }
        return null;
    }

    public void growGrass(){
        // Land& temp = dynamic_cast<Land&>(Positions[Engi.getCurrentPosition().getX()][Engi.getCurrentPosition().getY()]);
        // Positions[Engi.getCurrentPosition().getX()][Engi.getCurrentPosition().getY()].setRep('X');
        System.out.println("growing");
        System.out.println("before: " + Positions[Engi.getCurrentPosition().getY()][Engi.getCurrentPosition().getX()].render());
        // Land temp = dynamic_cast<Land>(Positions[Engi.getCurrentPosition().getX()][Engi.getCurrentPosition().getY()]);
        Cell temp = Positions[Engi.getCurrentPosition().getY()][Engi.getCurrentPosition().getX()];
        Engi.Grow(temp);
        System.out.println("after: " + Positions[Engi.getCurrentPosition().getY()][Engi.getCurrentPosition().getX()].render());
        System.out.println("after: " + Positions[Engi.getCurrentPosition().getY()][Engi.getCurrentPosition().getX()].getGrass());
        System.out.println("after: " + temp.render());
        System.out.println("after: " + temp.getGrass());
    }

    public void cutGrass(){
        // Land& temp = dynamic_cast<Land&>(Positions[Engi.getCurrentPosition().getX()][Engi.getCurrentPosition().getY()]);
        // Positions[Engi.getCurrentPosition().getX()][Engi.getCurrentPosition().getY()].setRep('X');
        System.out.println("growing");
        System.out.println("before: " + Positions[Engi.getCurrentPosition().getY()][Engi.getCurrentPosition().getX()].render());
        // Land temp = dynamic_cast<Land>(Positions[Engi.getCurrentPosition().getX()][Engi.getCurrentPosition().getY()]);
        Cell temp = Positions[Engi.getCurrentPosition().getY()][Engi.getCurrentPosition().getX()];
        Engi.Cut(temp);
        System.out.println("after: " + Positions[Engi.getCurrentPosition().getY()][Engi.getCurrentPosition().getX()].render());
        System.out.println("after: " + Positions[Engi.getCurrentPosition().getY()][Engi.getCurrentPosition().getX()].getGrass());
        System.out.println("after: " + temp.render());
        System.out.println("after: " + temp.getGrass());
    }

    public void addAnimal(FarmAnimal  _animal){
        listOfAnimal.addFirst(_animal);
        AnimalExistsCount[_animal.getCurrentPosition().getX()][_animal.getCurrentPosition().getY()]++;
        AnimalCount++;
    }

    public void delAnimal(FarmAnimal _animal){
        AnimalExistsCount[_animal.getCurrentPosition().getX()][_animal.getCurrentPosition().getY()]--;
        System.out.println("OK1");
        int i = listOfAnimal.find(_animal);
        if (i>0){
            System.out.println(i);
            listOfAnimal.delIndex(i);
        }
        else{
            System.out.println("fail");
        }
        AnimalCount--;
    }

    public void timePassed(){
        for (int k = 1; k <= AnimalCount; k++){
            listOfAnimal.get(k).setHungryTick(listOfAnimal.get(k).getHungryTick() - 1);
            AnimalExistsCount[listOfAnimal.get(k).getCurrentPosition().getX()][listOfAnimal.get(k).getCurrentPosition().getY()]--;
            listOfAnimal.get(k).move();
            AnimalExistsCount[listOfAnimal.get(k).getCurrentPosition().getX()][listOfAnimal.get(k).getCurrentPosition().getY()]++;
            // Land temp = dynamic_cast<Land>(Positions[listOfAnimal.get(k).getCurrentPosition().getX()][listOfAnimal.get(k).getCurrentPosition().getY()]);
            Cell temp = Positions[listOfAnimal.get(k).getCurrentPosition().getX()][listOfAnimal.get(k).getCurrentPosition().getY()];
            listOfAnimal.get(k).Eat(temp);
        }
        for (int k = 0; k<listOfTruck.size(); k++){
            Truck t = (Truck) listOfTruck.get(k);
            if (t.getCooldownTime()>0) {
                t.setCooldownTime(t.getCooldownTime() - 1);
            }
        }
    }

    /**
     * Print the Cells in square format.
     * This is an overloaded method derived from Display class.
     *
     * The implementation will be done by printing all Cells in Position[i][j] with i as row and j as column.
     *
     * @overload
     */
    public void print(){
        boolean moneyPrinted = false;
        boolean waterPrinted = false;
        for (int i = 0; i < height; i++){
            // untuk peta
            for (int j = 0; j < width; j++){
                if ((Engi.getCurrentPosition().getX() == j) && (Engi.getCurrentPosition().getY() == i)){
                    System.out.print(Engi.render());
                }
                else if ((AnimalExistsCount[i][j] > 0)){
                    for (int k = 1; k <= AnimalCount; k++){
//                        assert(listOfAnimal.get(k) != null && "Null Pointer detected");
                        if ((listOfAnimal.get(k).getCurrentPosition().getX() == i) && (listOfAnimal.get(k).getCurrentPosition().getY() == j)){
                            System.out.print(listOfAnimal.get(k).render());
                            break;
                        }
                    }
                }
                else {
//                    assert(Positions[i][j] != null && "Null Pointer detected");
                    System.out.print(Positions[i][j].render());
                }
                System.out.print(" ");
            }
            System.out.print("  ");

            if (i == 0) {
                System.out.print("Inventory:");
            }
            else if ((Engi.getInventory(i) != null) && (i <= 7)) {
                System.out.print(" - ");
//                assert(Engi.getInventory(i) != null && "Null Pointer detected");
                System.out.print(Engi.getInventory(i).getType());
                if (i == 7){
                    System.out.print(" - etc...");
                }
            }
            else if (!moneyPrinted){
                moneyPrinted = true;
                System.out.print("Money: " + Engi.getMoney());
            }
            else if (!waterPrinted){
                waterPrinted = true;
                System.out.print("Water: " + Engi.getWater());
            }

            System.out.println();
        }
    }
}