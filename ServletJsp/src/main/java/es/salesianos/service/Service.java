package es.salesianos.service;



import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Paises;
import es.salesianos.model.assembler.PaisesAssembler;
import es.salesianos.repository.Repository;

public class Service {
	
	private Repository repository = new Repository();
	
	
	public Paises assemblePaisesFromRequest(HttpServletRequest req) {
		return PaisesAssembler.assemblePaisesFrom(req);
	}
	
	public Paises SearchPais(Paises pais) {
		return repository.search(pais);
	}

	public void insert(Paises paisFormulario) {
		
		Repository repository = new Repository();
		/*Paises paisInDatabase = repository.search(paisFormulario);
		
		if(null == paisInDatabase){*/
			repository.insert(paisFormulario);
		/*}else{
			repository.update(paisFormulario);
		}*/
		
	}
	
	public void delete(Paises paisFormulario) {
		Paises paisInDatabase = repository.search(paisFormulario);
		if(null == paisInDatabase){
			insert(paisFormulario);
		}else{
			repository.delete(paisFormulario.getPais());
		}
	}
	
	

}
