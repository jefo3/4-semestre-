package perfil.tabuleiro;

import perfil.player.Player;
import perfil.observers.ObservavelTabuleiro;
import perfil.observers.ObservadorTabuleiro;

import java.util.ArrayList;

public class Tabuleiro implements ObservavelTabuleiro{

	private int qntCasas;
	private int inicio;
	private int fim;

	private ArrayList<ObservadorTabuleiro> observadores;

	public Tabuleiro(int qntCasas, int inicio, int fim) {
		this.qntCasas = qntCasas;
		this.inicio = inicio;
		this.fim = fim;

		observadores = new ArrayList<ObservadorTabuleiro>();
	}

	public Tabuleiro() {
	}

	public int getQntCasas() {
		return this.qntCasas;
	}

	public void setQntCasas(int qntCasas) {
		this.qntCasas = qntCasas;
	}

	public int getInicio() {
		return this.inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFim() {
		return this.fim;
	}

	public void setFim(int fim) {
		this.fim = fim;
	}

	public String[] casasOCulpada(Player players[], Player mediador) {
		int tam = players.length;
		String[] infos = new String[tam+1];

		int i;
		for(i = 0; i < tam; i++){
			infos[i] = "o player " + players[i].getNome() + " ta na casa: "+ players[i].getQntCasasAndadas();
			
			//vericar se alguem chegou em fim
			if(players[i].getQntCasasAndadas() >= this.fim){
				this.Chegoufim(players[i]);
			}
			
		}

		infos[i] = "o " + mediador.getNome() + " ta na casa: " + mediador.getQntCasasAndadas();

		if(mediador.getQntCasasAndadas() >= this.fim){
			this.Chegoufim(mediador);
		}

		return infos;
	}

	public void Chegoufim(Player campeao){
		this.notifique(campeao);
	}
	
	@Override
	public void addObservadores(ObservadorTabuleiro observador) {
		this.observadores.add(observador);
	}

	@Override
	public void notifique(Player campeao){
		for (ObservadorTabuleiro obs : observadores) {
			obs.fim(this, campeao);
		}
	}

}
