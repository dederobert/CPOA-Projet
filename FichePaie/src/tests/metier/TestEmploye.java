package tests.metier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import appli.modele.metier.Employe;
import appli.modele.metier.Regle;
import appli.modele.metier.Variable;

public class TestEmploye {

	@Test
	public void testConstructeur1NotNull() {
		assertNotNull(new Employe());
	}

	@Test
	public void testConstructeur1Values() {
		Employe employe = new Employe();

		assertNotNull(employe.getId());
		assertNotNull(employe.getNom());
		assertNotNull(employe.getPrenom());
		assertNotNull(employe.getAdresse());
		assertNotNull(employe.getRegles());
		assertNotNull(employe.getVariables());
	}

	@Test
	public void testConstructeur2NotNull() {
		assertNotNull(new Employe("LAJOUX", "Alexis", "Metz"));
	}

	@Test
	public void testConstructeur2Values() {
		Employe employe = new Employe("LAJOUX", "Alexis", "METZ");

		assertNotNull(employe.getId());
		assertEquals("LAJOUX", employe.getNom());
		assertEquals("Alexis", employe.getPrenom());
		assertEquals("METZ", employe.getAdresse());
		assertNotNull(employe.getRegles());
		assertNotNull(employe.getVariables());

	}

	@Test
	public void testConstructeur3NotNull() {
		assertNotNull(new Employe(2, "LAJOUX", "Alexis", "METZ"));
	}

	@Test
	public void testConstructeur3Values() {
		Employe employe = new Employe(2, "LAJOUX", "Alexis", "METZ");

		assertEquals(2, employe.getId());
		assertEquals("LAJOUX", employe.getNom());
		assertEquals("Alexis", employe.getPrenom());
		assertEquals("METZ", employe.getAdresse());
		assertNotNull(employe.getRegles());
		assertNotNull(employe.getVariables());
	}

	@Test
	public void testConstructeur4NotNull() {
		ArrayList<Regle> regles = new ArrayList<Regle>();
		HashMap<Variable, String> variables = new HashMap<Variable, String>();
		assertNotNull(new Employe(2, "LAJOUX", "Alexis", "METZ", regles,
				variables));
	}

	@Test
	public void testConstructeur4Values() {
		ArrayList<Regle> regles = new ArrayList<Regle>();
		HashMap<Variable, String> variables = new HashMap<Variable, String>();
		Employe employe = new Employe(2, "LAJOUX", "Alexis", "METZ", regles,
				variables);

		assertEquals(2, employe.getId());
		assertEquals("LAJOUX", employe.getNom());
		assertEquals("Alexis", employe.getPrenom());
		assertEquals("METZ", employe.getAdresse());
		assertEquals(regles, employe.getRegles());
		assertEquals(variables, employe.getVariables());
	}
	
	@Test
	public void testEquals() {
		Employe employe = new Employe(2, "LAJOUX", "Alexis", "METZ");
		Employe employe2 = new Employe(2, "LAJOUX", "Alexis", "METZ");

		assertTrue(employe.equals(employe2));

	}

	@Test
	public void testEqualsFalse() {
		Employe employe = new Employe(2, "LAJOUX", "Alexis", "METZ");
		Employe employe2 = new Employe(25, "DINQUER", "Alexis", "METZ");

		assertFalse(employe.equals(employe2));

	}

}
