package tests.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.dao.arrayList.ArrayListEmployeDAO;
import appli.modele.metier.Employe;

public class TestArrayListEmployeDAO {

	@Test
	public void testSingleton() {
		assertNotNull(ArrayListEmployeDAO.getInstance());
	}
	
	@Test
	public void testListEmployeIsNotNull(){
		assertNotNull(ArrayListEmployeDAO.getInstance().getEmployes());
	}
	
	@Test
	public void testGetByIdEmployeNotNull() {
		assertNotNull(ArrayListEmployeDAO.getInstance().getById(1));
	
	}
	@Test
	public void testGetByIdEmploye() {
		assertEquals(new Employe(1, "LAJOUX", "Alexis", "metz"), ArrayListEmployeDAO.getInstance().getById(1));
	
	}
	
	@Test
	public void testGetByNomEmploye(){
		assertEquals(new Employe(1, "LAJOUX", "Alexis", "metz"), ArrayListEmployeDAO.getInstance().getByNom("LAJOUX"));
	}
	
	@Test
	public void testGetByNomEmployeIsNotNull(){
		assertNotNull(ArrayListEmployeDAO.getInstance().getByNom("LAJOUX"));
	}
	
	
	@Test
	public void testCreerEmploye(){
		Employe employe = new Employe(5, "BOURGANIESH", "Robert", "toulouse");
		ArrayListEmployeDAO.getInstance().create(employe);
		assertTrue(ArrayListEmployeDAO.getInstance().getEmployes().contains(employe));
	}
	
	@Test
	public void testUpdateNomEmploye(){
		Employe employe = ArrayListEmployeDAO.getInstance().getById(1);
		employe.setNom("BOURGANIESH");
		ArrayListEmployeDAO.getInstance().update(employe);	
		assertEquals(employe.getNom(), ArrayListEmployeDAO.getInstance().getById(1).getNom());
		
	}
	
	@Test
	public void testDeleteEmploye(){
		Employe employe = new Employe(5, "BOURGANIESH", "Robert", "toulouse");
		ArrayListEmployeDAO.getInstance().delete(employe);
		
		assertFalse(ArrayListEmployeDAO.getInstance().getEmployes().contains(employe));
		
	}
	
}