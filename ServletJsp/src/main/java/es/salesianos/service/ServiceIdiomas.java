package es.salesianos.service;



import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Idiomas;
import es.salesianos.model.assembler.IdiomasAssembler;
import es.salesianos.repository.Repository;

public class ServiceIdiomas {
	
	private Repository repository = new Repository();
	
	
	public Idiomas assembleIdiomasFromRequest(HttpServletRequest req) {
		return IdiomasAssembler.assembleIdiomasFrom(req);
	}
	
	public Idiomas Search(Idiomas idiomas) {
		return repository.searchIdioma(idiomas);
	}

	public void insert(Idiomas idiomaFormulario) {
		
		Repository repository = new Repository();
		Idiomas idiomaInDatabase = repository.searchIdioma(idiomaFormulario);
		
		if(null == idiomaInDatabase){
			repository.insertIdioma(idiomaFormulario);
		}
	}
	
	public void delete(Idiomas idiomaFormulario) {
		Idiomas IdiomaInDatabase = repository.searchIdioma(idiomaFormulario);
		if(null == IdiomaInDatabase){
			insert(idiomaFormulario);
		}else{
			repository.delete(idiomaFormulario.getIdioma());
		}
	}
	
	

}