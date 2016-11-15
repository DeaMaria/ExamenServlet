package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Idiomas;
import es.salesianos.service.ServiceIdiomas;

public class DeleteFromDatabase extends HttpServlet{
private ServiceIdiomas service = new ServiceIdiomas();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processServlet(req, resp);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processServlet(req, resp);
	}


	private void processServlet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Idiomas idiomas = service.assembleIdiomasFromRequest(req);
		idiomas = service.Search(idiomas);
		service.delete(idiomas);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/fin.jsp");
		dispatcher.forward(req,resp);
	}

	public ServiceIdiomas getService() {
		return service;
	}

	public void setService(ServiceIdiomas service) {
		this.service = service;
	}
}