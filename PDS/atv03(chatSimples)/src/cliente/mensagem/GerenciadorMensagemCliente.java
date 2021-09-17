package cliente.mensagem;


import java.io.ObjectInputStream;
import java.net.Socket;

public class GerenciadorMensagemCliente {
  Socket cliente;
  public GerenciadorMensagemCliente(Socket cliente){
    this.cliente = cliente;
  }

  public boolean receberMensagem(){
    try {
      
      ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
      String mensagem = (String)entrada.readObject();
      System.out.println("mensagem recebida do servidor:" + mensagem);
      if(mensagem.equals("fechar")){
        entrada.close();
        System.out.println("Conexão encerrada");
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return false;
  }
}
