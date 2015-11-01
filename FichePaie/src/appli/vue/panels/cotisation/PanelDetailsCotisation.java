package appli.vue.panels.cotisation;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import appli.vue.panels.PanelDetails;

public class PanelDetailsCotisation extends JPanel implements PanelDetails {

	private static final long serialVersionUID = -7064574986418764283L;
	private JLabel libelle = new JLabel();
	private JLabel taux = new JLabel();
	
	public PanelDetailsCotisation() {
		this.setLayout(new GridLayout(2, 2));
		this.add(new JLabel("Libelle : "));
		this.add(libelle);
		this.add(new JLabel("Taux : "));
		this.add(taux);
	}

	public void remplitChamps(String libelle, double taux) {
		this.setLibelle(libelle);
		this.setTaux(taux);
		
	}

	public void setTaux(double taux) {
		this.taux.setText(taux + "");
	}

	public void setLibelle(String libelle) {
		this.libelle.setText(libelle);
	}

}
