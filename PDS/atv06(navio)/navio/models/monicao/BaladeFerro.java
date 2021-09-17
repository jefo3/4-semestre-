package models.monicao;

import interfaces.Municao;

public class BaladeFerro implements Municao {
  float peso;

  public BaladeFerro(float peso){
    this.peso = peso;
  }
  public void setPeso(float peso){
    this.peso = peso;
  }

  public float getPeso(){
    return peso;
  }

  public String nomeMunicao(){
    return "Bala de Ferro";
  }

}
