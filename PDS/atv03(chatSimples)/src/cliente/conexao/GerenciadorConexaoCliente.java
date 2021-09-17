package cliente.conexao;

import java.net.Socket;

import cliente.mensagem.GerenciadorMensagemCliente;
import servidor.conexao.ConfiguracaoServidor;

public class GerenciadorConexaoCliente {
  ConfiguracaoCliente configCliente;
  ConfiguracaoServidor configServer;
  boolean fechar = false;
  public GerenciadorConexaoCliente(){
    configCliente = new ConfiguracaoCliente("192.168.1.13", 12345);
  }

  public void iniciarCliente(){
    try {
      while(fechar != true){
        Socket cliente = new Socket(configCliente.getHost(), configCliente.getPorta());
        GerenciadorMensagemCliente m = new GerenciadorMensagemCliente(cliente);
        fechar = m.receberMensagem();
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}
