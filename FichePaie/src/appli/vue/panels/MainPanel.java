package appli.vue.panels;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel{

	private static final long serialVersionUID = 8879537991506742304L;
	
	private JPanel rightPanel = new JPanel();
	private JPanel centrePanel = new JPanel();
	
	public MainPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		
		this.add(rightPanel, BorderLayout.WEST);
		this.add(centrePanel, BorderLayout.CENTER);
		
	}


	public JPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(JPanel rightPanel) {
		this.remove(rightPanel);
		this.rightPanel = rightPanel;
		this.add(rightPanel);
	}

	public JPanel getCentrePanel() {
		return centrePanel;
	}

	public void setCentrePanel(JPanel centrePanel) {
		this.remove(centrePanel);
		this.centrePanel = centrePanel;
		this.add(centrePanel);
	}

}
