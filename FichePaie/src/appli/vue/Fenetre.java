package appli.vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import appli.controleur.Controleur;
import appli.vue.panels.MainPanel;
import appli.vue.panels.PanelAjoutEmploye;
import appli.vue.panels.PanelMenu;
import appli.vue.panels.PanelWelcome;

public class Fenetre extends JFrame implements IVue {
	
	private static Controleur controleur;
	private MainPanel mainPanel;
	
	public Fenetre(Controleur controleur) {
		setControleur(controleur);
		setSize(1024, 512);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		mainPanel = new MainPanel();
		mainPanel.setCentrePanel(new PanelWelcome());
		
		this.add(mainPanel);
		this.setJMenuBar(new PanelMenu().menuBar);
		setVisible(true);
	}

	public static Controleur getControleur() {
		return controleur;
	}

	public static void setControleur(Controleur controleur) {
		Fenetre.controleur = controleur;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public int getSelectedIndex() {
		return mainPanel.getSelectedIndex();
	}

	@Override
	public void changeCentrePanel(JPanel panelDetails) {
		mainPanel.setCentrePanel(panelDetails);		
	}

	@Override
	public String getNomEmp() {
		return PanelAjoutEmploye.getNom().getText();
	}

	@Override
	public String getPrenomEmp() {
		return PanelAjoutEmploye.getPrenom().getText();
	}

	@Override
	public String getAdresseEmp() {
		return PanelAjoutEmploye.getAdresse().getText();
	}

	@Override
	public void refresh() {
		mainPanel.getRightPanel().refresh();
		
	}

	
	
	
	

}
