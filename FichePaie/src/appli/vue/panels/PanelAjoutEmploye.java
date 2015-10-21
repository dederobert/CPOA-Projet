package appli.vue.panels;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAjoutEmploye extends JPanel{

	private static final long serialVersionUID = -1122466879128550129L;
	
	public PanelAjoutEmploye() {
		this.setLayout(new GridLayout(0,2));
		this.add(new JLabel("Nom : "));
		this.add(new JLabel("Prenom : "));
		this.add(new JLabel("Adresse : "));
	}

}
