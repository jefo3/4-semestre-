package org.volkswagen;
import fabrica.veiculo.IVeiculos;

public class MotoVw implements IVeiculos{
  @Override
  public int getRotas() {
    return 2;
  }
}
