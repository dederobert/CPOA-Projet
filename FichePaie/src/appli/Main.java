package appli;

import appli.controleur.Controleur;
import appli.vue.Fenetre;

public class Main {

	public static void main(String[] args) {
		Controleur controleur = new Controleur();
		Fenetre fenetre = new Fenetre(controleur);
		controleur.setVue(fenetre);

	}

}
