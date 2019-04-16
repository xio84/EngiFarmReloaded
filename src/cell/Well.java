package cell;

import renderables.Renderable;

public class Well extends Facility implements Renderable {

  public Well() {
    super();
  }

  public char render() {
    return 'w';
  }
  
}
