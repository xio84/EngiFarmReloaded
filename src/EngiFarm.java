import animals.*;
import cell.*;
import point.Point;
import products.*;

import javax.swing.*;
import java.awt.event.*;

import java.util.Scanner;

public class EngiFarm implements ActionListener{
    private JFrame screen;
    private JLabel money, water, inventory;
    private JLabel area;

    private JButton start;
    private JButton moveUp, moveDown, moveRight, moveLeft;
    private JButton talk, interact, kill, grow, cut;
//    private JButton

    private static Map game;

    public EngiFarm() {
        screen = new JFrame();

        money = new JLabel();
        money.setBounds(50,25,100,30);

        water = new JLabel();
        water.setBounds(160,25,100,30);

        inventory = new JLabel();
        inventory.setBounds(300,25,100,300);

        area = new JLabel();
        area.setBounds(20,75,250,200);

        start = new JButton("Start Game");
        start.setBounds(100,300,120,30);
        start.addActionListener(this);

        moveUp = new JButton("Up");
        moveUp.setBounds(100,350,80,30);
        moveUp.addActionListener(this);

        moveDown = new JButton("Down");
        moveDown.setBounds(100,450,80,30);
        moveDown.addActionListener(this);

        moveRight = new JButton("Right");
        moveRight.setBounds(20,400,80,30);
        moveRight.addActionListener(this);

        moveLeft = new JButton("Left");
        moveLeft.setBounds(180,400,80,30);
        moveLeft.addActionListener(this);

        talk = new JButton("Talk");
        talk.setBounds(300,400,80,30);
        talk.addActionListener(this);

        interact = new JButton("Interact");
        interact.setBounds(380,400,80,30);
        interact.addActionListener(this);

        kill= new JButton("Kill");
        kill.setBounds(460,400,80,30);
        kill.addActionListener(this);

        grow = new JButton("Grow");
        grow.setBounds(380,370,80,30);
        grow.addActionListener(this);

        cut = new JButton("Cut");
        cut.setBounds(380,430,80,30);
        cut.addActionListener(this);

        screen.add(money);
        screen.add(water);
        screen.add(inventory);
        screen.add(area);
        screen.add(start);

        screen.setSize(600,600);
        screen.setLayout(null);
        screen.setVisible(true);
    }

    public void updateScreen() {
        game.print();
        money.setText("Money: " + game.Engi.getMoney());
        water.setText("Water: " + game.Engi.getWater());
        inventory.setText(game.getRenderedInventory());
        area.setText(game.getRenderedMap());

        // P e o . S b b b . .   Inventory:
        // o a a . S b b b . .    - SteakTartare
        // o o o . b b * b . .    - RabbitMeat
        // . . . . b b b k . .    - Mayonnaise
        // . . . . b b B b . .    - GoatMilk
        // . . . . b K b b . .    - GoatMeat
        // . . . . . . . . . .    - DuckEgg
        // . . . . . . . . . .    - CowMilk - etc...
        // . . . . . . . . . t   Money: 0
        // . . . . . . . . m w
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == start){
            start.setVisible(false);
            screen.add(moveUp); screen.add(moveDown); screen.add(moveRight); screen.add(moveLeft);
            screen.add(talk); screen.add(interact); screen.add(kill); screen.add(grow); screen.add(cut);
        }
        else if (e.getSource() == moveUp){
            game.Engi.move('w');
        }
        else if (e.getSource() == moveDown){
            game.Engi.move('s');
        }
        else if (e.getSource() == moveRight){
            game.Engi.move('a');
        }
        else if (e.getSource() == moveLeft){
            game.Engi.move('d');
        }
        else if (e.getSource() == talk){
            Point curPos = game.Engi.getCurrentPosition();
            if (game.checkAnimalAt(curPos.getY(), curPos.getX()))
                game.Engi.talk(game.getAnimalAt(curPos.getY(), curPos.getX()));
        }
        else if (e.getSource() == interact){
            Point curPos = game.Engi.getCurrentPosition();
            try {
                if (game.checkAnimalAt(curPos.getY(), curPos.getX()))
                    game.Engi.Interact(game.getAnimalAt(curPos.getX(), curPos.getY()));
                else{
                    Cell c = game.getCell(curPos.getY(), curPos.getX());
//                        auto temp = dynamic_cast<Facility>(c);
                    game.Engi.Interact((Facility) c);
                }
            } catch(Exception err) {

            }
        }
        else if (e.getSource() == kill){
            Point curPos = game.Engi.getCurrentPosition();
            if (game.checkAnimalAt(curPos.getY(), curPos.getX())) {
                game.Engi.kill(game.getAnimalAt(curPos.getX(), curPos.getY()));
                game.delAnimal(game.getAnimalAt(curPos.getX(), curPos.getY()));
            }
        }
        else if (e.getSource() == grow){
            game.growGrass();
        }
        else if (e.getSource() == cut){
            game.cutGrass();
        }

        game.timePassed();
        updateScreen();
    }

    public static void main(String[] args){
        EngiFarm GUIgame = new EngiFarm();

        game = new Map(10,10);
        String command = new String("");
        Scanner scanner = new Scanner(System. in);

        System.out.println("Begin");

        // Please choose your farm layout
        // Coop begin
        Coop newCoop = new Coop();
        game.setCell(newCoop,0,0);
        Coop newCoop1 = new Coop();
        game.setCell(newCoop1,0,1);
        Coop newCoop2 = new Coop();
        game.setCell(newCoop2,0,2);
        Coop newCoop3 = new Coop();
        game.setCell(newCoop3,1,0);
        Coop newCoop4 = new Coop();
        game.setCell(newCoop4,2,0);
        Coop newCoop5 = new Coop();
        game.setCell(newCoop5,2,2);
        Coop newCoop6 = new Coop();
        newCoop6.setGrass(true);
        game.setCell(newCoop6,1,1);
        Coop newCoop7 = new Coop();
        game.setCell(newCoop7,1,2);
        Coop newCoop8 = new Coop();
        game.setCell(newCoop8,2,1);
        // Coop end
        // Barn begin
        Barn newBarn = new Barn();
        game.setCell(newBarn, 0, 4);
        Barn newBarn2 = new Barn();
        game.setCell(newBarn2, 0, 5);
        Barn newBarn3 = new Barn();
        game.setCell(newBarn3, 0, 6);
        Barn newBarn4 = new Barn();
        game.setCell(newBarn4, 0, 7);
        Barn newBarn5 = new Barn();
        game.setCell(newBarn5, 1, 4);
        Barn newBarn6 = new Barn();
        game.setCell(newBarn6, 1, 5);
        Barn newBarn7 = new Barn();
        game.setCell(newBarn7, 1, 6);
        Barn newBarn8 = new Barn();
        game.setCell(newBarn8, 1, 7);
        Barn newBarn9 = new Barn();
        game.setCell(newBarn9, 2, 4);
        Barn newBarn10 = new Barn();
        game.setCell(newBarn10, 2, 5);
        Barn newBarn11 = new Barn();
        game.setCell(newBarn11, 3, 4);
        Barn newBarn12 = new Barn();
        game.setCell(newBarn12, 3, 5);
        Barn newBarn13 = new Barn();
        game.setCell(newBarn13, 3, 6);
        Barn newBarn14 = new Barn();
        game.setCell(newBarn14, 4, 4);
        Barn newBarn15 = new Barn();
        game.setCell(newBarn15, 4, 5);
        Barn newBarn16 = new Barn();
        game.setCell(newBarn16, 4, 6);
        Barn newBarn17 = new Barn();
        game.setCell(newBarn17, 4, 7);
        Barn newBarn18 = new Barn();
        game.setCell(newBarn18, 5, 4);
        Barn newBarn19 = new Barn();
        game.setCell(newBarn19, 5, 5);
        Barn newBarn20 = new Barn();
        game.setCell(newBarn20, 5, 6);
        Barn newBarn21 = new Barn();
        game.setCell(newBarn21, 5, 7);
        Barn newBarn22 = new Barn();
        newBarn22.setGrass(true);
        game.setCell(newBarn22, 2, 6);
        Barn newBarn23 = new Barn();
        game.setCell(newBarn23, 2, 7);
        Barn newBarn24 = new Barn();
        game.setCell(newBarn24, 3, 7);
        Well newWell = new Well();
        game.setCell(newWell, 9, 9);
        Truck newTruck = new Truck();
        game.setCell(newTruck,8,9);
        Mixer newMixer = new Mixer();
        game.setCell(newMixer,9,8);
        // Barn end
        // Animal begin
        EggProducingFarmAnimal newChick = new Ayam(0,1);
        game.addAnimal(newChick);
        EggProducingFarmAnimal newChick1 = new Ayam(1,1);
        game.addAnimal(newChick1);
        EggProducingFarmAnimal newChick2 = new Ayam(2,2);
        game.addAnimal(newChick2);
        EggProducingFarmAnimal newBebek1 = new Bebek(1,2);
        game.addAnimal(newBebek1);
        MeatProducingFarmAnimal newSapi1 = new Sapi(0,4);
        game.addAnimal(newSapi1);
        MeatProducingFarmAnimal newSapi2 = new Sapi(1,4);
        game.addAnimal(newSapi2);
        MeatProducingFarmAnimal newSapi3 = new Sapi(2,4);
        game.addAnimal(newSapi3);
        MeatProducingFarmAnimal newKambing = new Kambing(5,5);
        game.addAnimal(newKambing);
        MeatProducingFarmAnimal newBabi = new Babi(5,6);
        game.addAnimal(newBabi);
        MeatProducingFarmAnimal newKelinci = new Kelinci(7,8);
        game.addAnimal(newKelinci);
        // Animal end
        // Add Inventory
        Product _chickenMeat = new ChickenMeat();
        game.Engi.addInventory(_chickenMeat);

        Product _porkMeat = new PorkMeat();
        game.Engi.addInventory(_porkMeat);

        Product _duckMeat = new DuckMeat();
        game.Engi.addInventory(_duckMeat);

        Product _cowMeat = new CowMeat();
        game.Engi.addInventory(_cowMeat);

        Product _cheese = new Cheese();
        game.Engi.addInventory(_cheese);

        Product _cheeseSteak = new CheeseSteak();
        game.Engi.addInventory(_cheeseSteak);

        Product _chickenEgg = new ChickenEgg();
        game.Engi.addInventory(_chickenEgg);

        Product _cowMilk = new CowMilk();
        game.Engi.addInventory(_cowMilk);

        Product _duckEgg = new DuckEgg();
        game.Engi.addInventory(_duckEgg);

        Product _goatMeat = new GoatMeat();
        game.Engi.addInventory(_goatMeat);

        Product _goatMilk = new GoatMilk();
        game.Engi.addInventory(_goatMilk);

        Product _mayonnaise = new Mayonnaise();
        game.Engi.addInventory(_mayonnaise);

        Product _rabbitMeat = new RabbitMeat();
        game.Engi.addInventory(_rabbitMeat);

        Product _steakTartare = new SteakTartare();
        game.Engi.addInventory(_steakTartare);
        // End

        System.out.println("BeginGame");

        // Time to play the game
        while (!command.equalsIgnoreCase("EXIT")){
            // Tick begin
            if (command.equalsIgnoreCase("MOVE"))
                game.timePassed();
            // Tick end

            if (command.equalsIgnoreCase("MOVE")){
                char direction;
                do {
                    game.print();
                    System.out.print("Move mode (use wasd to move, press e to exit) ");
                    direction = scanner.next().charAt(0);
                    game.Engi.move(direction);
                    if (direction != 'e' && direction != 'E')
                        game.timePassed();
                } while (direction != 'e' && direction != 'E');
            }
            else if (command.equalsIgnoreCase("TALK")){
                Point curPos = game.Engi.getCurrentPosition();
                if (game.checkAnimalAt(curPos.getY(), curPos.getX()))
                    game.Engi.talk(game.getAnimalAt(curPos.getY(), curPos.getX()));
            }
            else if (command.equalsIgnoreCase("INTERACT")){
                Point curPos = game.Engi.getCurrentPosition();
                try {
                    if (game.checkAnimalAt(curPos.getY(), curPos.getX()))
                        game.Engi.Interact(game.getAnimalAt(curPos.getX(), curPos.getY()));
                    else{
                        Cell c = game.getCell(curPos.getY(), curPos.getX());
//                        auto temp = dynamic_cast<Facility>(c);
                        game.Engi.Interact((Facility) c);
                    }
                } catch(Exception e) {
                    System.out.println("There's nothing to interact with");
                }
            }
            else if (command.equalsIgnoreCase("KILL")){
                Point curPos = game.Engi.getCurrentPosition();
                if (game.checkAnimalAt(curPos.getY(), curPos.getX())) {
                    game.Engi.kill(game.getAnimalAt(curPos.getX(), curPos.getY()));
                    game.delAnimal(game.getAnimalAt(curPos.getX(), curPos.getY()));
                }
            }
            else if (command.equalsIgnoreCase("GROW")){
                game.growGrass();
            }
            else if (command.equalsIgnoreCase("CUT")){
                game.cutGrass();
            }

            game.print();

            System.out.print("Command: ");
            System.out.print("          ");
            System.out.print("type 'EXIT' to exit\r");
            System.out.print("Command: ");

            command = scanner.nextLine();

        }
    }
}
