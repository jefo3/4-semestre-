package perfil;

import perfil.carta.Carta;
import perfil.carta.bancoCartas.ControladorBancoCartas;
import perfil.carta.dica.IDica;
import perfil.player.ControladordeJogador;
import perfil.player.Player;
import perfil.tabuleiro.Tabuleiro;
import perfil.view.Tela;

import java.util.ArrayList;

public class Jogo {

	private int qntCasaMediador;
	private int qntCasaPlayer;
	private Carta cartadaVez;
	private Tabuleiro tabuleiro;
	private Player playerdaVez;
	private ControladordeJogador controladorPlayers;
	private ControladorBancoCartas controladorBanco;

	public Jogo(){
		this.controladorPlayers = new ControladordeJogador();
		this.controladorBanco = new ControladorBancoCartas();
		
		this.qntCasaMediador = 0;
		this.qntCasaPlayer = 0;
	}

	public Tabuleiro getTabuleiro(){
		return this.tabuleiro;
	}

	public Carta getCartaDaVez(){
		return this.cartadaVez;
	}

	public void somaQntCasaMediador(){
		this.qntCasaMediador++;
	}

	public void somaQntCasaPlayer(){
		this.qntCasaPlayer = (20 - this.qntCasaMediador) + this.qntCasaPlayer;
	}

	public int getQntCasaMediador(){
		return this.qntCasaMediador;
	}

	public int getQntCasaPlayer(){
		return this.qntCasaPlayer;
	}

	public Player getPlayerDaVez(){
		return this.playerdaVez;
	}
	
	public String[] pegaDica(int dica) {
		IDica d = cartadaVez.pegarDica(dica);

		if(d.getTipo().equals("ação")){
			int tam = controladorPlayers.getPlayers().length;
			for(int i = 0; i < tam; i++){
			
				if(controladorPlayers.getPlayers()[i].getId() == this.playerdaVez.getId()){
					controladorPlayers.getPlayers()[i].qntsCasasAndadas(d.getCasasAndadas());
				}
			}
			
			this.somaQntCasaMediador();
		}

		String resposta[] = {d.getTexto(), d.getTipo()};
		
		return resposta;
	}

	public boolean palpite(String palpite) {
		return cartadaVez.verificaEstaCorreto(palpite);
	}

	public void sortearCarta() {
		this.cartadaVez = controladorBanco.sortearCarta();
	}

	public void playerdaVez() {
		this.playerdaVez = controladorPlayers.playerdaVez();
	}
	public void sorteaPrimeiro(){
		this.controladorPlayers.primeiroDaRodada();
	}

	public void iniciaJogo(int qntsPlayers, String[] nomes) {
		controladorPlayers.criaJogadores(qntsPlayers, nomes);

		//testar se deu certo
		int i;
		for(i = 0; i < qntsPlayers; i++){
			System.out.println(controladorPlayers.getPlayers()[i].toString());
		}
		System.out.println(controladorPlayers.getMediador().toString());
	}

	public void novoTabuleiro(Tela tela) {
		tabuleiro = new Tabuleiro(50, 0, 50);
		tabuleiro.addObservadores(tela);
	}

	public void distribuiPontos(int qntsPlayers) {
		int i;

		for(i = 0; i < qntsPlayers; i++){
			
			if(controladorPlayers.getPlayers()[i].getId() == this.playerdaVez.getId()){
				controladorPlayers.getPlayers()[i].qntsCasasAndadas(this.qntCasaPlayer);
			}
		}

		controladorPlayers.getMediador().qntsCasasAndadas(this.qntCasaMediador);
	
		this.qntCasaMediador = 0;
		this.qntCasaPlayer = 0;
		
	}

	public String[] casasOcupadas(){
		return this.tabuleiro.casasOCulpada(controladorPlayers.getPlayers(), controladorPlayers.getMediador());
	}

	
}
