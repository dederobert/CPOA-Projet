package appli.vue;

import javax.swing.JFrame;

import appli.controleur.Controleur;
import appli.vue.panels.MainPanel;

public class Fenetre extends JFrame implements IVue {
	
	private Controleur controleur;

	public Fenetre(Controleur controleur) {
		this.setControleur(controleur);
		setSize(1024, 512);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		MainPanel mainPanel = new MainPanel();
		mainPanel.setCentrePanel(new PanelWelcome());
		
		this.add(new MainPanel());
		
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
