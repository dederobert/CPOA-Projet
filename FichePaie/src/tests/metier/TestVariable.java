package tests.metier;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.modele.metier.Variable;


public class TestVariable {

	@Test
	public void testConstructeur1NotNull() {
		assertNotNull(new Variable());
	}

	@Test
	public void testConstructeur1Values() {
		Variable variable = new Variable();

		assertNotNull(variable.getId());
		assertNotNull(variable.getLibelle());
	}

	@Test
	public void testConstructeur2NotNull() {
		assertNotNull(new Variable("Brut"));
	}

	@Test
	public void testConstructeur2Values() {
		Variable variable = new Variable("Brut");

		assertNotNull(variable.getId());
		assertEquals("Brut", variable.getLibelle());
	}

	@Test
	public void testConstructeur3NotNull() {
		assertNotNull(new Variable(2, "Brut"));
	}

	@Test
	public void testConstructeur3Values() {
		Variable variable = new Variable(2, "Brut");

		assertEquals(2, variable.getId());
		assertEquals("Brut", variable.getLibelle());
	}

	@Test
	public void testEquals() {
		Variable variable = new Variable(2, "Brut");
		Variable variable2 = new Variable(2, "Brut");

		assertTrue(variable.equals(variable2));
	}

	@Test
	public void testEqualsFalse() {
		Variable variable = new Variable(2, "Brut");
		Variable variable2 = new Variable(25, "Statu");

		assertFalse(variable.equals(variable2));
	}
}
