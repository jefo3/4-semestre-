package perfil.carta.dica;

public class Acao implements IDica{
	private String texto;
	private int casasAndadas;
	private String tipo;

	public Acao(String texto, int casasAndadas, String tipo) {
		this.texto = texto;
		this.casasAndadas = casasAndadas;
		this.tipo = tipo;
	}
	public Acao(){
	}
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCasasAndadas() {
		return this.casasAndadas;
	}

	public void setCasasAndadas(int casasAndadas) {
		this.casasAndadas = casasAndadas;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTexto(){
		return this.texto;
	}
}
