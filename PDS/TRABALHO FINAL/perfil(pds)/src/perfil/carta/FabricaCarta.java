package perfil.carta;

import perfil.fabricaCarta.IFabricaCarta;

public class FabricaCarta implements IFabricaCarta{

	public Carta criaCarta(String tipo) {
		
		Carta carta;

		switch(tipo){
      case "ano":
				carta = new Ano();
        break;
      case "coisa":
				carta = new Coisa();
        break;
      case "lugar":
				carta = new Lugar();
        break;
			case "pessoa":
				carta = new Pessoa();
        break;
      default:
				carta = new Coisa();
        break;
    }

		return carta;
	}

}
