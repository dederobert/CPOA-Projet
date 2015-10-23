package appli.utils;

import appli.dao.factory.DAOFactory;
import appli.dao.factory.Persistance;

public class Utilitaire {
	
	public static DAOFactory getFactory()
	{
		return DAOFactory.getDAOFactory(Persistance.MySQL);
	}
	
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException exception) {
			return false;
		}

		return true;
	}
	
	public static boolean isDouble(String value) {
		try{
			Double.parseDouble(value);
		}catch(NumberFormatException exception)
		{
			return false;
		}
		
		return true;
	}

}
