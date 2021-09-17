package org.fiat;

import fabrica.veiculo.IFabricaVeiculo;
import fabrica.veiculo.IVeiculos;

public class Fiat implements IFabricaVeiculo{

  private static Fiat fiat;
  
  private Fiat(){}

  public static Fiat getInstance(){
    if(fiat == null){
      fiat = new Fiat();
    }
    return fiat;
  }

  @Override
  public IVeiculos criarVeiculo(String tipo) {
    IVeiculos veiculo;
    
    switch(tipo){
      case "carro":
        veiculo = new CarroFiat();
        break;
      case "moto":
        veiculo = new MotoFiat();
        break;
      case "caminhao":
        veiculo = new CaminhaoFiat();
        break;
      default:
        veiculo = new CarroFiat();
        break;
    }
    
    return veiculo;
  }
}
