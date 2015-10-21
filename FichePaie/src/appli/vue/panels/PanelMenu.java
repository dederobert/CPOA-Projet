package appli.vue.panels;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class PanelMenu extends JMenuBar{

	private static final long serialVersionUID = 1L;
	public JMenuBar menuBar = new JMenuBar();

	public PanelMenu() {
		
		JMenu menuFichier = new JMenu("Fichier");
		
			JMenu menuSaveOption = new JMenu("Option sauvegarde");
				JRadioButtonMenuItem bdd = new JRadioButtonMenuItem("Base de Donnée");
				bdd.setSelected(true);
				JRadioButtonMenuItem arrayList = new JRadioButtonMenuItem("ArrayList");
			
			JMenuItem menuSave = new JMenuItem("Sauvegarder");
			JMenuItem menuFermer = new JMenuItem("Fermer");
			
		JMenu menuEdition = new JMenu("Edition");
		
		
		menuSaveOption.add(bdd);
		menuSaveOption.add(arrayList);
		menuFichier.add(menuSaveOption);
		menuFichier.add(menuSave);
		menuFichier.addSeparator();
		menuFichier.add(menuFermer);
		
		menuBar.add(menuFichier);
		menuBar.add(menuEdition);
	}
}
