package servidor.conexao;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import servidor.mensagem.GerenciadorMensagemServidor;

public class GerenciadorConexaoServidor{
  ServerSocket servidor;
  ConfiguracaoServidor confServer;
  Scanner in;
  public GerenciadorConexaoServidor(){
    confServer = new ConfiguracaoServidor(12345);
    in = new Scanner(System.in);
  }

  public void iniciarSocket(){
    try{

      servidor = new ServerSocket(confServer.getPorta());
      //String mensagem = in.nextLine();
      System.out.println("Server Ligado");
      this.ouvirConexao();
    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public void ouvirConexao(){
    try{
      while(true){
        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
        GerenciadorMensagemServidor m = new GerenciadorMensagemServidor(cliente);
        String mensagem = in.nextLine();
        m.mensagem(mensagem);
        cliente.close();
      }
    }catch(IOException e){
      e.printStackTrace();
    }
  }
}