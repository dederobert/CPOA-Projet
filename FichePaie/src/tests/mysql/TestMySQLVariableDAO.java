package tests.mysql;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.dao.mysql.MySQLVariableDAO;
import appli.modele.metier.Variable;

public class TestMySQLVariableDAO {

	@Test
	public void testSingleton() {
		assertNotNull(MySQLVariableDAO.getInstance());
	}
	
	@Test
	public void testCreerVariable(){
		Variable variable = new Variable("Brut");
		int id = MySQLVariableDAO.getInstance().create(variable);
		Variable variable2 = MySQLVariableDAO.getInstance().getById(id);		
		assertEquals("Brut", variable2.getLibelle());				
	}

	@Test
	public void testCreerVariableNotNull(){
		Variable variable = new Variable("Brut");
		int id = MySQLVariableDAO.getInstance().create(variable);
		assertNotNull(id);
	}
	
	@Test
	public void testGetByIdVariableNotNull(){
		Variable variable = new Variable("Brut");
		int id = MySQLVariableDAO.getInstance().create(variable);
		
		assertNotNull(MySQLVariableDAO.getInstance().getById(id));
	}
	
	@Test
	public void testGetByIdVariable(){
		Variable variable = new Variable("Brut");
		int id = MySQLVariableDAO.getInstance().create(variable);
		
		assertEquals(new Variable("Brut"),MySQLVariableDAO.getInstance().getById(id));
	}
	
	@Test
	public void testGetByLibelleNotNull(){
		assertNotNull(MySQLVariableDAO.getInstance().getByLibelle("Brut"));
	}
	
	@Test
	public void testGetByLibelleIsSame(){
		assertEquals(new Variable("Statu"), MySQLVariableDAO.getInstance().getByLibelle("Statu"));
	}
	
	@Test
	public void testUpdateVariable(){
		Variable variable = new Variable("Brut");
		int id = MySQLVariableDAO.getInstance().create(variable);
		
		variable.setLibelle("testUpdate");
		MySQLVariableDAO.getInstance().update(variable);
		
		Variable variable2 = MySQLVariableDAO.getInstance().getById(id);
		String libelle = variable2.getLibelle();
		assertEquals(libelle, MySQLVariableDAO.getInstance().getById(id).getLibelle());
	}
	
	@Test
	public void testDelete(){
		Variable variable = new Variable("Brut");
		int id = MySQLVariableDAO.getInstance().create(variable);
		MySQLVariableDAO.getInstance().delete(variable);
		assertNull(MySQLVariableDAO.getInstance().getById(id));
	}
}
