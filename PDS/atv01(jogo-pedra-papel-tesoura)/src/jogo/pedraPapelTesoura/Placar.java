package pedraPapelTesoura;

public class Placar {
  int player1;
  int pc;

  public Placar(){
    player1 = 0;
    pc = 0;
  }
  
  public int getPlayer1() {
    return this.player1;
  }


  public int getPc() {
    return this.pc;
  }

  

  public void setPlayer1() {
    this.player1++;
  }
  
  public void setPc() {
    this.pc++;
  }

}
