package org.volkswagen;
import fabrica.veiculo.IFabricaVeiculo;
import fabrica.veiculo.IVeiculos;

public class Volkswagen implements IFabricaVeiculo{
  
  private static Volkswagen volkswagen;
  
  private Volkswagen(){}

  public static Volkswagen getInstance(){
    if(volkswagen == null){
      volkswagen = new Volkswagen();
    }
    return volkswagen;
  }

  @Override
  public IVeiculos criarVeiculo(String tipo) {
    IVeiculos veiculo;
    
    switch(tipo){
      case "carro":
        veiculo = new CarroVw();
        break;
      case "moto":
        veiculo = new MotoVw();
        break;
      case "caminhao":
        veiculo = new CaminhaoVw();
        break;
      default:
        veiculo = new CarroVw();
        break;
    }
    
    return veiculo;
  }
}
