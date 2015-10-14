package tests.mysql;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.dao.mysql.MySQLEmployeDAO;
import appli.modele.metier.Employe;

public class TestMySQLEmployeDAO {

	@Test
	public void testSingleton() {
		assertNotNull(MySQLEmployeDAO.getInstance());
	}

	@Test
	public void testGetByIdEmployeNotNull() {
		Employe employe = new Employe(5, "BOURGANIESH", "Robert", "toulouse");
		int id = MySQLEmployeDAO.getInstance().create(employe);
		
		assertNotNull(MySQLEmployeDAO.getInstance().getById(id));
	}

	@Test
	public void testGetByIdEmploye() {
		Employe employe = new Employe(5, "BOURGANIESH", "Robert", "toulouse");
		int id = MySQLEmployeDAO.getInstance().create(employe);

		assertEquals(employe, MySQLEmployeDAO.getInstance().getById(id));
	}

	@Test
	public void testGetByNomEmploye() {
		Employe employe = new Employe(5, "BOURGANIESH", "Robert", "toulouse");
		MySQLEmployeDAO.getInstance().create(employe);

		assertEquals(employe.getNom(),
				MySQLEmployeDAO.getInstance().getByNom("BOURGANIESH").getNom());
		assertEquals(employe.getPrenom(), MySQLEmployeDAO.getInstance()
				.getByNom("BOURGANIESH").getPrenom());
		assertEquals(employe.getAdresse(), MySQLEmployeDAO.getInstance()
				.getByNom("BOURGANIESH").getAdresse());
	}

	@Test
	public void testGetByNomEmployeIsNotNull() {
		assertNotNull(MySQLEmployeDAO.getInstance().getByNom("LAJOUX"));
	}

	@Test
	public void testCreerEmploye() {
		Employe employe = new Employe("BOURGANIESH", "Robert", "toulouse");
		int id = MySQLEmployeDAO.getInstance().create(employe);
		Employe employe2 = MySQLEmployeDAO.getInstance().getById(id);

		assertEquals("BOURGANIESH", employe2.getNom());
		assertEquals("Robert", employe2.getPrenom());
		assertEquals("toulouse", employe2.getAdresse());
	}

	@Test
	public void testCreerEmployeNotNull() {
		Employe employe = new Employe(5, "BOURGANIESH", "Robert", "toulouse");
		int id = MySQLEmployeDAO.getInstance().create(employe);
		assertNotNull(id);
	}

	@Test
	public void testUpdateNomEmploye() {
		Employe employe = new Employe(5, "BOURGANIESH", "Robert", "toulouse");
		int id = MySQLEmployeDAO.getInstance().create(employe);
		employe.setNom("BOURGANIESH");
		MySQLEmployeDAO.getInstance().update(employe);
		assertEquals(employe.getNom(), MySQLEmployeDAO.getInstance()
				.getById(id).getNom());
	}

	@Test
	public void testUpdatePrenomEmploye() {
		Employe employe = new Employe(5, "BOURGANIESH", "Robert", "toulouse");
		int id = MySQLEmployeDAO.getInstance().create(employe);
		employe.setNom("Robert");
		MySQLEmployeDAO.getInstance().update(employe);
		assertEquals(employe.getPrenom(), MySQLEmployeDAO.getInstance()
				.getById(id).getPrenom());
	}

	@Test
	public void testUpdateAdresseEmploye() {
		Employe employe = new Employe(5, "BOURGANIESH", "Robert", "toulouse");
		int id = MySQLEmployeDAO.getInstance().create(employe);
		employe.setAdresse("toulouse");
		MySQLEmployeDAO.getInstance().update(employe);
		assertEquals(employe.getAdresse(), MySQLEmployeDAO.getInstance()
				.getById(id).getAdresse());
	}

	@Test
	public void testDeleteEmploye() {
		Employe employe = new Employe(5, "BOURGANIESH", "Robert", "toulouse");
		int id = MySQLEmployeDAO.getInstance().create(employe);
		MySQLEmployeDAO.getInstance().delete(employe);
		assertNull(MySQLEmployeDAO.getInstance().getById(id));
	}
}
