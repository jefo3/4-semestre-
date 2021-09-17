public class Pedido {
  int peso;
  int preco;
  ICalculaFrete calculoFrete;

  public Pedido(){
    this.peso = 0;
    this.preco = 0;
    calculoFrete = new Pac();
  }

  public void SetFrete(ICalculaFrete calculaFrete){
    this.calculoFrete = calculaFrete;
  }

  public void calcularFrete(){
    calculoFrete.calculaFrete(this);
  }
}
