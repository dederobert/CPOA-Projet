package appli.vue.panels;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import appli.controleur.Controleur;
import appli.controleur.MenuBarControleur;

public class PanelMenu{

	public JMenuBar menuBar = new JMenuBar();

	public PanelMenu(Controleur controleur) {
		MenuBarControleur menuControleur = new MenuBarControleur(controleur);
		JMenu menuFichier = new JMenu("Fichier");
		
			JMenu menuSaveOption = new JMenu("Persistance");
				JRadioButtonMenuItem bdd = new JRadioButtonMenuItem("Base de Donnée");
				bdd.setActionCommand("bdd");
				bdd.addActionListener(menuControleur);
				bdd.setSelected(true);
				JRadioButtonMenuItem arrayList = new JRadioButtonMenuItem("ArrayList");
				arrayList.setActionCommand("arrayList");
				arrayList.addActionListener(menuControleur);
			ButtonGroup bg = new ButtonGroup();
				bg.add(bdd);
				bg.add(arrayList);
			
				
			JMenuItem menuRefresh = new JMenuItem("Refresh");
			menuRefresh.setActionCommand("refresh");
			menuRefresh.addActionListener(menuControleur);
			JMenuItem menuFermer = new JMenuItem("Fermer");
			menuFermer.setActionCommand("close");
			menuFermer.addActionListener(menuControleur);
			
		JMenu menuEdition = new JMenu("Edition");
		JMenu menuFichePai = new JMenu("Fiche de paie");
			JMenuItem menuGenerer = new JMenuItem("Generer");
			menuGenerer.setActionCommand("generer");
			menuGenerer.addActionListener(menuControleur);
		
		menuSaveOption.add(bdd);
		menuSaveOption.add(arrayList);
		menuFichier.add(menuSaveOption);
		menuFichier.add(menuRefresh);
		menuFichier.addSeparator();
		menuFichier.add(menuFermer);
		menuFichePai.add(menuGenerer);
		
		menuBar.add(menuFichier);
		menuBar.add(menuEdition);
		menuBar.add(menuFichePai);
	}
}
