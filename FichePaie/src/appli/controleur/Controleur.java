package appli.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import appli.manager.EmployeManager;
import appli.modele.metier.Employe;
import appli.vue.IVue;
import appli.vue.panels.PanelDetails;

public class Controleur implements ActionListener, ListSelectionListener {
	
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false)
		{
			if (vue.getSelectedIndex() != -1)
			{
				PanelDetails panelDetails = new PanelDetails();
				Employe employe = EmployeManager.getEmploye(vue.getSelectedIndex());
				panelDetails.setNom(employe.getNom());
				panelDetails.setPrenom(employe.getPrenom());
				panelDetails.setAdresse(employe.getAdresse());
				vue.changeCentrePanel(panelDetails);
			}
		}
		
	}

	public ArrayList<String> getList() {
		ArrayList<String> employes = new ArrayList<String>();
		for(Employe employe:EmployeManager.getAllEmploye())
		{
			employes.add(employe.toString());
		}
		
		return employes;
	}

}
