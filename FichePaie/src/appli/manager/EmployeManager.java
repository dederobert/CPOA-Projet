package appli.manager;

import java.util.ArrayList;

import appli.modele.metier.Employe;
import appli.utils.Utilitaire;

public class EmployeManager {
	
	static ArrayList<Employe> employes;
	
	public static ArrayList<Employe> getAllEmploye(){
		employes = Utilitaire.getFactory().getEmployeDAO().getAllEmploye();
		return employes;
	}

	public static Employe getEmploye(int selectedIndex) {
		return employes.get(selectedIndex);
		
	}
	
	public static void refresh() {
		employes = Utilitaire.getFactory().getEmployeDAO().getAllEmploye();
	}

}
