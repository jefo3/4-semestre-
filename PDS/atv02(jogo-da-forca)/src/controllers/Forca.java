package controllers;

import java.util.ArrayList;
import java.util.List;

import models.BancoPalavras;

public class Forca {
  String palavra;
  List<String> palpites;
  String palpiteAtual;
  int erros;

  int []letrasAcertadas;

  BancoPalavras bancoPalavra;
  
  public Forca() {
    this.palpites = new ArrayList<String>();
    this.erros = 0;
    
    bancoPalavra = new BancoPalavras();
  }

  public String getPalavra() {
    return this.palavra;
  }

  public void setPalavra(String palavra) {
    this.palavra = palavra;
  }
  public void setPalpites(List<String> palpites) {
    this.palpites = palpites;
  }

  public int[] getLetrasAcertadas() {
    return this.letrasAcertadas;
  }

  public void setLetrasAcertadas(int []letrasAcertadas) {
    this.letrasAcertadas = letrasAcertadas;
  }

  public List<String> getPalpites() {
    return this.palpites;
  }

  public String getPalpiteAtual() {
    return this.palpiteAtual;
  }

  public void setPalpiteAtual(String palpiteAtual) {
    this.palpiteAtual = palpiteAtual;
    
    this.palpites.add(palpiteAtual);
  }

  public int getErros() {
    return this.erros;
  }

  public void setErros(int erros) {
    this.erros = erros;
  }

  public void sortearPalavra(){
    this.palavra = bancoPalavra.sorteaPalavra();
    
    letrasAcertadas = new int[palavra.length()];
    for(int i = 0; i < palavra.length(); i++){
      letrasAcertadas[i] = 0;
    }
  }

  public void verificaLetra(String palpite){ 
    //primeiro verifica se a letra ja nao foi palpitada
    for(int i = 0; i < palpites.size(); i++){
      if(palpite.equals(palpites.get(i))){
        return;
      }
    }

    this.palpites.add(palpite);
    
    boolean errou = true;

    for(int i = 0; i < palavra.length(); i++){
      String letraAtual = this.palavra.charAt(i) + "";
      
      if(letraAtual.equals(palpite)){
        letrasAcertadas[i] = 1;
        errou = false;  
      }
    }
    
    if(errou){
      this.erros += 1;
    }
    
  }

  //1 - fim do jogo pq acertou a palavra
  //2 - fim do jogo pq errou 5 vezes
  //0 - ainda nao acabou
  public int verificaFimJogo(){
    if(this.erros == 5){
      return 2;
    }

    for(int i = 0; i < letrasAcertadas.length; i++){
      //letra acertada tem 1 na posição que ja foi acertada
      if(letrasAcertadas[i] != 1){
        return 0;
      }
    }

    return 1;
  }

}