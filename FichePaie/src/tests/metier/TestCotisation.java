package tests.metier;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.modele.metier.Cotisation;

public class TestCotisation {

	@Test
	public void testConstructeur1NotNull() {
		assertNotNull(new Cotisation());
	}

	@Test
	public void testConstructeur2NotNull() {
		assertNotNull(new Cotisation("secu", 0.8));
	}

	@Test
	public void testConstructeur2Values() {
		Cotisation cotisation = new Cotisation("secu", 0.8);

		assertEquals("secu", cotisation.getLibelle());
		assertEquals(0.8, cotisation.getTaux(), 1e-5);
	}

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
