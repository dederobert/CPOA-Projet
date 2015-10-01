package principal.dao.factory;

import principal.dao.CotisationDAO;
import principal.dao.EmployeDAO;
import principal.dao.RegleDAO;
import principal.dao.VariableDAO;
import principal.dao.arrayList.ArrayListCotisationDAO;
import principal.dao.arrayList.ArrayListEmployeDAO;
import principal.dao.arrayList.ArrayListRegleDAO;
import principal.dao.arrayList.ArrayListVariableDAO;

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
