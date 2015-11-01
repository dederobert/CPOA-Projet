package appli.manager;

import java.util.ArrayList;

import appli.modele.metier.Regle;
import appli.utils.Utilitaire;

public class RegleManager {
	
	static ArrayList<Regle> regles = new ArrayList<Regle>();

	public static Regle getRegle(int selectedIndex) {
		return regles.get(selectedIndex);
	}

	public static ArrayList<Regle> getAll() {
		regles = Utilitaire.getFactory().getRegleDAO().getAllRegle();
		return regles;
	}

	public static void refresh() {
		regles = Utilitaire.getFactory().getRegleDAO().getAllRegle();
		
	}

}
