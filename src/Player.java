import point.Point;
import products.*;
import renderables.Renderable;
import linkedlist.LinkedList;
import animals.*;
import cell.*;
import java.lang.*;
import java.util.Iterator;
import java.util.Scanner;

public class Player implements Renderable{
    protected int money;
    protected int water;
    protected LinkedList<Product> inventory;
    protected Point currentPosition;
    protected char currentView;

    /**
     * Player empty constructor
     */
    public Player(){
        money = 0;
        water = 0;
        currentView = 'W';
        inventory = new LinkedList<>();
        currentPosition = new Point(0,0);
    }

    /**
     * Player constructor with parameters
     * @param _money : to store player's current amount of money
     * @param _water : to store player's current amount of water
     * @param _inventory : to store player's current item
     * @param _currentPosition : to store player's current position in map
     * @param _currentView : to store player's current view in his position
     */
    public Player(int _money, int _water, LinkedList<Product> _inventory, Point _currentPosition, char _currentView){
        money = _money;
        water = _water;
        currentView = _currentView;
        currentPosition = new Point( _currentPosition.getX(), _currentPosition.getY());
        inventory = _inventory;
    }

    /**
     * getter
     * @return money to return player's amount of money
     */
    public int getMoney(){

        return money;
    }

    /**
     * getter
     * @return water to return player's amount of water
     */
    public int getWater(){

        return water;
    }

    /**
     * getter
     * @return player's current position in map
     */
    public Point getCurrentPosition(){

        return currentPosition;
    }

    /**
     * getter
     * @return player's current view (A,S,W,D)
     */
    public char getCurrentView(){

        return currentView;
    }

    /**
     * getter to return inventory based on index
     * @param _index to specify which index to access
     * @return current item in inventory based on index
     */
    public Product getInventory(int _index){

        return inventory.get(_index);
    }

    /**
     * getter to return inventory
     * @return list of inventory
     */
    public LinkedList<Product> getInventory() {
        return inventory;
    }

    /**
     * setter
     * @param _money to set current player's money
     */
    public void setMoney(int _money){

        money = _money;
    }

    /**
     * setter
     * @param _water to set current player's water inventory
     */
    public void setWater(int _water){

        water = _water;
    }

    /**
     * setter
     * @param _currentPosition to set player's current position
     */
    public void setCurrentPosition(Point _currentPosition){

        currentPosition = _currentPosition;
    }

    /**
     * setter
     * @param _index to specify which index to edit
     * @param _product to set item in inventory based on current index
     */
    public void setInventory(int _index, Product _product){
        inventory.set(_product, _index);
    }

    /**
     * method to move player 1 block each time
     * @param _direction to specify which direction to go (A,S,W,D)
     */
    public void move(char _direction){
        if (_direction == 'W' || _direction == 'w'){
            currentView = 'W';
            if (currentPosition.getY() != 0){
                currentPosition.setY(currentPosition.getY()-1);
            }
        } else if (_direction == 'A' || _direction == 'a'){
            currentView = 'A';
            if (currentPosition.getX() != 0){
                currentPosition.setX(currentPosition.getX()-1);
            }
        } else if (_direction == 'S' || _direction == 's'){
            currentView = 'S';
            if (currentPosition.getY() != 20){
                currentPosition.setY(currentPosition.getY()+1);
            }
        } else if (_direction == 'D' || _direction == 'd'){
            currentView = 'D';
            if (currentPosition.getX() != 20){
                currentPosition.setX(currentPosition.getX()+1);
            }
        } else {
            System.out.println("JANGAN SERONG-SERONG MAS, FOKUS");
        }
    }

    /**
     * method to talk (call them to sound()) with animal in the same block
     * @param _animal to specify which animal to interact with
     */
    public void talk(FarmAnimal _animal){
        _animal.Sound();
    }

    /**
     * method to kill animal on the same block and get their resources if available
     * @param _animal to specify which animal to kill
     */
    public void kill(FarmAnimal _animal){
        System.out.println("Start killing");
        if(_animal instanceof Ayam) {
            Product _chickenMeat = new ChickenMeat();
            inventory.addFirst(_chickenMeat);
        }
        else if(_animal instanceof Babi) {
            Product _porkMeat = new PorkMeat();
            inventory.addFirst(_porkMeat);
        }
        else if(_animal instanceof Kambing) {
            Product _goatMeat = new GoatMeat();
            inventory.addFirst(_goatMeat);
        }
        else if(_animal instanceof Bebek) {
            Product _duckMeat = new DuckMeat();
            inventory.addFirst(_duckMeat);
        }
        else if(_animal instanceof  Sapi) {
            Product _cowMeat = new CowMeat();
            inventory.addFirst(_cowMeat);
        }
        else if(_animal instanceof Kelinci) {
            Product _rabbitMeat = new RabbitMeat();
            inventory.addFirst(_rabbitMeat);
        }
        else {
            System.out.println("GA ADA HEWANNYA BEBS");
        }

    }

    /**
     * method to show player on map
     * @return char P
     */
    public char render(){
        return 'P';
    }

    /**
     * to specifically interact with animal (getting their resources)
     * on the same block if available
     * @param _animal to specify which animal to interact with
     */
    public void Interact(FarmAnimal _animal) {
        if(_animal instanceof Ayam) {
            Product _chickenEgg = new ChickenEgg();
            inventory.addFirst(_chickenEgg);
        }
        else if(_animal instanceof Kambing) {
            Product _goatMilk = new GoatMilk();
            inventory.addFirst(_goatMilk);
        }
        else if(_animal instanceof Bebek) {
            Product _duckEgg = new DuckEgg();
            inventory.addFirst(_duckEgg);
        }
        else if(_animal instanceof Sapi) {
            Product _cowMilk = new CowMilk();
            inventory.addFirst(_cowMilk);
        }
    }

    /**
     * to specifically interact with facility
     * on the same block if available
     * @param _facility to specify which product to interact with
     */
    public void Interact(Facility _facility) {

      if(_facility instanceof Well) {
          setWater(10);
      }
      else if(_facility instanceof Truck) {
          Truck f = (Truck) _facility;
          if(f.getCooldownTime() > 0) {
              System.out.println("Truk belum kembali");
          }
          else {
              int i = 0;
              int sum = 0;
              while(getInventory(i) != null) {
                  sum += inventory.get(i).getPrice();
                  i++;
              }
              i--;
              while(getInventory(i) != null) {
                  Product haha = inventory.remove();
                  i--;
              }
              money += sum;
              f.setCooldownTime(15);
          }
      }
      else if(_facility instanceof Mixer) {
          int input;
          boolean found;
          do {
              System.out.println("Produk yang dapat dibuat: ");
              System.out.println("1. Cheese");
              System.out.println("2. Cheese Steak");
              System.out.println("3. Mayonnaise");
              System.out.println("4. Mix Sausage");
              System.out.println("5. Steak Tartare");
              System.out.println("Pilih produk yang ingin dibuat : ");
              Scanner scan = new Scanner(System.in);
              input = scan.nextInt();
              if((input < 1) || (input > 5)) {
                  System.out.println("Input tidak valid");
              }
          } while((input < 1) || (input > 5));
          int x;
          LinkedList<Product> Temp = new LinkedList<>();
          if(input == 1) {
              Cheese C = new Cheese();
              found = false;
              for(int i = 0; i < C.getIngredients().size(); i++) {
                x = -1;
                for(int j = 0; i < getInventory().size();j++) {
                    if (C.getIngredients().get(i).contains(getInventory(j))) {
                        x = j;
                        break;
                    }
                }
                if(x == -1) {
                    getInventory().concat(Temp);
                    found = true;
                    break;
                }
                else {
                    Temp.add(getInventory().delIndex(x));
                }
              }
              if(!found) {
                getInventory().add(C);
              }
              else {
                  System.out.println("Bahan tidak cukup");
              }
          }
          else if(input == 2) {
              CheeseSteak CS = new CheeseSteak();
              found = false;
              for(int i = 0; i < CS.getIngredients().size(); i++) {
                  x = -1;
                  for(int j = 0; i < getInventory().size();j++) {
                      if (CS.getIngredients().get(i).contains(getInventory(j))) {
                          x = j;
                          break;
                      }
                  }
                  if(x == -1) {
                      getInventory().concat(Temp);
                      found = true;
                      break;
                  }
                  else {
                      Temp.add(getInventory().delIndex(x));
                  }
              }
              if(!found) {
                  getInventory().add(CS);
              }
              else {
                  System.out.println("Bahan tidak cukup");
              }
          }
          else if(input == 3) {
              Mayonnaise M = new Mayonnaise();
              found = false;
              for(int i = 0; i < M.getIngredients().size(); i++) {
                  x = -1;
                  for(int j = 0; i < getInventory().size();j++) {
                      if (M.getIngredients().get(i).contains(getInventory(j))) {
                          x = j;
                          break;
                      }
                  }
                  if(x == -1) {
                      getInventory().concat(Temp);
                      found = true;
                      break;
                  }
                  else {
                      Temp.add(getInventory().delIndex(x));
                  }
              }
              if(!found) {
                  getInventory().add(M);
              }
              else {
                  System.out.println("Bahan tidak cukup");
              }
          }
          else if(input == 4) {
              MixSausage MS = new MixSausage();
              found = false;
              for(int i = 0; i < MS.getIngredients().size(); i++) {
                  x = -1;
                  for(int j = 0; i < getInventory().size();j++) {
                      if (MS.getIngredients().get(i).contains(getInventory(j))) {
                          x = j;
                          break;
                      }
                  }
                  if(x == -1) {
                      getInventory().concat(Temp);
                      found = true;
                      break;
                  }
                  else {
                      Temp.add(getInventory().delIndex(x));
                  }
              }
              if(!found) {
                  getInventory().add(MS);
              }
              else {
                  System.out.println("Bahan tidak cukup");
              }
          }
          else {
              SteakTartare ST = new SteakTartare();
              found = false;
              for(int i = 0; i < ST.getIngredients().size(); i++) {
                  x = -1;
                  for(int j = 0; i < getInventory().size();j++) {
                      if (ST.getIngredients().get(i).contains(getInventory(j))) {
                          x = j;
                          break;
                      }
                  }
                  if(x == -1) {
                      getInventory().concat(Temp);
                      found = true;
                      break;
                  }
                  else {
                      Temp.add(getInventory().delIndex(x));
                  }
              }
              if(!found) {
                  getInventory().add(ST);
              }
              else {
                  System.out.println("Bahan tidak cukup");
              }
          }
      }
      else {
          System.out.println("BELI DULU MAS");
      }
    }

    /**
     * method to grow grass if water amount is enough
     * @param _land to specify which land to grow
     */
    public void Grow(Cell _land) {
        System.out.println("Checking...");
        if((water >= 1) && (!_land.getGrass())) {
            System.out.println("Growing grass...");
            _land.setGrass(true);
            System.out.println("Minus water...");
            water--;
            System.out.println("Success");
        }
    }

    /**
     * method to remove grass from land
     * @param _land to specify which land to cut
     */
    public void Cut(Cell _land) {
        System.out.println("Checking...");
        if((_land.getGrass())) {
            System.out.println("Cutting grass...");
            _land.setGrass(false);
            System.out.println("Success");
        }
    }

    /**
     * addInventory is a function to add another object into inventory.
     * @param _product is a Product to name what is being stored.
     */
    public void addInventory(Product _product){
        inventory.addFirst(_product);
    }
}
