package cell;

import renderables.Renderable;

public class Land extends Cell implements Renderable {

  public Land() {
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
