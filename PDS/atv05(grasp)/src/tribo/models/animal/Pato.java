package src.tribo.models.animal;

public class Pato extends Animal{
  
  public Pato(String nome){
    super(nome);
  }

  @Override
  public int quantPatas(){
    return 2;
  }
}
