package src.tribo.models.animal;

public class Cachorro extends Animal{
  public Cachorro(String nome){
    super(nome);
  }

  @Override
  public int quantPatas(){
    return 4;
  }
}
