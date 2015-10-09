package tests;
import static org.junit.Assert.*;

import org.junit.Test;

import appli.dao.mysql.MySQLEmployeDAO;


public class TestMySQLEmployeDAO {

	@Test
	public void testSingleton() {
		assertNotNull(MySQLEmployeDAO.getInstance());
	}

	@Test
	public void testGetByIdEmployeNotNull() {
		assertNotNull(MySQLEmployeDAO.getInstance().getById(1));
	}
}
