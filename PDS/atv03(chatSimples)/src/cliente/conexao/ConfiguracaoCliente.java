package cliente.conexao;

public class ConfiguracaoCliente {
  String host;
	int porta;
	
	public ConfiguracaoCliente(String host, int porta){
		this.host = host;
		this.porta = porta;
	}
	
	public String getHost() {
		return host;
	}

	public int getPorta() {
		return porta;
	}
}
