package perfil.carta.bancoCartas;

import perfil.carta.Carta;

public class ControladorBancoCartas {

	BancoCartas banco;

	public ControladorBancoCartas(){
		this.banco = new BancoCartas();
		this.banco.preencherCartas();
	}

	public Carta sortearCarta() {
		return this.banco.sortearCarta();
	}

	public void removeCarta(Carta carta) {
		banco.removeCarta(carta);
	}

}
