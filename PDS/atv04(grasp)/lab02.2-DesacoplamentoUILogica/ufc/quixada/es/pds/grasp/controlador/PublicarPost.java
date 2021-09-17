package ufc.quixada.es.pds.grasp.controlador;

import ufc.quixada.es.pds.grasp.model.*;

public class PublicarPost {
  RepositorioPosts repositorioPosts;

  public PublicarPost(){
    repositorioPosts = new RepositorioPosts();
  }

  public void postar(String titulo, String conteudo){
    Post post = new Post();
		post.setTitulo(titulo);
		post.setCorpoTexto(conteudo);
		repositorioPosts.adicionar(post); 
  }
}
