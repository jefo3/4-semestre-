import java.util.ArrayList;

public class Ovo implements Observavel {
  ArrayList<Observador> observadores = new ArrayList<Observador>();
  
  public void addObservadores(Observador observador){
    this.observadores.add(observador);
  }
  public void notifique(){
    for(Observador obs: this.observadores){
      obs.fuiPego(this);
    }
  }

  public void pega(){
    this.notifique();
  }
}
