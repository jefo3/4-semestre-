import java.io.*;
import java.net.*;

//import sun.security.x509.IPAddressName;

public class UDPServer {
    public static void main(String[] args) throws Exception{
        //Cria Socket Datagrama na porta 9876
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true){
            //Cria espaço para o datagrama recebidos
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            //Recebe Datagrama
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            //Obtem endereço IP e numero da porta do transmissor
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = "resultado: " + sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            //Cria datagrama para enviar ao cliente
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            //Escreve datagrama para dentro do socket
            serverSocket.send(sendPacket);
        }   //Termina o loop, retorna e espera por outro datagrama      
    }   
}