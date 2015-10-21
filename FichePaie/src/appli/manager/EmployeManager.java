package appli.manager;

import java.util.ArrayList;

import appli.modele.metier.Employe;
import appli.utils.Utilitaire;

public class EmployeManager {
	
	public static ArrayList<Employe> getAllEmploye(){
		return Utilitaire.getFactory().getEmployeDAO().getAllEmploye();
	}

}
