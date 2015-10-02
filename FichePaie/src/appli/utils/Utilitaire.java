package appli.utils;

import appli.dao.factory.DAOFactory;
import appli.dao.factory.Persistance;

public class Utilitaire {
	
	public static DAOFactory getFactory()
	{
		return DAOFactory.getDAOFactory(Persistance.ArrayList);
	}

}
