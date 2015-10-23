package appli.vue.panels.employe;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import appli.vue.Fenetre;

public class PanelAjoutEmploye extends JPanel implements EmployeModif{

	private static final long serialVersionUID = -1122466879128550129L;
	private static JTextField nom = new JTextField();
	private static JTextField prenom = new JTextField();
	private static JTextField adresse = new JTextField();
	
	public PanelAjoutEmploye() {
		this.setLayout(new GridLayout(4,2));
		this.add(new JLabel("Nom : "));
		this.add(nom);
		this.add(new JLabel("Prenom : "));
		this.add(prenom);
		this.add(new JLabel("Adresse : "));
		this.add(adresse);
		
		JButton button = new JButton("Ajouter");
		button.setActionCommand("addEmploye");
		button.addActionListener(Fenetre.getControleur());
		this.add(button);
	}
	
	@Override
	public String getNom() {
		return nom.getText();
	}

	public static void setNom(JTextField nom) {
		PanelAjoutEmploye.nom = nom;
	}
	
	@Override
	public String getPrenom() {
		return prenom.getText();
	}

	public static void setPrenom(JTextField prenom) {
		PanelAjoutEmploye.prenom = prenom;
	}
	
	@Override
	public String getAdresse() {
		return adresse.getText();
	}

	public static void setAdresse(JTextField adresse) {
		PanelAjoutEmploye.adresse = adresse;
	}

	
}
