package perfil.observers;

import perfil.player.Player;

public interface ObservavelTabuleiro {

	public void addObservadores(ObservadorTabuleiro observador);

	public void notifique(Player campeão);

}
