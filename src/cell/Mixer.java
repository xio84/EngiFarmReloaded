package cell;

import renderables.Renderable;

public class Mixer extends Facility implements Renderable {

  public Mixer() {
    super();
  }

  public char render(){
    return 'M';
  }
  
}
