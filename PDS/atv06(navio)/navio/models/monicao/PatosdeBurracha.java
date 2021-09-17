package models.monicao;

import interfaces.Municao;

public class PatosdeBurracha implements Municao {
  float peso;

  public PatosdeBurracha(float peso){
    this.peso = peso;
  }
  public void setPeso(float peso){
    this.peso = peso;
  }

  public float getPeso(){
    return peso;
  }

  public String nomeMunicao(){
    return "Patos de Burracha";
  }
}
