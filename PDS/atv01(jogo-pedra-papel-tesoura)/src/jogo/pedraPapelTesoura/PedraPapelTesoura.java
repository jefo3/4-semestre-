package pedraPapelTesoura;

import java.util.Random;

public class PedraPapelTesoura {
  private int hunchPc;
  private int champion;
  Placar score;
  Random generator;

  public PedraPapelTesoura() {
    score = new Placar();
    generator = new Random();
  }

  
  //retornar 1- playar1 vencendo
  //retorna 0 - pc vencendor
  //retorna 3 - empate
  public int win(int hunchPlayar1){
    hunchPc = hunchComputer();

    //1 - Pedra
    //2 - Tesoura
    //3 - Papel
    if(hunchPlayar1 == 1 && hunchPc == 2){
      score.setPlayer1();
      return 1;
    }else if(hunchPlayar1 == 1 && hunchPc == 3){
      score.setPc();
      return 0;
    }else if(hunchPlayar1 == 1 && hunchPc == 1){
      return 3;
    }else if(hunchPlayar1 == 2 && hunchPc == 1){
      score.setPc();
      return 0;
    }else if(hunchPlayar1 == 2 && hunchPc == 3){
      score.setPlayer1();
      return 1;
    }else if(hunchPlayar1 == 2 && hunchPc == 2){
      return 3;
    }else if(hunchPlayar1 == 3 && hunchPc == 1){
      score.setPlayer1();
      return 1;
    }else if(hunchPlayar1 == 3 && hunchPc == 2){
      score.setPc();
      return 0;
    }else if(hunchPlayar1 == 3 && hunchPc == 3){
      return 3;
    }
    
    return -1;
  }

  public int hunchComputer(){
    return generator.nextInt(3) + 1;
  }

  public String scoreBord(){
    return "[Voce: "+ score.getPlayer1() + " ----- Maquina: "+ score.getPc() +"]";
  }
}
