package models;

import interfaces.IArma;

public class Navio{
    IArma arma;
    
    public Navio(IArma armaPadrao){
        this.arma = armaPadrao;
    }
    
    public void setArma(IArma arma){
        this.arma = arma;
    }
    
    public void atirar(){
        this.arma.atirar();
    }
}