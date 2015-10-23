package appli.vue.panels.employe;

import java.awt.Dimension;
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
		this.setLayout(new GridLayout(4, 1));
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
