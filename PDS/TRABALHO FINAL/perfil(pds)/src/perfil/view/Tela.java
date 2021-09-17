package perfil.view;

import java.util.Scanner;

import perfil.Jogo;
import perfil.observers.ObservavelTabuleiro;
import perfil.tabuleiro.Tabuleiro;
import perfil.observers.ObservadorTabuleiro;
import perfil.player.Player;

public class Tela implements ObservadorTabuleiro{

	private Jogo jogo;
	boolean fimGame;
	boolean fimTurno;
	Player champion;
	
	public Tela() {
		jogo = new Jogo();
	}

	public void iniciar() {
		Scanner in = new Scanner(System.in);

		System.out.println("BEM VINDO AO JOGO PERFIL, ENTER PARA COMEÇAR...");
		in.nextLine();

		System.out.println("quantos pessoas vão jogar(podem no maximo 3)?");
		int qntPlayers = Integer.parseInt(in.nextLine());
		
		while(qntPlayers < 0 || qntPlayers > 3){
			System.out.println("digite uma quantidade valida");
			qntPlayers = Integer.parseInt(in.nextLine());
		}
		

		String [] nomes = new String[qntPlayers];
		for(int i = 0; i < qntPlayers; i++){
			System.out.println("digite o nome do "+ (i+1)+"°"+ " jogador");
			nomes[i] = in.nextLine();
		}
		
		jogo.iniciaJogo(qntPlayers, nomes);
		jogo.novoTabuleiro(this);

		fimGame = false;
		fimTurno = false;

		//loop do jogo
		while(!fimGame){
			jogo.sorteaPrimeiro();
			jogo.sortearCarta();

			System.out.println("A carta da vez é do tipo: " + jogo.getCartaDaVez().getTipo());
			//loop do turno
			fimTurno = false;
			int numeroDicas = 0;
			while(!fimTurno){
				jogo.playerdaVez();
				
				System.out.println(jogo.getPlayerDaVez().getNome() + " qual numero de dica que deseja?");
				int dica = Integer.parseInt(in.nextLine());

				String[] resposta = jogo.pegaDica(dica-1);

				System.out.println(resposta[0]);
				
				if(resposta[1] == "informacao" && numeroDicas < 20){
					System.out.println("Digite seu palpite: ");
					String palpite = in.nextLine();
					
					boolean acertou = jogo.palpite(palpite);

					if(!acertou){
						jogo.somaQntCasaMediador();
						System.out.println("---" + jogo.getQntCasaMediador());
					}else if(acertou){
						jogo.somaQntCasaPlayer();
						fimTurno = true;
						numeroDicas = 0;
						System.out.println("ACERTOU!!!");
			
					}
					
				}else if(numeroDicas >= 20){
					System.out.println("A resposta era: " + jogo.getCartaDaVez().getResposta());
					in.nextLine();
					fimTurno = true;
					numeroDicas = 0;
				}

				numeroDicas++;
			}
			jogo.distribuiPontos(qntPlayers);

			desenharTabuleiro();
			
		}

		if(fimGame){
			System.out.println("O CAMPEÃO FOI: " + champion.getNome());
			System.out.println("PARABENS");
		}
	}

	public void desenharTabuleiro() {
		String[] res = jogo.casasOcupadas();
		int tam = res.length;

		for(int i = 0; i < tam; i++){
			System.out.println(res[i]);
		}
	}

	public void fimDoJogo(Player campeao){
		this.fimGame = true;
		this.champion = campeao;

	}

	@Override
	public void fim(ObservavelTabuleiro tabuleiro, Player campeao) {
		this.fimDoJogo(campeao);	
	}
}
