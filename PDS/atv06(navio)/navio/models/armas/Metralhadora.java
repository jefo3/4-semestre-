package models.armas;

import interfaces.IArma;
import interfaces.Municao;

public class Metralhadora implements IArma{
    
    Municao monicao;
    public Metralhadora(Municao monicaoPadrao){
        this.monicao = monicaoPadrao;
    }
    
    public void atirar(){
        System.out.println("Atirando com Metralhadora, MUNIÇÃO: "+ 
                            monicao.nomeMunicao() +", PESO: " 
                            + monicao.getPeso() );
    }
}