import point.Point;
import products.*;
import renderables.Renderable;
import linkedlist.LinkedList;
import animals.*;
import cell.*;
import java.lang.*;
import java.util.Scanner;

public class Player implements Renderable{
    protected int money;
    protected int water;
    protected LinkedList<Product> inventory;
    protected Point currentPosition;
    protected char currentView;

    public Player(){
        money = 0;
        water = 0;
        currentView = 'W';
        inventory = new LinkedList<>();
        currentPosition = new Point(0,0);
    }

    public Player(int _money, int _water, LinkedList<Product> _inventory, Point _currentPosition, char _currentView){
        money = _money;
        water = _water;
        currentView = _currentView;
        currentPosition = new Point( _currentPosition.getX(), _currentPosition.getY());
        inventory = _inventory;
    }

    public int getMoney(){

        return money;
    }

    public int getWater(){

        return water;
    }

    public Point getCurrentPosition(){

        return currentPosition;
    }

    public char getCurrentView(){

        return currentView;
    }

    public Product getInventory(int _index){

        return inventory.get(_index);
    }

    public LinkedList<Product> getInventory() {
        return inventory;
    }

    public void setMoney(int _money){

        money = _money;
    }

    public void setWater(int _water){

        water = _water;
    }

    public void setCurrentPosition(Point _currentPosition){

        currentPosition = _currentPosition;
    }

    public void setInventory(int _index, Product _product){
        // inventory.setData(_product, _index);
    }

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

    public void talk(FarmAnimal _animal){
        _animal.Sound();
    }

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

    public char render(){
        return 'P';
    }

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
                x = getInventory().find();
              }
          }
          else if(input == 2) {
              CheeseSteak P = new CheeseSteak();
          }
          else if(input == 3) {
              Mayonnaise P = new Mayonnaise();
          }
          else if(input == 4) {
              MixSausage P = new MixSausage();
          }
          else {
              SteakTartare P = new SteakTartare();
          }

      }
    }

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
}
