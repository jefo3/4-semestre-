import java.io.*;
import java.net.*;

public class TCPServer{
	public static void main(String[] args) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		//Criar socket de aceitação da porta 6787
		ServerSocket welcomeSocket = new ServerSocket(6787);
		while(true){
			//Espera do socket de aceitação por contato do Cliente
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("cliente conectado");
			//Criar stream de entrada ligado ao socket
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			//Criar stream de saída ligado ao socket
			DataOutputStream outToCLient = new DataOutputStream(connectionSocket.getOutputStream());
			//Lê linha do Socket
			clientSentence = inFromClient.readLine();
			capitalizedSentence = "resultado: " + clientSentence.toUpperCase() + '\n';
			//Escrever linha do Socket
			outToCLient.writeBytes(capitalizedSentence);
		}//Fim do Loop, retorna e espera outra conexão do cliente		
	}
}