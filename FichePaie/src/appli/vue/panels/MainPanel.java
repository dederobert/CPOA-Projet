package appli.vue.panels;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import appli.vue.panels.employe.PanelList;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 8879537991506742304L;
	
	private PanelList rightPanel = new PanelList();
	private JPanel centrePanel = new JPanel();
	
	public MainPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(1,2));
		
		this.add(rightPanel);
		this.add(centrePanel);
		
	}


	public PanelList getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(PanelList rightPanel) {
		this.remove(rightPanel);
		this.rightPanel = rightPanel;
		this.add(rightPanel);
	}

	public JPanel getCentrePanel() {
		return centrePanel;
	}

	public void setCentrePanel(JPanel centrePanel) {
		this.remove(1);
		
		if (centrePanel == null)
		{
			this.centrePanel = new PanelWelcome();
			
		}else{
			this.centrePanel = centrePanel;
		}
		
		this.add(this.centrePanel);
		
		this.validate();
	}


	public int getSelectedIndex() {
		return rightPanel.getSelectedIndex();
	}
}
