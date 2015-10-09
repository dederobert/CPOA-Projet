package tests.mysql;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.dao.mysql.MySQLCotisationDAO;
import appli.modele.metier.Cotisation;

public class TestMySQLCotisationDAO {
	private static final double DELTA = 1e-5;

	@Test
	public void testSingleton() {
		assertNotNull(MySQLCotisationDAO.getInstance());
	}
	
	@Test
	public void testCreerCotisationIdNotNull(){
		Cotisation cotisation = new Cotisation("secu", 0.8);
		int id = MySQLCotisationDAO.getInstance().create(cotisation);
		assertNotNull(id);
	}
	
	@Test
	public void testCreerCotisation(){
		Cotisation cotisation = new Cotisation("secu", 0.8);
		int id = MySQLCotisationDAO.getInstance().create(cotisation);
		Cotisation cotisation2 = MySQLCotisationDAO.getInstance().getById(id);
		
		assertEquals("secu", cotisation2.getLibelle());
		assertEquals(0.8, cotisation2.getTaux(), DELTA);
	}
	
	@Test
	public void testGetByIdCotisationNotNull()
	{
		Cotisation cotisation = new Cotisation("secu", 0.8);
		int id = MySQLCotisationDAO.getInstance().create(cotisation);
		assertNotNull(MySQLCotisationDAO.getInstance().getById(id));
	}
	
	@Test
	public void testGetByIdCotisationIsEquals(){
		Cotisation cotisation = new Cotisation("secu", 0.8);
		int id = MySQLCotisationDAO.getInstance().create(cotisation);
		Cotisation cotisation2 = MySQLCotisationDAO.getInstance().getById(id);
		assertEquals("secu", cotisation2.getLibelle());
		assertEquals(0.8,cotisation2.getTaux(), DELTA );
	}
	

}
