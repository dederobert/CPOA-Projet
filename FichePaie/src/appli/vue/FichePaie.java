package appli.vue;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FichePaie extends JFrame{

	private static final long serialVersionUID = 1L;
	public FichePaie(String nom, String prenom) {
	
		this.setTitle("Fiche de paie de " + nom + " " + prenom);
		this.setSize(new Dimension(500, 300));
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fichierMenu = new JMenu("Fichier");
		JMenu exporterMenu = new JMenu("Exporter en ...");
		JMenuItem exporterPDF = new JMenuItem("PDF");
		exporterMenu.add(exporterPDF);
		fichierMenu.add(exporterMenu);
		menuBar.add(fichierMenu);
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
	}
}
