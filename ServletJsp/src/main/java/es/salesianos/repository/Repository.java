package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.model.Idiomas;
import es.salesianos.model.Paises;

public class Repository {
	private static final String jdbcUrl = "jdbc:h2:file:C:/Users/deama/Desktop/ExamenDDI/ServletJsp/src/main/resources/test";
	ConnectionH2 manager = new ConnectionH2();

	public Paises search(Paises paisFormulario) {
		Paises paisInDataBase = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM PAISES AS p, IDIOMAS as i WHERE p.idioma=i.idioma AND pais = ?");
			prepareStatement.setString(1, paisFormulario.getPais());
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				paisInDataBase = new Paises();
				paisInDataBase.setPais(resultSet.getString(1));
				paisInDataBase.setIdioma(resultSet.getString(2));
			}
			resultSet.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);
		return paisInDataBase;
	}
	public Idiomas searchIdioma(Idiomas idiomaFormulario) {
		Idiomas idiomaInDataBase = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM IDIOMAS WHERE idioma = ?");
			prepareStatement.setString(1, idiomaFormulario.getIdioma());
			ResultSet resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				idiomaInDataBase = new Idiomas();
				idiomaInDataBase.setIdioma(resultSet.getString(1));
			}
			resultSet.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);
		return idiomaInDataBase;
	}
	public void insert(Paises paisFormulario) {
		Connection conn = manager.open(jdbcUrl);
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO PAISES (pais, idioma) VALUES ('"+paisFormulario.getPais()+"', '"+paisFormulario.getIdioma()+"')");
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);

	}
	public void insertIdioma(Idiomas idiomaFormulario) {
		Connection conn = manager.open(jdbcUrl);
		try {
			PreparedStatement prepareStatement = conn.prepareStatement("INSERT INTO IDIOMAS (idioma) VALUES ('"+idiomaFormulario.getIdioma()+"')");
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);

	}
	
	public void delete(String idioma) {
		Connection conn = manager.open(jdbcUrl);
		try {

			PreparedStatement prepareStatement = conn.prepareStatement("DELETE FROM PAISES AS p, IDIOMAS AS i WHERE p.idioma=i.idioma AND i.idioma=?");
			prepareStatement.setString(1, idioma);
			prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		manager.close(conn);
	}
	public LinkedList<Paises> getPaises(){
		Connection conn = manager.open(jdbcUrl);
		LinkedList<Paises> listaPaises=new LinkedList<Paises>();
		try
		{
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from paises as p, idiomas as i WHERE p.idioma=i.idioma" );
			while (rs.next())
			{
				Paises paises = new Paises();
				paises.setPais(rs.getString(1));
				paises.setIdioma(rs.getString(2));
				listaPaises.add(paises);
			}
			rs.close();
			statement.close();
			conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return listaPaises;
	}
	public LinkedList<Idiomas> getIdiomas(){
		Connection conn = manager.open(jdbcUrl);
		LinkedList<Idiomas> listaIdiomas=new LinkedList<Idiomas>();
		try
		{
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from idiomas" );
			while (rs.next())
			{
				Idiomas idiomas = new Idiomas();
				idiomas.setIdioma(rs.getString(1));
				listaIdiomas.add(idiomas);
			}
			rs.close();
			statement.close();
			conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return listaIdiomas;
	}
}