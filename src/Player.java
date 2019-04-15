import java.io.*;
import java.util.*;
import Point.*;
import LinkedList.*;

public class Player extends Renderable{
    protected int money;
    protected int water;
    protected LinkedList<Product> inventory;
    protected Point currentPostion;
    protected Char currentView;

    public Player(){
        money = 0;
        water = 0;
        currentView = 'W';
        inventory = new LinkedList<Product>();
        currentPostion(0,0);
    }

    public Player(int _money, int _water, LinkedList<Product> _inventory, Point _currentPosition, char _currentView){

    }

    public int getMoney(){
        return money;
    }

    public int getWater(){
        return water;
    }

    public Point getCurrentPosition(){
        return currentPostion;
    }

    public Char getCurrentView(){
        return currentView;
    }

    public Product getInventory(int _index){
        return inventory.get(_index);
    }

    // LinkedList Product

    public void setMoney(int _money){
        money = _money;
    }

    public void setWater(int _water){
        water = _water;
    }

    public void setCurrentPosition(Point _currentPosition){
        currentPostion = _currentPosition;
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
            cout << "JANGAN SERONG-SERONG MAS, FOKUS";
        }
    }

}