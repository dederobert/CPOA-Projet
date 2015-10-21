package appli.vue.panels;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 8879537991506742304L;
	
	public MainPanel() {
		
		this.add(creerMenu());
	}
	
	public JMenuBar creerMenu(){
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFichier = new JMenu("Fichier");
		
		JMenu menuSave = new JMenu("Option sauvegarde");
		JRadioButtonMenuItem bdd = new JRadioButtonMenuItem("Base de Donnée");
		bdd.setSelected(true);
		JRadioButtonMenuItem arrayList = new JRadioButtonMenuItem("ArrayList");
		
		JMenu menuNew = new JMenu("Nouveau");
		JMenuItem menuItemEmploye = new JMenuItem("Employé");
		
		JMenu menuEdition = new JMenu("Edition");
		
		menuNew.add(menuItemEmploye);
		menuSave.add(bdd);
		menuSave.add(arrayList);
		menuFichier.add(menuSave);
		menuFichier.add(menuNew);
		menuBar.add(menuFichier);
		menuBar.add(menuEdition);
			
		return menuBar;
	}

}
