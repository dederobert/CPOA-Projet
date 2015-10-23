package appli.vue.panels;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import appli.vue.Fenetre;

public class PanelModificationEmploye extends JPanel implements EmployeModif{

	private static final long serialVersionUID = -1122466879128550129L;
	private static JTextField nom = new JTextField();
	private static JTextField prenom = new JTextField();
	private static JTextField adresse = new JTextField();

	public PanelModificationEmploye() {
		this.setLayout(new GridLayout(4, 2));
		this.add(new JLabel("Nom : "));
		this.add(nom);
		this.add(new JLabel("Prenom : "));
		this.add(prenom);
		this.add(new JLabel("Adresse : "));
		this.add(adresse);

		JPanel pnlButton = new JPanel();
		JButton button = new JButton("Modifier");
		button.setActionCommand("modifierEmploye");
		button.addActionListener(Fenetre.getControleur());
		pnlButton.add(button);
		this.add(pnlButton);
	}
	
	@Override
	public String getNom() {
		return nom.getText();
	}

	@Override
	public String getPrenom() {
		return prenom.getText();
	}

	@Override
	public String getAdresse() {
		return adresse.getText();
	}

	public void setNom(String nom) {
		PanelModificationEmploye.nom.setText(nom);
	}

	public void setPrenom(String prenom) {
		PanelModificationEmploye.prenom.setText(prenom);
	}

	public void setAdresse(String adresse) {
		PanelModificationEmploye.adresse.setText(adresse);
	}

	
}
