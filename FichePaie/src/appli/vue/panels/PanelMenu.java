package appli.vue.panels;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import appli.controleur.Controleur;
import appli.controleur.MenuBarControleur;
import appli.dao.mysql.Connexion;

public class PanelMenu{

	public JMenuBar menuBar = new JMenuBar();
	static JRadioButtonMenuItem bdd = new JRadioButtonMenuItem("Base de Donnée");
	static JRadioButtonMenuItem arrayList = new JRadioButtonMenuItem("ArrayList");
	static JMenuItem menuGenerer;
	
	public PanelMenu(Controleur controleur) {
		MenuBarControleur menuControleur = new MenuBarControleur(controleur);
		JMenu menuFichier = new JMenu("Fichier");
		
			JMenu menuSaveOption = new JMenu("Persistance");
				
				bdd.setActionCommand("bdd");
				bdd.addActionListener(menuControleur);
				try{
					Connexion.checkConnexion();
					bdd.setSelected(true);
				}catch(Exception e){
					arrayList.setSelected(true);
				}
				
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
			
		JMenu menuVue = new JMenu("Vue");
			JMenuItem itemEmploye = new JMenuItem("Employe");
			itemEmploye.setActionCommand("employe");
			itemEmploye.addActionListener(menuControleur);
			JMenuItem itemCotisation = new JMenuItem("Cotisation");
			itemCotisation.setActionCommand("cotisation");
			itemCotisation.addActionListener(menuControleur);
			JMenuItem itemRegle = new JMenuItem("Regle");
			itemRegle.setActionCommand("regle");
			itemRegle.addActionListener(menuControleur);
		
		JMenu menuFichePai = new JMenu("Fiche de paie");
			menuGenerer = new JMenuItem("Generer");
			menuGenerer.setActionCommand("generer");
			setGenererEnable(false);
			menuGenerer.addActionListener(menuControleur);
		
		menuSaveOption.add(bdd);
		menuSaveOption.add(arrayList);
		menuFichier.add(menuSaveOption);
		menuFichier.add(menuRefresh);
		menuFichier.addSeparator();
		menuFichier.add(menuFermer);
		menuFichePai.add(menuGenerer);
		
		menuVue.add(itemEmploye);
		menuVue.add(itemCotisation);
		menuVue.add(itemRegle);
		
		menuBar.add(menuFichier);
		menuBar.add(menuVue);
		menuBar.add(menuFichePai);
	}

	public static void setPersistance(String string) {
		if(string=="arrayList")
		{
			bdd.setSelected(false);
			arrayList.setSelected(true);
		}else
		{
			bdd.setSelected(true);
			arrayList.setSelected(false);
		}	
	}

	public static void setGenererEnable(boolean etat) {
		menuGenerer.setEnabled(etat);
	}
}
