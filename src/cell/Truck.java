package cell;

public class Truck extends Facility {
  private int CooldownTime;

  public Truck() {
    super();
    CooldownTime = 0;
    setRep('t');
  }

  public int getCooldownTime() {
    return(CooldownTime);
  }

  public void setCooldownTime(int _Cooldown) {
    CooldownTime = _Cooldown;
  }
  
}
