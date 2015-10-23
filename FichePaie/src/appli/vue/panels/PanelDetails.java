package appli.vue.panels;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelDetails extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel nom = new JLabel();
	private JLabel prenom = new JLabel();
	private JLabel adresse = new JLabel();
	private String[][] donnees;
	private JScrollPane sp;
	String[] cols = {"Condition","Action"};

	public PanelDetails() {
		this.setLayout(new GridLayout(6,2));
		this.add(new JLabel("Nom : "));
		this.add(nom);
		this.add(new JLabel("Prenom : "));
		this.add(prenom);
		this.add(new JLabel("Adresse : "));
		this.add(adresse);
		this.add(new JLabel("Regles : "));
		this.add(new JLabel("Variable : "));
		
		sp = new JScrollPane();
		this.add(sp);
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

	public String[][] getDonnees() {
		return donnees;
	}

	public void setDonnees(String[][] donnees) {
		this.donnees = donnees;
		JTable tab = new JTable(donnees, cols);
		sp.setViewportView(tab);
		this.validate();
	}
	
}
