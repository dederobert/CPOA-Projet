package appli.vue.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import appli.vue.panels.employe.PanelListEmploye;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 8879537991506742304L;

	private PanelList leftPanel = new PanelListEmploye();
	private JPanel centrePanel = new JPanel();

	public MainPanel() {
		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(1, 2));

		this.add((Component) leftPanel);
		this.add(centrePanel);

	}

	public PanelList getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(PanelList leftPanel) {
		this.removeAll();
		if (leftPanel == null || !(leftPanel instanceof Component)) {
			System.err.println("Impossible de changé le panel ");
			return;
		}
		this.leftPanel = leftPanel;
		this.add((Component) this.leftPanel);
		this.add(new PanelWelcome());
		this.validate();
	}

	public JPanel getCentrePanel() {
		return centrePanel;
	}

	public void setCentrePanel(JPanel centrePanel) {
		this.remove(1);

		if (centrePanel == null) {
			this.centrePanel = new PanelWelcome();

		} else {
			this.centrePanel = centrePanel;
		}

		this.add(this.centrePanel);

		this.validate();
	}

	public int getSelectedIndex() {
		return leftPanel.getSelectedIndex();
	}
}
