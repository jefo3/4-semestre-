package perfil.player;
public class Player {

	private String nome;
	private int id;
	private int qntCasasAndadas;

	public Player(String nome, int id, int qntCasasAndadas) {
		this.nome = nome;
		this.id = id;
		this.qntCasasAndadas = qntCasasAndadas;
	}

	public Player() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQntCasasAndadas() {
		return this.qntCasasAndadas;
	}

	public void setQntCasasAndadas(int qntCasasAndadas) {
		this.qntCasasAndadas = qntCasasAndadas;
	}
	
	public void qntsCasasAndadas(int qntCasasAndadas){
		this.qntCasasAndadas += qntCasasAndadas;
	}
	
	@Override
	public String toString() {
		return "{" +
			" nome='" + getNome() + "'" +
			", id='" + getId() + "'" +
			", qntCasasAndadas='" + getQntCasasAndadas() + "'" +
			"}";
	}

}
