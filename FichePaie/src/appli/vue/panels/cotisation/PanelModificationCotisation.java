package appli.vue.panels.cotisation;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import appli.vue.Fenetre;

public class PanelModificationCotisation extends JPanel implements
		CotisationModif {

	private static final long serialVersionUID = 1622787356394295011L;
	private static JTextField libelle = new JTextField();
	private static JTextField taux = new JTextField();

	public PanelModificationCotisation() {
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
		
		JPanel pnlButton = new JPanel();
		JButton button = new JButton("Modifier");
		button.setActionCommand("modifierCotisation");
		button.addActionListener(Fenetre.getControleur());
		pnlButton.add(button);
		this.add(pnlButton);
	}

	@Override
	public String getLibelle() {
		return libelle.getText();
	}

	@Override
	public Double getTaux() {
		try {
			return Double.parseDouble(taux.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Attention le taux doit être un nombre ", "erreur",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public void remplitChamps(String libelle, double taux) {
		this.setLibelle(libelle);
		this.setTaux(taux);

	}

	private void setTaux(double taux2) {
		taux.setText(taux2 + "");
	}

	private void setLibelle(String libelle2) {
		libelle.setText(libelle2);

	}
}
