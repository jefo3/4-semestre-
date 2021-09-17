package perfil.player;

import java.util.Random;

public class ControladordeJogador {

	private Player[] players;
	private Player mediador;
	private int controleNumeroVez;

	public ControladordeJogador() {
	}
	
	public Player getMediador() {
		return this.mediador;
	}

	public void setMediador(Player mediador) {
		this.mediador = mediador;
	}


	public Player[] getPlayers() {
		return this.players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}


	public Player playerdaVez() {
		Player player = this.players[controleNumeroVez];	
		
		if(this.controleNumeroVez < this.players.length -1){
			this.controleNumeroVez++;
		}else{
			this.controleNumeroVez = 0;
		}
		return player;
	}
	
	public void primeiroDaRodada(){
		Random random = new Random();

		this.controleNumeroVez = random.nextInt(this.players.length);
	}

	public void criaJogadores(int qntsPlayers, String[] nomes) {
		int i;
		this.players = new Player[qntsPlayers];
		for(i = 0; i < qntsPlayers; i++){
			this.players[i] = new Player(nomes[i], i, 0);
		}
		this.mediador = new Player("mediador", i, 0);
		
	}

}
