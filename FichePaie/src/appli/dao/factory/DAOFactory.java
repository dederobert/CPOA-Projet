package appli.dao.factory;

import appli.dao.CotisationDAO;
import appli.dao.EmployeDAO;
import appli.dao.RegleDAO;
import appli.dao.VariableDAO;

public abstract class DAOFactory {
	public static DAOFactory getDAOFactory(Persistance cible)
	{
		DAOFactory daoF = null;
		switch(cible)
		{
		case MySQL: 
			daoF = new MySQLDAOFactory();
			break;
		case ArrayList: 
			daoF = new ArrayListDAOFactory();
			break;
		}
		return daoF;
	}
	
	public abstract CotisationDAO getCotisationDAO();
	public abstract EmployeDAO getEmployeDAO();
	public abstract RegleDAO getRegleDAO();
	public abstract VariableDAO getVariableDAO();
}
