package cell;

import renderables.Renderable;

public class Barn extends Land implements Renderable {

  public Barn() {
    super();
  }

  public char render(){
    return 'b';
  }
  
}
