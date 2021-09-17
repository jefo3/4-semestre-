package controllers;

import models.Navio;
import models.armas.Canhao;
import models.armas.Metralhadora;
import models.monicao.BaladeFerro;
import models.monicao.PatosdeBurracha;

public class TesteNavio {
  public static void main(String[] args){
    Navio navio = new Navio(new Canhao(new BaladeFerro(40)));
    navio.atirar();

    navio.setArma(new Metralhadora(new PatosdeBurracha(2)));
    navio.atirar();

    navio.setArma(new Metralhadora(new BaladeFerro(12)));
    navio.atirar();

    navio.setArma(new Canhao(new PatosdeBurracha(1)));
    navio.atirar();
  }
}
