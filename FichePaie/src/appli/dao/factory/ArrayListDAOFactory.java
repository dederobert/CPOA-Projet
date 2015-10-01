package appli.dao.factory;

import appli.dao.CotisationDAO;
import appli.dao.EmployeDAO;
import appli.dao.RegleDAO;
import appli.dao.VariableDAO;
import appli.dao.arrayList.ArrayListCotisationDAO;
import appli.dao.arrayList.ArrayListEmployeDAO;
import appli.dao.arrayList.ArrayListRegleDAO;
import appli.dao.arrayList.ArrayListVariableDAO;

public class ArrayListDAOFactory extends DAOFactory{
	
	public ArrayListDAOFactory() {}

	@Override
	public CotisationDAO getCotisationDAO() {
		return ArrayListCotisationDAO.getInstance();
	}

	@Override
	public EmployeDAO getEmployeDAO() {
		return ArrayListEmployeDAO.getInstance();
	}

	@Override
	public RegleDAO getRegleDAO() {
		return ArrayListRegleDAO.getInstance();
	}

	@Override
	public VariableDAO getVariableDAO() {
		return ArrayListVariableDAO.getInstance();
	}

}
