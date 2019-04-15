package cell;

public class Land extends Cell {

  public Land() {
    super();
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
