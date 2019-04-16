package cell;

import renderables.Renderable;

public class Coop extends Land implements Renderable {

  public Coop() {
    super();
  }

  public char render(){
    return 'o';
  }
  
}
