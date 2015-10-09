package tests.mysql;

import static org.junit.Assert.*;

import org.junit.Test;

import appli.dao.mysql.MySQLRegleDAO;
import appli.modele.metier.Regle;

public class TestMySQLRegleDAO {

	@Test
	public void testSingleton() {
		assertNotNull(MySQLRegleDAO.getInstance());
	}
	
	@Test
	public void testCreerRegleIdNotNull(){
		Regle regle = new Regle("brut = 1200", "", true);
		int id = MySQLRegleDAO.getInstance().create(regle);
		assertNotNull(id);
	}
	
	//TODO FINIR

}
