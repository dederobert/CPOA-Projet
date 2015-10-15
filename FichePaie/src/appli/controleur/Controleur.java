package appli.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import appli.vue.IVue;

public class Controleur implements ActionListener {
	
	private IVue vue;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public IVue getVue() {
		return vue;
	}

	public void setVue(IVue vue) {
		this.vue = vue;
	}

}
