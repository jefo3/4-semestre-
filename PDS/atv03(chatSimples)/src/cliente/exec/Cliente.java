package cliente.exec;

import cliente.conexao.GerenciadorConexaoCliente;

public class Cliente{
  public static void main(String[] args){
    GerenciadorConexaoCliente cliente = new GerenciadorConexaoCliente();

    cliente.iniciarCliente();
  }
}
