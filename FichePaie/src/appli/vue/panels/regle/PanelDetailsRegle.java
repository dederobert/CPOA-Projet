package appli.vue.panels.regle;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import appli.vue.panels.PanelDetails;

public class PanelDetailsRegle extends JPanel implements PanelDetails {

	private static final long serialVersionUID = -1861063339124818957L;
	private JLabel condition = new JLabel();
	private JLabel action = new JLabel();
	private JLabel actif = new JLabel();
	
	public PanelDetailsRegle() {
		this.setLayout(new GridLayout(3,2));
		this.add(new JLabel("Condition :"));
		this.add(condition);
		this.add(new JLabel("Action :"));
		this.add(action);
		this.add(new JLabel("Actif"));
		this.add(actif);
		
	}
	
	public void remplitChamps(String condition, String action, boolean actif) {
		this.setCondition(condition);
		this.setAction(action);
		this.setActif(actif);
		
	}

	public void setCondition(String condition) {
		this.condition.setText(condition);
	}

	public void setAction(String action) {
		this.action.setText(action);
	}

	public void setActif(boolean actif) {
		if(actif)
		{
			this.actif.setText("OUI");
		}else {
			this.actif.setText("NON");
		}
	}
	
	

	
}
