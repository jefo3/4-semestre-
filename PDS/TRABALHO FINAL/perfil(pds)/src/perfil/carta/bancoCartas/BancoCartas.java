package perfil.carta.bancoCartas;

import perfil.fabricaCarta.IFabricaCarta;
import perfil.carta.FabricaCarta;
import perfil.carta.dica.Acao;
import perfil.carta.dica.IDica;
import perfil.carta.dica.Informacao;

import java.util.ArrayList;
import java.util.Random;

import perfil.carta.Carta;

public class BancoCartas{

	private ArrayList<Carta> cartas;

	public ArrayList<Carta> getCartas() {
		return this.cartas;
	}

	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public BancoCartas(){
		this.cartas = new ArrayList<Carta>();
	}
	public void addCarta(Carta carta) {
		this.cartas.add(carta);
	}

	public void removeCarta(Carta carta) {
		this.cartas.remove(carta);
	}

	public Carta sortearCarta() {
		Random random = new Random();

		int size = random.nextInt(this.cartas.size());
		System.out.println("size: "+ size);
		int i = 0;
		for (Carta carta : cartas) {
			if(i == size){
				return carta;
			}
			i++;
		}
		return null;
	}
	
	public void preencherCartas(){
		IDica dicasPessoa[] = new IDica[20];
		IDica dicasAno[] = new IDica[20];
		IDica dicasCoisa[] = new IDica[20];
		IDica dicasLugar[] = new IDica[20];
		IFabricaCarta fabrica = new FabricaCarta();
		
		Carta ano = fabrica.criaCarta("ano");
		ano.setTipo("ano");

		ano.setResposta("1945");

		dicasAno[0] = new Informacao("vi ganharem um nobel por causa da penicilina", 0, "informacao");
		dicasAno[1] = new Informacao("vi um bombeiro b-25 chocar-se contra o empire state", 0, "informacao");
		dicasAno[2] = new Informacao("vi o japão render-se ao final da 2 guerra mundial", 0, "informacao");

		dicasAno[3] = new Acao("ande 1 casa", 1, "ação");
		dicasAno[4] = new Informacao("vi a conferencia da lalta", 0, "informacao");
		dicasAno[5] = new Acao("ande 5 casas", 5, "ação");
		dicasAno[6] = new Informacao("vi o bombardeio de hiroshima", 0, "informacao");

		dicasAno[7] = new Informacao("vi roosevelt morrer", 0, "informacao");
		dicasAno[8] = new Informacao("vi george orwell escrever a revolucao do bichos", 0, "informacao");

		dicasAno[9] = new Informacao("vi bebop entrar na moda", 0, "informacao");
		dicasAno[10] = new Informacao("vi a reuniao final da ligas das nacoes", 0, "informacao");
		dicasAno[11] = new Acao("perdeu a vez", 0, "ação");

		dicasAno[12] = new Informacao("vi firmarem a carta das nacoes unidas", 0, "informacao");
		dicasAno[13] = new Informacao("vi o bale de prokofied(cinderela em moscou)", 0, "informacao");
		dicasAno[14] = new Informacao("vi mussoline ser morto", 0, "informacao");
		
		dicasAno[15] = new Acao("ande 2 casas", 2, "ação");
		dicasAno[16] = new Informacao("vi frank lioyd wright criar o museu guggenheim", 0, "informacao");
		dicasAno[17] = new Informacao("vi ho chi minh proclamar a independecia do vietnã do norte", 0, "informacao");
		
		dicasAno[18] = new Informacao("vi hitler se matar", 0, "informacao");
		dicasAno[19] = new Informacao("vi truman torna-se presidente", 0, "informacao");
	
		
		ano.setDicas(dicasAno);

		this.addCarta(ano);


		Carta pessoa = fabrica.criaCarta("pessoa");
		pessoa.setTipo("pessoa");

		pessoa.setResposta("angelina jolie");

		dicasPessoa[0] = new Informacao("antes de me tornar atriz fui modelo", 0, "informacao");
		dicasPessoa[1] = new Acao("ande 2 casas", 2, "ação");
		dicasPessoa[2] = new Informacao("participei de um video do rolling stones", 0, "informacao");

		dicasPessoa[3] = new Informacao("ja fui a sra smith", 0, "informacao");
		dicasPessoa[4] = new Informacao("ja ganhei o oscar de melhor atriz coadjuvante", 0, "informacao");
		dicasPessoa[5] = new Informacao("ja atoei no filme o colecionador de ossos", 0, "informacao");
		dicasPessoa[6] = new Informacao("interpretei uma famosa heroina em um game", 0, "informacao");

		dicasPessoa[7] = new Informacao("sou uma atriz famosa", 0, "informacao");
		dicasPessoa[8] = new Acao("perdeu a vez", 0, "ação");

		dicasPessoa[9] = new Informacao("em uma entrevista revelei q tive relacionamentos homossexuais", 0, "informacao");
		dicasPessoa[10] = new Informacao("sou uma mulher sexy", 0, "informacao");
		dicasPessoa[11] = new Informacao("estou na lista da mulheres mais bonita do mundo", 0, "informacao");

		dicasPessoa[12] = new Informacao("tenho uma filha com o brad pit", 0, "informacao");
		dicasPessoa[13] = new Informacao("apaguei o nome do meu ex de uma tatuagem", 0, "informacao");
		dicasPessoa[14] = new Informacao("em 2006 filmei o bom pastor", 0, "informacao");
		
		dicasPessoa[15] = new Acao("ande 2 casas", 2, "ação");
		dicasPessoa[16] = new Informacao("carregava o sangue do meu amado num colar", 0, "informacao");
		dicasPessoa[17] = new Informacao("atoie como lara croft", 0, "informacao");
		
		dicasPessoa[18] = new Informacao("sou filha do ator jon voight", 0, "informacao");
		dicasPessoa[19] = new Informacao("tenho uma tatuagem com a letra H no pulso", 0, "informacao");
	
		
		pessoa.setDicas(dicasPessoa);

		this.addCarta(pessoa);

		Carta coisa = fabrica.criaCarta("coisa");
		coisa.setTipo("coisa");
		coisa.setResposta("pastel");

		dicasCoisa[0] = new Informacao("posso ser folhado", 0, "informacao");
		dicasCoisa[1] = new Informacao("sou um alimento comum em feira no brasil", 0, "informacao");
		dicasCoisa[2] = new Informacao("posso substituir refeicoes", 0, "informacao");

		dicasCoisa[3] = new Acao("ande 1 casas", 1, "ação");
		dicasCoisa[4] = new Informacao("costumo soltar uma fumacinha logo que sou mordido", 0, "informacao");
		dicasCoisa[5] = new Informacao("tenho varios sabores", 0, "informacao");
		dicasCoisa[6] = new Informacao("posso ser de vento", 0, "informacao");

		dicasCoisa[7] = new Informacao("os portugueses que me deram a forma atual", 0, "informacao");
		dicasCoisa[8] = new Informacao("posso ser assado", 0, "informacao");

		dicasCoisa[9] = new Informacao("posso ser de belem", 0, "informacao");
		dicasCoisa[10] = new Acao("ande 0 casa", 0, "ação");
		dicasCoisa[11] = new Informacao("normalmente sou frito", 0, "informacao");

		dicasCoisa[12] = new Informacao("posso ser encontrado pronto, para ser frito em casa", 0, "informacao");
		dicasCoisa[13] = new Informacao("faco uma boa dupla com caldo de cano", 0, "informacao");
		dicasCoisa[14] = new Informacao("minha massa pode ser fina ou grossa", 0, "informacao");
		
		dicasCoisa[15] = new Informacao("sou crocante e saboroso", 0, "informacao");
		dicasCoisa[16] = new Informacao("tambem possso ser congelado", 0, "informacao");
		dicasCoisa[17] = new Acao("ande 3 casas", 3, "ação");
		
		dicasCoisa[18] = new Informacao("tenho muitas calorias", 0, "informacao");
		dicasCoisa[19] = new Informacao("nao sou recomendado para quem tem colesterol alto", 0, "informacao");
		
		coisa.setDicas(dicasCoisa);
		this.addCarta(coisa);


		Carta lugar = fabrica.criaCarta("lugar");
		lugar.setTipo("lugar");
		lugar.setResposta("biblioteca");

		dicasLugar[0] = new Informacao("a palavra biblia tem muito a ver comigo", 0, "informacao");
		dicasLugar[1] = new Acao("ande 2 casas", 2, "ação");
		dicasLugar[2] = new Informacao("por causa na internet dizem que to perdendo a importancia", 0, "informacao");

		dicasLugar[3] = new Informacao("sou uma fonte inesgotavel de consultas", 0, "informacao");
		dicasLugar[4] = new Informacao("sou frenquentada por muitos estudantes", 0, "informacao");
		dicasLugar[5] = new Informacao("costumo ter um departamento de revista", 0, "informacao");
		dicasLugar[6] = new Informacao("posso ser publico ou privado", 0, "informacao");

		dicasLugar[7] = new Informacao("quem gosta de ler nao vive sem mim", 0, "informacao");
		dicasLugar[8] = new Acao("perdeu a vez", 0, "ação");

		dicasLugar[9] = new Informacao("na alexandria, um establecimento do meu tipo foi destruido em um incedio", 0, "informacao");
		dicasLugar[10] = new Acao("ande 1 casa", 1, "ação");
		dicasLugar[11] = new Informacao("aqui nao se pode falar altos", 0, "informacao");

		dicasLugar[12] = new Informacao("antigamente, o controle de entrada e saida do meus materias era feito com fichas", 0, "informacao");
		dicasLugar[13] = new Informacao("posso acumular muito po em minhas prateleiras", 0, "informacao");
		dicasLugar[14] = new Informacao("quem gosta muito de mim é chamado de rato", 0, "informacao");
		
		dicasLugar[15] = new Informacao("aqui esta o conhecimento do ser humano", 0, "informacao");
		dicasLugar[16] = new Informacao("os professores orientam que me frequentem", 0, "informacao");
		dicasLugar[17] = new Informacao("os livros são meu mundo", 0, "informacao");
		
		dicasLugar[18] = new Informacao("na idade media eu nao era comum", 0, "informacao");
		dicasLugar[19] = new Informacao("estou em todas as universidaes e ha quem me tenha em casa", 0, "informacao");
		
		lugar.setDicas(dicasLugar);
		this.addCarta(lugar);
	}

}
