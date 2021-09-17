package servidor.exec;

import servidor.conexao.GerenciadorConexaoServidor;

public class Servidor {
  public static void main(String[] args){
    GerenciadorConexaoServidor server = new GerenciadorConexaoServidor();
    server.iniciarSocket();
  }
}
