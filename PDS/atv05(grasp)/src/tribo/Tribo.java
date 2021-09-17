package src.tribo;

import java.util.ArrayList;
import java.util.Iterator;

import src.tribo.models.animal.*;
import src.tribo.models.*;

public class Tribo {
	private ArrayList<Animal> animais; 
	private ArrayList<Indio> indios; 
	private Indio cacique; 
	
	public Tribo() { 
		animais = new ArrayList<Animal>();
		indios = new ArrayList<Indio>(); 
	}

	public void adicionaAnimal(Animal animal) { 
		animais.add(animal); 
	}
	
	public int getNumPatas() { 
		int result = 0;
		for (Animal a : animais) { 
			result += a.quantPatas();
		} 
		return result; 
	} 
	public ArrayList<Animal> getAnimais() { 
		return animais; 
	} 
	
	public void setAnimais(ArrayList<Animal> sanimais) { 
		this.animais = animais; 
	}

	public ArrayList<Indio> getIndios() { 
		return indios; 
	}
	
	public void setIndios(ArrayList<Indio> indios) { 
		this.indios = indios; 
	}

	public void setCacique(Indio cacique) { 
		this.cacique = cacique; 
	} 
	public Indio getCacique() { 
		return this.cacique; 
	}

	public void addIndio(Indio indio) { 
		this.indios.add(indio); 
	}

	public void adicionaAnimalNaTribo(Indio caciqueSolicta, Animal animal){

		if(this.getCacique().getNome().equals(caciqueSolicta.getNome())){ 
			
			this.adicionaAnimal(animal);
		} 
	}

	public void removerAnimalNaTribo(Indio caciqueSolicta, Animal animal){

		if(this.getCacique().getNome().equals(caciqueSolicta.getNome())){ 
			
			this.removeAnimal(animal);
		} 
	} 

	public void removeAnimal(Animal animal) { 
		this.animais.remove(animal); 
	} 

	public boolean estouNestaTribo(Animal animal){ 
		
		boolean achou=false; 
		Iterator<Animal> it = this.animais.iterator(); 
		while ((it.hasNext()) && (!achou)){ 
			if (it.next().equals(animal)){ 
				achou = true; 
			} 
		} 
		return achou; 
	} 
}
