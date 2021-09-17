package perfil.carta;

import perfil.carta.dica.IDica;

public class Carta{

	private IDica[] dicas;
	private String tipo;
	private String resposta;

	public Carta() {
	}

	public IDica[] getDicas() {
		return this.dicas;
	}

	public void setDicas(IDica[] dicas) {
		this.dicas = dicas;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getResposta() {
		return this.resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public IDica pegarDica(int numero) {
		return this.dicas[numero];
	}

	public boolean verificaEstaCorreto(String palpite) {
		boolean certo;
		if(palpite.equals(this.resposta)){
			certo = true;
		}else{
			certo = false;
		}
		return certo;
	}

}
