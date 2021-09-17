package src.tribo.models.animal;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Animal implements NumeroPatas{
	private String nome; 
	
	public Animal(String aNome){ 
		nome = aNome; 
	} 
	
	public String getNome() { 
		return nome; 
	} 
	public void setNome(String nome) { 
		this.nome = nome; 
	} 

	@Override
  public abstract int quantPatas();

	@Override
	public boolean equals(Object obj){ 
		Animal a = (Animal) obj; 
		if(this.nome.equalsIgnoreCase(a.nome)){ 
			return true; 
		} 
		return false; 
	} 
}
