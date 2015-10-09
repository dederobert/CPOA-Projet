package tests.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import appli.dao.arrayList.ArrayListRegleDAO;
import appli.modele.metier.Regle;

public class TestArrayListRegleDAO {
	
	//TODO refaire class tester et ajouter maquant
	
	@Test
	public void testSingleton() {
		assertNotNull(ArrayListRegleDAO.getInstance());
	}
	
	@Test
	public void testListRegleIsNotNull() {
		assertNotNull(ArrayListRegleDAO.getInstance().getRegles());
	}
	
	@Test
	public void testCreerRegle() {
		Regle regle = new Regle("statu = \"cadre\"", "", true);
		ArrayListRegleDAO.getInstance().create(regle);
		assertTrue(ArrayListRegleDAO.getInstance().getRegles().contains(regle));
	}
	
	@Test
	public void testGetByIdRegleNotNull() {
		assertNotNull(ArrayListRegleDAO.getInstance().getById(1));
	}
	
	@Test
	public void testGetByIdRegleIsEquals() {
		assertEquals(new Regle(1, "brut = 2000", "", true), ArrayListRegleDAO.getInstance().getById(1));
	}
	
	@Test
	public void testUpdateActif() {
		Regle regle = ArrayListRegleDAO.getInstance().getById(1);
		regle.setActif(false);
		ArrayListRegleDAO.getInstance().update(regle);
		
		assertFalse(ArrayListRegleDAO.getInstance().getById(1).isActif());
	}
	
	@Test
	public void testUpdateAction() {
		Regle regle = ArrayListRegleDAO.getInstance().getById(1);
		regle.setAction("");
		ArrayListRegleDAO.getInstance().update(regle);
		
		assertEquals(regle.getAction(), ArrayListRegleDAO.getInstance().getById(1).getAction());
	}
	
	@Test
	public void testDelete() {
		Regle regle = new Regle(4, "", "test", false);
		ArrayListRegleDAO.getInstance().delete(regle);
		assertFalse(ArrayListRegleDAO.getInstance().getRegles().contains(regle));
	}
}
