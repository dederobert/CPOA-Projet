package appli.utils;

import appli.dao.factory.DAOFactory;
import appli.dao.factory.Persistance;

public class Utilitaire {
	
	private static DAOFactory factory = null;
	
	public static DAOFactory getFactory()
	{
		if(factory == null){
			factory = DAOFactory.getDAOFactory(Persistance.ArrayList);
		}
		return factory;
	}
	
	public static void setFactory(Persistance persistance){
		factory = DAOFactory.getDAOFactory(persistance);
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
