package cell;

public class Truck extends Facility implements Renderable {
  private int CooldownTime;

  public Truck() {
    super();
    CooldownTime = 0;
  }

  public int getCooldownTime() {
    return(CooldownTime);
  }

  public void setCooldownTime(int _Cooldown) {
    CooldownTime = _Cooldown;
  }
  
  public char render(){
    return 'T';
  }
}
