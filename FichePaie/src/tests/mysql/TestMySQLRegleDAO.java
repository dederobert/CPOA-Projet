package tests.mysql;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.dao.mysql.MySQLRegleDAO;
import appli.modele.metier.Regle;

public class TestMySQLRegleDAO {

	@Test
	public void testSingleton() {
		assertNotNull(MySQLRegleDAO.getInstance());
	}
	
	@Test
	public void testCreerRegleIdNotNull(){
		Regle regle = new Regle("brut = 1200", "secu = 0.5", true);
		int id = MySQLRegleDAO.getInstance().create(regle);
		assertNotNull(id);
	}
	
	@Test
	public void testCreerRegle(){
		Regle regle = new Regle("brut = 1200", "secu = 500", true);
		int id = MySQLRegleDAO.getInstance().create(regle);
		Regle regle2 = MySQLRegleDAO.getInstance().getById(id);
		
		assertEquals("brut = 1200", regle2.getCondition());
		assertEquals("secu = 500", regle2.getAction());
		assertTrue(regle2.isActif());
	}
	
	@Test
	public void testGetByIdRegleNotNull() {
		Regle regle = new Regle("brut = 1200", "secu = 500", true);
		int id = MySQLRegleDAO.getInstance().create(regle);
		assertNotNull(MySQLRegleDAO.getInstance().getById(id));
	}
	
	@Test
	public void testByIdRegleEquals() {
		Regle regle = new Regle("brut = 1200", "secu = 500", true);
		int id = MySQLRegleDAO.getInstance().create(regle);
		Regle regle2 = MySQLRegleDAO.getInstance().getById(id);
		assertEquals("brut = 1200", regle2.getCondition());
		assertEquals("secu = 500", regle2.getAction());
		assertTrue(regle2.isActif());
	}
	
	@Test
	public void testUpdateCondition() {
		Regle regle = new Regle("brut = 1200", "secu = 500", true);
		int id = MySQLRegleDAO.getInstance().create(regle);
		regle.setCondition("brut = 500");
		MySQLRegleDAO.getInstance().update(regle);
		Regle regle2 = MySQLRegleDAO.getInstance().getById(id);
		assertEquals("brut = 500", regle2.getCondition());
	}
	
	@Test
	public void testUpdateAction() {
		Regle regle = new Regle("brut = 1200", "secu = 500", true);
		int id = MySQLRegleDAO.getInstance().create(regle);
		regle.setAction("secu = 0.8");
		MySQLRegleDAO.getInstance().update(regle);
		Regle regle2 = MySQLRegleDAO.getInstance().getById(id);
		assertEquals("secu = 0.8", regle2.getAction());
	}

	@Test
	public void testUpdateActif() {
		Regle regle = new Regle("brut = 1200", "secu = 500", true);
		int id = MySQLRegleDAO.getInstance().create(regle);
		regle.setActif(false);
		MySQLRegleDAO.getInstance().update(regle);
		Regle regle2 = MySQLRegleDAO.getInstance().getById(id);
		assertFalse(regle2.isActif());
		
	}
	
	@Test
	public void testDelete() {
		Regle regle = new Regle("brut = 1200", "secu = 500", true);
		int id = MySQLRegleDAO.getInstance().create(regle);
		MySQLRegleDAO.getInstance().delete(regle);
		Regle regle2 = MySQLRegleDAO.getInstance().getById(id);
		assertNull(regle2);
	}
}
