import java.io.*;
import java.net.*;

public class TCPClient{
	public static void main(String[] args) throws Exception {
		String sentence;
		String modifiedSentence;
		//Criar stream de entrada
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		//Criar socket cliente, conectar ao servidor
		Socket clientSocket = new Socket("192.168.1.7",6787);
		//Criar stream de saída, ligado ao socket
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		//Criar stream de entrada, ligado ao socket
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		sentence = inFromUser.readLine();
		//Enviar linha para o servidor
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		//Lê linha do servidor
		System.out.println("From Server: " + modifiedSentence);
		clientSocket.close();
	}

}
