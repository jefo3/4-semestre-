package servidor.mensagem;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class GerenciadorMensagemServidor{
  Socket cliente;
  public GerenciadorMensagemServidor(Socket cliente){
    this.cliente = cliente;
  }

  public void mensagem(String menssage){
    try{
      ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
      saida.flush();
      saida.writeObject(new String(menssage));
      saida.close();

    }catch(IOException e){
      e.printStackTrace();
    }
  }
}