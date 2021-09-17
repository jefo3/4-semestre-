public class Sedex implements ICalculaFrete{
  public int calculaFrete(Pedido pedido){
    return pedido.peso * 40;
  }
}
