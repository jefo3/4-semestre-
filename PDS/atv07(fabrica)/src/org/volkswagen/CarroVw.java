package org.volkswagen;
import fabrica.veiculo.IVeiculos;

public class CarroVw implements IVeiculos {
  @Override
  public int getRotas() {
    return 4;
  }
}
