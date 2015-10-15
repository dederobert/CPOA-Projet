package appli.vue;

import javax.swing.JFrame;

import appli.controleur.Controleur;

public class Fenetre extends JFrame implements IVue {
	
	private Controleur controleur;

	public Fenetre(Controleur controleur) {
		this.setControleur(controleur);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public Controleur getControleur() {
		return controleur;
	}

	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}

	private static final long serialVersionUID = 1L;
	
	
	
	

}