package cell;

public class Grassland extends Land implements Renderable {

  public Grassland() {
    super();
  }

  public char render() {
    if (Grass) {
      return('*');
    }
    else {
      return('.');
    }
  }
}
