package pedraPapelTesoura;

import java.util.Scanner;

public class Tela {
  
  boolean exit;
  
  int hunchPlayar1;
  int champion;
  
  public Tela(){
    exit = false;
  }

  public void startGame(){
    
    Scanner in = new Scanner(System.in);

    PedraPapelTesoura controllerJogo = new PedraPapelTesoura();

    System.out.println("######## Jogo ######\n");
    do{
      System.out.println("## DE SEU PALPITE ##");
      System.out.println("1 - Pedra\n"+
                        "2 - Tesoura\n"+
                        "3 - Papel\n"+
                        "0 - Sair");
      
      
       
      hunchPlayar1 = Integer.parseInt(in.nextLine());

      if(hunchPlayar1 == 0){
        exit = true;
        System.out.println("######## PLACAR FINAL ######\n");
        System.out.println(controllerJogo.scoreBord());
      }else if(hunchPlayar1 < 4 && hunchPlayar1 > 0){

        champion = controllerJogo.win(hunchPlayar1);

        if(champion == 1){
          System.out.println("\nVocê Venceu...\n");
        }else if(champion == 0){
          System.out.println("\nA maquina venceu...\n");
        }else{
          System.out.println("\nEmpate...\n");
        }
        
      }else{
        System.out.println("\nDigite um valor valido...\n");
      }
      
    }while(!exit);
  }

}
