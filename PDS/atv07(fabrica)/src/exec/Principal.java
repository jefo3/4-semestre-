package exec;

import org.fiat.CarroFiat;
import org.fiat.Fiat;
import org.volkswagen.Volkswagen;

import fabrica.veiculo.IFabricaVeiculo;
import fabrica.veiculo.IVeiculos;

public class Principal {
  public static void main(String [] args){
    Principal exemploUso = new Principal();

    exemploUso.inicia();
  }

  public void inicia(){
    IFabricaVeiculo fabrica = Volkswagen.getInstance();
    IVeiculos carro = fabrica.criarVeiculo("carro");

    fabrica = Fiat.getInstance();
    IVeiculos moto = fabrica.criarVeiculo("moto");
  }
}
