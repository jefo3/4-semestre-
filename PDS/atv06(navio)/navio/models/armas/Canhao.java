package models.armas;

import interfaces.IArma;
import interfaces.Municao;

public class Canhao implements IArma{
    Municao monicao;
    public Canhao(Municao monicaoPadrao){
        this.monicao = monicaoPadrao;
    }
    
    public void atirar(){
        System.out.println("Atirando com Canhao, MUNIÇÃO: "+ 
                            monicao.nomeMunicao() +", PESO: " 
                            + monicao.getPeso() );
    }
    
    

}