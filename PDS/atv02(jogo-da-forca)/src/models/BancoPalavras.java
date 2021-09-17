package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BancoPalavras {
  List<String> palavras;
  
  public BancoPalavras() {
    this.palavras = new ArrayList<String>();
    this.preencherBancoPalavras();
  } 

  public String sorteaPalavra(){
    Random generator = new Random(); 
    
    int index = generator.nextInt(this.palavras.size());
    
    return this.palavras.get(index);
  }

  public void preencherBancoPalavras(){
    String v[] = {"batata", "baleia", "maça", "olho", "piolho", "maconha",
      "flor", "camisa", "tenis", "cachaca", "ponto"
    };

    for(String x: v){
      this.palavras.add(x);
    }
  }


}