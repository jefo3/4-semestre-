package org.volkswagen;
import fabrica.veiculo.IVeiculos;

public class CaminhaoVw implements IVeiculos {
  @Override
  public int getRotas() {
    return 16;
  }
}
