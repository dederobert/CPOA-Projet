package appli.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import appli.modele.metier.Employe;
import appli.modele.metier.Regle;
import appli.modele.metier.Variable;
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

	public static String[][] getRegle(int index) {
		ArrayList<Regle> listRegle = employes.get(index).getRegles();
		String regles[][] = new String[listRegle.size()+1][2];
		int i=0;
		for(Regle regle : listRegle){
			regles[i][0] = regle.getCondition();
			regles[i++][1] = regle.getAction();
		}
		
		return regles;
		
	}

	public static String[][] getVariable(int index) {
		HashMap<Variable, String> listVariable = employes.get(index).getVariables();
		String variables[][] = new String[listVariable.size()+1][2];
		int i=0;
		for(Entry<Variable,String> variable : listVariable.entrySet()){
			variables[i][0] = variable.getKey().getLibelle();
			variables[i++][1] = variable.getValue();
		}
		return variables;
	}


}
