import java.util.ArrayList;

public class Inventario implements InventarioObservavel, Observador {
  int ovosPegos = 0;
  ArrayList<InventarioObservador> observadores = new ArrayList<InventarioObservador>();

  public void fuiPego(Observavel ovo){
    this.ovosPegos++;
    if(this.ovosPegos == 100){
      this.notifique();
    }
  }

  public void addObservadores(InventarioObservador observador){
    this.observadores.add(observador);
  }

  public void notifique(){
    for(InventarioObservador obs: this.observadores){
      obs.coletei100();
    }
  }

}
