package cell;

public class Facility extends Cell {

  public Facility() {
    super();
  }

  public boolean getGrass() {
    System.out.println("Facility tidak memiliki grass");
    return(true);
  }

  public void setGrass(boolean _Grass) {

    System.out.println("Facility tidak dapat ditumbuhi grass");
  }
  
}
