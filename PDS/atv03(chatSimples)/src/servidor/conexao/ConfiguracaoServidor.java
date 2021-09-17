package servidor.conexao;

public class ConfiguracaoServidor {
	int porta;
	
	public ConfiguracaoServidor(int porta){
		this.porta = porta;
	}
	
	public int getPorta(){
		return this.porta;
	}
}
