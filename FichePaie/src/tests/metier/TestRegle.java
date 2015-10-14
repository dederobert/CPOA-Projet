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
		assertNotNull(new Regle("brut = 500", "secu = 0.5", true));
	}

	@Test
	public void testConstructeur2Values() {
		Regle regle = new Regle("brut = 500", "secu = 0.5", true);

		assertNotNull(regle.getId());
		assertEquals("brut = 500", regle.getCondition());
		assertEquals("secu = 0.5", regle.getAction());
		assertTrue(regle.isActif());
	}

	// TODO FINIR

	@Test
	public void testConstructeur3NotNull() {
		assertNotNull(new Regle(1, "brut = 500", "secu = 0.5", true));
	}

	@Test
	public void testConstructeur3Values() {
		Regle regle = new Regle(1, "brut = 500", "secu = 0.5", true);

		assertEquals(1, regle.getId());
		assertEquals("brut = 500", regle.getCondition());
		assertEquals("secu = 0.5", regle.getAction());
		assertTrue(regle.isActif());
	}

	@Test
	public void testEquals() {
		Regle regle = new Regle(1, "brut = 500", "secu = 0.5", true);
		Regle regle2 = new Regle(1, "brut = 500", "secu = 0.5", true);

		assertTrue(regle.equals(regle2));

	}

	@Test
	public void testEqualsFalse() {
		Regle regle = new Regle(1, "brut = 500", "secu = 0.5", true);
		Regle regle2 = new Regle(15, "brut = 87", "secu = 0.5", false);

		assertFalse(regle.equals(regle2));
	}
}
