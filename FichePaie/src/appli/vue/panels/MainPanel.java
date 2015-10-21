package appli.vue.panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 8879537991506742304L;
	
	private JPanel topMenuPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private JPanel centrePanel = new JPanel();
	
	public MainPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		this.add(topMenuPanel, BorderLayout.NORTH);
		this.add(rightPanel, BorderLayout.WEST);
		this.add(centrePanel, BorderLayout.CENTER);
		
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

	public JPanel getTopMenuPanel() {
		return topMenuPanel;
	}

	public void setTopMenuPanel(JPanel topMenuPanel) {
		this.topMenuPanel = topMenuPanel;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(JPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	public JPanel getCentrePanel() {
		return centrePanel;
	}

	public void setCentrePanel(JPanel centrePanel) {
		this.centrePanel = centrePanel;
		this.revalidate();
		this.repaint();
		
	}

}
