package views;

import java.util.List;
import java.util.Scanner;

import controllers.Forca;

public class Tela {
  
  public void iniciar(){
    Scanner in = new Scanner(System.in);
    
    Forca jogoForca = new Forca();

    jogoForca.sortearPalavra();

    int fimJogo = jogoForca.verificaFimJogo();
    do{
      
      fimJogo = jogoForca.verificaFimJogo();
      
      System.out.println("#### JOGO DA FORCA ####\n");
      desenhaForca(jogoForca.getLetrasAcertadas(), jogoForca.getPalavra());
      System.out.print(" ERROS: "+ jogoForca.getErros());
      System.out.println("\n");
      
      System.out.print("Letras ja escolhidas: ");
      letrasEscolhidas(jogoForca.getPalpites());
      System.out.println("\n");
      
      
      if(fimJogo == 0){
        System.out.println("Diga uma letra: ");
        String palpite = in.nextLine();
        
        jogoForca.verificaLetra(palpite);

      }

    }while(fimJogo == 0);

    if(fimJogo == 1){
      System.out.println("PARABENS VC ACERTOU A PALAVRA");
    }else if(fimJogo == 2){
      System.out.println("VOCE ERROU 5 LETRAS.\nVOCE PERDEU");
    }
  }

  public void desenhaForca(int []letrasAcertadas, String palavra){
    
    for(int i = 0; i < palavra.length(); i++){
      if(letrasAcertadas[i] == 0){
        System.out.print(" _ ");
      }else if(letrasAcertadas[i] == 1){
        System.out.print(" "+palavra.charAt(i));
      }
    }

  }

  public void letrasEscolhidas(List<String> palpites){
    for(int i = 0; i < palpites.size(); i++){ 
      System.out.print(palpites.get(i) + " ");
    }
  }
}
