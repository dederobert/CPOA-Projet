package appli.vue.panels.cotisation;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import appli.vue.Fenetre;

public class PanelAjoutCotisation extends JPanel implements CotisationModif{

	private static final long serialVersionUID = 530781814202321492L;
	private static JTextField libelle = new JTextField();
	private static JTextField taux = new JTextField();
	
	public PanelAjoutCotisation() {
		this.setLayout(new GridLayout(3, 1));
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("Libelle : "));
		libelle.setPreferredSize(new Dimension(150, 30));
		panel.add(libelle);
		this.add(panel);
		
		panel = new JPanel();
		panel.add(new JLabel("Taux : "));
		taux.setPreferredSize(new Dimension(150, 30));
		panel.add(taux);
		this.add(panel);
		
		JButton button = new JButton("Ajouter");
		panel = new JPanel();
		button.setActionCommand("addCotisation");
		button.addActionListener(Fenetre.getControleur());
		panel.add(button);
		this.add(panel);
	}
	
	public String getLibelle() {
		return libelle.getText();
	}
	public static void setLibelle(JTextField libelle) {
		PanelAjoutCotisation.libelle = libelle;
	}
	public Double getTaux() {
		try{
			return Double.parseDouble(taux.getText());
		}catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Attention le taux doit être un nombre", "erreur", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	public static void setTaux(JTextField taux) {
		PanelAjoutCotisation.taux = taux;
	}
}
