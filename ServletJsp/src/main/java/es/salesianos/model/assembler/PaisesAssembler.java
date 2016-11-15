package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import org.h2.util.StringUtils;

import es.salesianos.model.Paises;

public class PaisesAssembler {

	public static Paises assemblePaisesFrom(HttpServletRequest req) {
		Paises paises = new Paises();
		String pais = req.getParameter("pais");
		String Idioma = req.getParameter("idioma");
		
		if (!StringUtils.isNullOrEmpty(pais))
			paises.setPais(pais);
		if (!StringUtils.isNullOrEmpty(Idioma))
			paises.setIdioma(Idioma);
		
		return paises;
	}
}