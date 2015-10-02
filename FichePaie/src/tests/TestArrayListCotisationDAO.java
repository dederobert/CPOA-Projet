package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.dao.arrayList.ArrayListCotisationDAO;
import appli.modele.metier.Cotisation;

public class TestArrayListCotisationDAO {
	
	private static final double DELTA = 1e-5;

	@Test
	public void testSingleton() {
		assertNotNull(ArrayListCotisationDAO.getInstance());
	}
	
	@Test
	public void testListCotisationIsNotNull() {
		assertNotNull(ArrayListCotisationDAO.getInstance().getCotisations());
	}
	
	@Test
	public void testCreerCotisation() {
		Cotisation cotisation = new Cotisation("test", 0.18);
		ArrayListCotisationDAO.getInstance().create(cotisation);
		assertTrue(ArrayListCotisationDAO.getInstance().getCotisations().contains(cotisation));
	}
	
	@Test
	public void testGetByIdCotisationNotNull() {
		assertNotNull(ArrayListCotisationDAO.getInstance().getById(1));
	}
	
	@Test
	public void testGetByIdCotisationIsEquals() {
		assertEquals(new Cotisation(1, "retraite", 0.8), ArrayListCotisationDAO.getInstance().getById(1));
	}
	
	@Test
	public void testGetByLibelleNotNull() {
		assertNotNull(ArrayListCotisationDAO.getInstance().getByLibelle("secu"));
	}
	
	@Test
	public void testGetByLibelleIsSame() {
		assertEquals(new Cotisation(2, "secu", 0.5), ArrayListCotisationDAO.getInstance().getByLibelle("secu"));
	}
	
	
	@Test
	public void testUpdateLibelle() {
		Cotisation cotisation = ArrayListCotisationDAO.getInstance().getById(1);
		cotisation.setLibelle("testUpdate");
		ArrayListCotisationDAO.getInstance().update(cotisation);
		
		assertEquals(cotisation.getLibelle(), ArrayListCotisationDAO.getInstance().getById(1).getLibelle());
	}
	
	@Test
	public void testUpdateTaux() {
		Cotisation cotisation = ArrayListCotisationDAO.getInstance().getById(1);
		cotisation.setTaux(0.15);
		ArrayListCotisationDAO.getInstance().update(cotisation);
		
		assertEquals(cotisation.getTaux(), ArrayListCotisationDAO.getInstance().getById(1).getTaux(), DELTA);
	}
	
	@Test
	public void testDelete() {
		Cotisation cotisation = new Cotisation(4, "test", 0.28);
		ArrayListCotisationDAO.getInstance().delete(cotisation);
		assertFalse(ArrayListCotisationDAO.getInstance().getCotisations().contains(cotisation));
	}
}
