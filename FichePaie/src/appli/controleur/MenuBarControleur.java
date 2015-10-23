package appli.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import appli.dao.factory.Persistance;
import appli.utils.Utilitaire;

public class MenuBarControleur implements ActionListener {
	
	Controleur controleur = null;

	public MenuBarControleur(Controleur controleur) {
		this.controleur = controleur;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		case "close":
			System.exit(0);
			break;
		case "refresh":
			controleur.getVue().refresh();
			controleur.getVue().changeCentrePanel(null);
			break;
		case "bdd":
			Utilitaire.setFactory(Persistance.MySQL);
			controleur.getVue().refresh();
			controleur.getVue().changeCentrePanel(null);
			break;
		case "arrayList":
			Utilitaire.setFactory(Persistance.ArrayList);
			controleur.getVue().refresh();
			controleur.getVue().changeCentrePanel(null);
			break;
		default : break;
		}
	}


}
