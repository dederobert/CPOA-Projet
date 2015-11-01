package appli.vue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import appli.controleur.Controleur;
import appli.utils.Vue;
import appli.vue.panels.MainPanel;
import appli.vue.panels.PanelMenu;
import appli.vue.panels.PanelWelcome;
import appli.vue.panels.cotisation.CotisationModif;
import appli.vue.panels.cotisation.PanelListCotisation;
import appli.vue.panels.employe.EmployeModif;
import appli.vue.panels.employe.PanelListEmploye;

public class Fenetre extends JFrame implements IVue {

	private static Controleur controleur;
	private MainPanel mainPanel;
	private Vue vueActive = Vue.EMPLOYE;

	public Fenetre(Controleur controleur) {
		setControleur(controleur);
		setSize(1024, 512);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setTitle("Fiche de Paie | BETA");

		mainPanel = new MainPanel();
		mainPanel.setCentrePanel(new PanelWelcome());

		this.add(mainPanel);
		this.setJMenuBar(new PanelMenu(controleur).menuBar);
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
		return ((EmployeModif) mainPanel.getCentrePanel()).getNom().trim();
	}

	@Override
	public String getPrenomEmp() {
		return ((EmployeModif) mainPanel.getCentrePanel()).getPrenom().trim();
	}

	@Override
	public String getAdresseEmp() {
		return ((EmployeModif) mainPanel.getCentrePanel()).getAdresse().trim();
	}

	@Override
	public void refresh() {
		mainPanel.getLeftPanel().refresh();

	}

	@Override
	public String getTextRecherche() {
		return mainPanel.getLeftPanel().getTextRecherche();

	}

	@Override
	public void changeVue(Vue vue) {
		switch (vue) {
		case EMPLOYE:
			this.setVueActive(Vue.EMPLOYE);
			mainPanel.setLeftPanel(new PanelListEmploye());
			this.refresh();
			System.out.println("Changement de vue: employe");
			break;
		case COTISATION:
			this.setVueActive(Vue.COTISATION);
			mainPanel.setLeftPanel(new PanelListCotisation());
			this.refresh();
			System.out.println("Changement de vue: cotisation");
			break;
		case REGLE:
			this.setVueActive(Vue.REGLE);
			mainPanel.setLeftPanel(new PanelListRegle());
			this.refresh();
			System.out.println("Changement de vue: regle");
			break;
		default:
			break;
		}
		
	}

	@Override
	public Vue getVueActive() {
		if(vueActive == null)
			setVueActive(Vue.EMPLOYE);
		
		return vueActive;
	}

	@Override
	public void setVueActive(Vue vueActive) {
		this.vueActive = vueActive;
	}

	@Override
	public String getLibelle() {
		return ((CotisationModif) mainPanel.getCentrePanel()).getLibelle().trim();
	}

	@Override
	public Double getTaux() {
		return ((CotisationModif) mainPanel.getCentrePanel()).getTaux();
	}

	@Override
	public String getCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isActif() {
		// TODO Auto-generated method stub
		return false;
	}
}
