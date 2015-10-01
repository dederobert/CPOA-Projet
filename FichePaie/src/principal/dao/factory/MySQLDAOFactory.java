package principal.dao.factory;

import principal.dao.CotisationDAO;
import principal.dao.EmployeDAO;
import principal.dao.RegleDAO;
import principal.dao.VariableDAO;
import principal.dao.mysql.MySQLCotisationDAO;
import principal.dao.mysql.MySQLEmployeDAO;
import principal.dao.mysql.MySQLRegleDAO;
import principal.dao.mysql.MySQLVariableDAO;

public class MySQLDAOFactory extends DAOFactory{
	
	public MySQLDAOFactory() {}

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
