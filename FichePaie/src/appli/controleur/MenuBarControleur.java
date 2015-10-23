package appli.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import appli.dao.factory.Persistance;
import appli.dao.mysql.Connexion;
import appli.utils.Utilitaire;
import appli.vue.panels.PanelMenu;

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
			try {
				Connexion.checkConnexion();
			} catch (Exception e1) {
				Utilitaire.setFactory(Persistance.ArrayList);
				PanelMenu.setPersistance("arrayList");
				JOptionPane.showMessageDialog(null, e1, "Impossible de se connecter au serveur", JOptionPane.ERROR_MESSAGE);
			}
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
