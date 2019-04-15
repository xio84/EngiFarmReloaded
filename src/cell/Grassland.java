package cell;

public class Grassland extends Land {

  public Grassland() {
    super();
  }

  public char render() {
    if(Grass) {
      return('*');
    }
    else {
      return('.');
    }
  }
}
