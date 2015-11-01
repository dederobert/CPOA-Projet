package appli.vue;

import java.awt.Dimension;

import javax.swing.JFrame;

import appli.vue.panels.PanelFichePaie;

public class FichePaie extends JFrame{

	private static final long serialVersionUID = 1L;
	private static PanelFichePaie panel = new PanelFichePaie();
	
	public FichePaie(String nom, String prenom) {
	
		this.setTitle("Fiche de paie de " + nom + " " + prenom);
		this.setSize(new Dimension(500, 300));
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
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
