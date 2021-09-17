package src.tribo.controllers;

import src.tribo.*;
import src.tribo.models.Indio;
import src.tribo.models.animal.*;

public class Troca {

	public static void troca(Tribo tribo1, Animal 
													animal1, Tribo tribo2, Animal animal2){ 

		Indio cacique1, cacique2;
		
		cacique1 = tribo1.getCacique();
		cacique2 = tribo2.getCacique();
		
		if(tribo1.estouNestaTribo(animal1)){
			tribo1.removerAnimalNaTribo(cacique1, animal1); 
		}
		tribo1.adicionaAnimalNaTribo(cacique1, animal2); 
		
		if(tribo2.estouNestaTribo(animal2)){
			tribo2.removerAnimalNaTribo(cacique2, animal2); 
		}
		tribo2.adicionaAnimalNaTribo(cacique2, animal1); 
	} 
}
