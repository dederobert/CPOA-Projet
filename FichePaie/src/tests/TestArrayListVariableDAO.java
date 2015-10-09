package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import appli.dao.arrayList.ArrayListVariableDAO;
import appli.modele.metier.Variable;

public class TestArrayListVariableDAO {

	@Test
	public void testSingleton() {
		assertNotNull(ArrayListVariableDAO.getInstance());
	}
	
	@Test
	public void testListVariableIsNotNull(){
		assertNotNull(ArrayListVariableDAO.getInstance().getVariables());
	}
	
	@Test
	public void testGetByIdVariableNotNull(){
		assertNotNull(ArrayListVariableDAO.getInstance().getById(1));
	}
	
	@Test
	public void testGetByIdVariable(){
		assertEquals(new Variable("Statu"), ArrayListVariableDAO.getInstance().getById(1));
	}
	
	@Test
	public void testGetByLibelleNotNull(){
		assertNotNull(ArrayListVariableDAO.getInstance().getByLibelle("Brute"));
	}
	
	@Test
	public void testGetByLibelleIsSame(){
		assertEquals(new Variable("Statu"), ArrayListVariableDAO.getInstance().getByLibelle("Statu"));
	}
	
	
	@Test
	public void testCreerVariable(){
		Variable variable = new Variable("Brute");
		ArrayListVariableDAO.getInstance().create(variable);
		assertTrue(ArrayListVariableDAO.getInstance().getVariables().contains(variable));
	}
	
	@Test
	public void testUpdateVariable(){
		Variable variable = ArrayListVariableDAO.getInstance().getById(1);
		variable.setLibelle("testUpdate");
		ArrayListVariableDAO.getInstance().update(variable);
		assertEquals(variable.getLibelle(), ArrayListVariableDAO.getInstance().getById(1).getLibelle());		
	}
	
	@Test
	public void testDelete(){
		Variable variable = new Variable("Test");
		ArrayListVariableDAO.getInstance().delete(variable);
		assertFalse(ArrayListVariableDAO.getInstance().getVariables().contains(variable));
	}
}
