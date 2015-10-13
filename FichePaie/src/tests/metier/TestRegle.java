package tests.metier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import appli.modele.metier.Regle;

public class TestRegle {
	
	@Test
	public void testConstructeur1NotNull() {
		assertNotNull(new Regle());
	}
	
	@Test
	public void testConstructeur1Values() {
		Regle regle = new Regle();

		assertNotNull(regle.getId());
		assertNotNull(regle.getCondition());
		assertNotNull(regle.getAction());
		assertNotNull(regle.isActif());
	}

	@Test
	public void testConstructeur2NotNull() {
		assertNotNull(new Regle("brut  = 500", "secu = 0.5", true));
	}

	@Test
	public void testConstructeur2Values() {
		Regle regle =  new Regle("brut = 500", "secu = 0.5", true);

		assertNotNull(regle.getId());
		assertEquals("brut = 500", regle.getCondition());
		assertEquals("secu = 0.5", regle.getAction());
		assertTrue(regle.isActif());
	}

	//TODO FINIR
	
	@Test
	public void testConstructeur3NotNull() {
		assertNotNull(new Cotisation(2, "secu", 0.8));
	}

	@Test
	public void testConstructeur3Values() {
		Cotisation cotisation = new Cotisation(1, "secu", 0.8);

		assertEquals(1, cotisation.getId());
		assertEquals("secu", cotisation.getLibelle());
		assertEquals(0.8, cotisation.getTaux(), 1e-5);
	}

	@Test
	public void testEquals() {
		Cotisation cotisation = new Cotisation(1, "secu", 0.8);
		Cotisation cotisation2 = new Cotisation(1, "secu", 0.8);

		assertTrue(cotisation.equals(cotisation2));

	}

	@Test
	public void testEqualsFalse() {
		Cotisation cotisation = new Cotisation(1, "secu", 0.8);
		Cotisation cotisation2 = new Cotisation(5, "truc", 5);

		assertFalse(cotisation.equals(cotisation2));

	}
}
