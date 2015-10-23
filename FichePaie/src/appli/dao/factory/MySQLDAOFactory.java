package appli.dao.factory;

import appli.dao.CotisationDAO;
import appli.dao.EmployeDAO;
import appli.dao.RegleDAO;
import appli.dao.VariableDAO;
import appli.dao.mysql.MySQLCotisationDAO;
import appli.dao.mysql.MySQLEmployeDAO;
import appli.dao.mysql.MySQLRegleDAO;
import appli.dao.mysql.MySQLVariableDAO;

public class MySQLDAOFactory extends DAOFactory{
	
	public MySQLDAOFactory() {
		
	}

	@Override
	public CotisationDAO getCotisationDAO() {
		return MySQLCotisationDAO.getInstance();
	}

	@Override
	public EmployeDAO getEmployeDAO() {
		return MySQLEmployeDAO.getInstance();
	}

	@Override
	public RegleDAO getRegleDAO() {
		return MySQLRegleDAO.getInstance();
	}

	@Override
	public VariableDAO getVariableDAO() {
		return MySQLVariableDAO.getInstance();
	}

}
