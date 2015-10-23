package appli.manager;

import java.util.ArrayList;

import appli.modele.metier.Employe;
import appli.modele.metier.Regle;
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

	public static String[][] getRegle(int j) {
		ArrayList<Regle> listRegle = employes.get(j).getRegles();
		String regles[][] = new String[listRegle.size()+1][2];
		int i=0;
		for(Regle regle : listRegle){
			regles[i][0] = regle.getCondition();
			regles[i++][1] = regle.getAction();
		}
		
		return regles;
		
	}

}
