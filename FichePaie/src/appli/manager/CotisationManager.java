package appli.manager;

import java.util.ArrayList;

import appli.modele.metier.Cotisation;
import appli.utils.Utilitaire;

public class CotisationManager {
	
	static ArrayList<Cotisation> cotisations = new ArrayList<Cotisation>();

	public static ArrayList<Cotisation> getAll() {
		cotisations = Utilitaire.getFactory().getCotisationDAO().getAll();
		return cotisations;
	}
	

}
