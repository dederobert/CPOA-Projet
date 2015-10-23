package appli.modele.metier;

import appli.manager.CotisationManager;
import appli.utils.Utilitaire;

public class EmployeFichePaie {
	private Employe employe = null;
	private String[][] fiche = null;
	
	public EmployeFichePaie(Employe employe) {
		this.setEmploye(employe);
		this.setFiche(new String[CotisationManager.getAll().size()+1][5]);
		
		this.getFiche()[0][0] = "";
		this.getFiche()[0][1] = "SALAIRE BRUT";
		this.getFiche()[0][2] = "";
		this.getFiche()[0][3] = "";
		this.getFiche()[0][4] = employe.getVariables().get(Utilitaire.getFactory().getVariableDAO().getByLibelle("Brut"));
	}
	
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String[][] getFiche() {
		return fiche;
	}

	public void setFiche(String[][] fiche) {
		this.fiche = fiche;
	}
	
	

}
