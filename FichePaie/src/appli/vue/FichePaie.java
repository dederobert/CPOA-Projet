package appli.vue;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import appli.controleur.DocumentControleur;
import appli.vue.panels.PanelFichePaie;

public class FichePaie extends JFrame{

	private static final long serialVersionUID = 1L;
	private static PanelFichePaie panel = new PanelFichePaie();
	
	public FichePaie(String nom, String prenom) {
	
		this.setTitle("Fiche de paie de " + nom + " " + prenom);
		this.setSize(new Dimension(500, 300));
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fichierMenu = new JMenu("Fichier");
		JMenu exporterMenu = new JMenu("Exporter en ...");
		JMenuItem exporterPDF = new JMenuItem("PDF");
		exporterPDF.setActionCommand("PDF");
		exporterPDF.addActionListener(new DocumentControleur());
		exporterMenu.add(exporterPDF);
		fichierMenu.add(exporterMenu);
		menuBar.add(fichierMenu);
		this.setJMenuBar(menuBar);
		panel.setIdentite("M(me). " + nom.toUpperCase() + " " + prenom);
		
		this.add(panel);
		
		
		this.setVisible(true);
	}

	public PanelFichePaie getPanel() {
		return panel;
	}

	public static void setPanel(PanelFichePaie panel) {
		FichePaie.panel = panel;
	}
	
	
}
