package cell;

public class Cell extends Renderable {
  protected boolean Grass;

  public Cell() {
    super();
    Grass = false;
  }

  public void setGrass(boolean _Grass) {
    Grass = _Grass;
  }

  public boolean getGrass() {
    return(Grass);
  }

  public char render() {
    if(Grass) {
      return('*');
    }
    else {
      return(rep);
    }
  }
}
