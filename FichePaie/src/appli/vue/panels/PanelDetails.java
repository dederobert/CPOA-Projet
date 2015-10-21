package appli.vue.panels;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDetails extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel nom = new JLabel();
	private JLabel prenom = new JLabel();
	private JLabel adresse = new JLabel();

	public PanelDetails() {
		this.setLayout(new GridLayout(2,4));
		this.add(new JLabel("Nom : "));
		this.add(nom);
		this.add(new JLabel("Prenom : "));
		this.add(prenom);
		this.add(new JLabel("Adresse : "));
		this.add(adresse);
		
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
	
}
