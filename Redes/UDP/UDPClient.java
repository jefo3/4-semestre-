import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception{
        //Cria stream de entrada
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        //Cria socket cliente
        DatagramSocket clienteSocket = new DatagramSocket();
        //Traduz nome do host para o endereço IP registrado no DNS
        InetAddress IPAddress = InetAddress.getByName("192.168.1.7");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        //Cria datagramas com: dados a enviar, tamanho, endereço IP e porta
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clienteSocket.send(sendPacket);
        //Envia datagrama para o servidor
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        //Lê datagrama do servidor
        clienteSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER: " + modifiedSentence);
        clienteSocket.close();
    }    
}
