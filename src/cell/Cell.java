package cell;

import renderables.Renderable;

public class Cell implements Renderable {
  protected boolean Grass;

  public Cell() {
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
      return('.');
    }
  }
}
