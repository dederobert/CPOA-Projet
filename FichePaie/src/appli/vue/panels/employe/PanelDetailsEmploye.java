package appli.vue.panels.employe;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import appli.vue.Fenetre;
import appli.vue.panels.PanelDetails;

@SuppressWarnings("unused")
public class PanelDetailsEmploye extends JPanel  implements PanelDetails{

	private static final long serialVersionUID = 1L;
	private JLabel nom = new JLabel();
	private JLabel prenom = new JLabel();
	private JLabel adresse = new JLabel();
	private String[][] donneesRegle;
	private JScrollPane spRegle;
	String[] colsRegle = { "Condition", "Action" };

	private String[][] donneesVariable;
	private JScrollPane spVariable;
	String[] colsVariable = { "Libelle", "Valeur" };

	public PanelDetailsEmploye() {
		this.setLayout(new GridLayout(6, 2));
		this.add(new JLabel("Nom : "));
		this.add(nom);
		this.add(new JLabel("Prenom : "));
		this.add(prenom);
		this.add(new JLabel("Adresse : "));
		this.add(adresse);
		this.add(new JLabel("Regles : "));
		this.add(new JLabel("Variable : "));
		spRegle = new JScrollPane();
		this.add(spRegle);
		spVariable = new JScrollPane();
		this.add(spVariable);
		/*JButton fichePaie = new JButton("Generer fiche de paie");
		fichePaie.setActionCommand("generer");
		fichePaie.addActionListener(Fenetre.getControleur());
		JPanel bouton = new JPanel();
		bouton.add(fichePaie);
		this.add(bouton);*/
	}

	public void setNom(String nom) {
		this.nom.setText(nom);
	}

	public void setPrenom(String prenom) {
		this.prenom.setText(prenom);
	}

	public void setAdresse(String adresse) {
		this.adresse.setText(adresse);
	}

	public void setRegles(String[][] donnees) {
		this.donneesRegle = donnees;
		JTable tab = new JTable(donnees, colsRegle);
		spRegle.setViewportView(tab);
		this.validate();
	}

	public void setVariables(String[][] donnees) {
		this.donneesVariable = donnees;
		JTable tab = new JTable(donnees, colsVariable);
		spVariable.setViewportView(tab);
		this.validate();
	}

	public void remplitChamps(String nom, String prenom, String adresse) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
	}
}
