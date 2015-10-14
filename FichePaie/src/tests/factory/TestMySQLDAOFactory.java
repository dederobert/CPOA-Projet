package tests.factory;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.dao.factory.DAOFactory;
import appli.dao.factory.Persistance;

public class TestMySQLDAOFactory {

	DAOFactory daoFactory = DAOFactory.getDAOFactory(Persistance.MySQL);

	@Test
	public void testGetEmploye() {
		assertNotNull(daoFactory.getEmployeDAO());
	}
	
	@Test
	public void testGetCotisation() {
		assertNotNull(daoFactory.getCotisationDAO());
	}
	
	@Test
	public void testGetRegle() {
		assertNotNull(daoFactory.getRegleDAO());
	}
	
	@Test
	public void testGetVariable() {
		assertNotNull(daoFactory.getVariableDAO());
	}

}
