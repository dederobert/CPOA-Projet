package appli.vue.panels.employe;

import java.awt.Dimension;
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
		this.setLayout(new GridLayout(4,1));
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("Nom : "));
		nom.setPreferredSize(new Dimension(150, 30));
		panel.add(nom);
		this.add(panel);
		
		panel = new JPanel();
		panel.add(new JLabel("Prenom : "));
		prenom.setPreferredSize(new Dimension(150, 30));
		panel.add(prenom);
		this.add(panel);
		
		panel = new JPanel();
		panel.add(new JLabel("Adresse : "));
		adresse.setPreferredSize(new Dimension(150, 30));
		panel.add(adresse);
		this.add(panel);
		
		JButton button = new JButton("Ajouter");
		panel = new JPanel();
		button.setActionCommand("addEmploye");
		button.addActionListener(Fenetre.getControleur());
		panel.add(button);
		this.add(panel);
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
