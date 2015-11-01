package appli.vue.panels.regle;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import appli.vue.Fenetre;

public class PanelAjoutRegle extends JPanel implements RegleModif {
	private static final long serialVersionUID = 530781814202321492L;
	private static JTextField condition = new JTextField();
	private static JTextField action = new JTextField();
	private static JRadioButton actif = new JRadioButton("oui");
	private static JRadioButton inactif = new JRadioButton("non");
	
	public PanelAjoutRegle() {
		this.setLayout(new GridLayout(4,1));
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("Condition :"));
		condition.setPreferredSize(new Dimension(150, 30));
		panel.add(condition);
		this.add(panel);
		
		panel = new JPanel();
		panel.add(new JLabel("Action :"));
		action.setPreferredSize(new Dimension(150, 30));
		panel.add(action);
		this.add(panel);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(actif);
		bg.add(inactif);
		
		panel = new JPanel();
		panel.add(new JLabel("Actif :"));
		panel.add(actif);
		panel.add(inactif);
		
		JButton button = new JButton("Ajouter");
		panel = new JPanel();
		button.setActionCommand("addRegle");
		button.addActionListener(Fenetre.getControleur());
		panel.add(button);
		this.add(panel);
	}
	
	@Override
	public String getCondition() {
		return condition.getText();
	}
	@Override
	public String getAction() {
		return condition.getText();
	}
	@Override
	public boolean isActif() {
		return actif.isSelected();
	}
	
	
}
