package appli.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import appli.manager.EmployeManager;
import appli.modele.metier.Employe;
import appli.utils.Utilitaire;
import appli.vue.IVue;
import appli.vue.panels.PanelAjoutEmploye;
import appli.vue.panels.PanelDetails;

public class Controleur implements ActionListener, ListSelectionListener {
	
	private IVue vue;

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "addEmploye":
			Employe employe = new Employe(vue.getNomEmp(), vue.getPrenomEmp(), vue.getAdresseEmp());
			Utilitaire.getFactory().getEmployeDAO().create(employe);
			EmployeManager.refresh();
			vue.refresh();
			vue.changeCentrePanel(null);
			break;
		case "showAddEmploye":
			PanelAjoutEmploye panelAjout = new PanelAjoutEmploye();
			vue.changeCentrePanel(panelAjout);
			break;
		default:
			break;
		}
		
	}

	public IVue getVue() {
		return vue;
	}

	public void setVue(IVue vue) {
		this.vue = vue;
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		if (event.getValueIsAdjusting() == false)
		{
			if (vue.getSelectedIndex() != -1)
			{
				PanelDetails panelDetails = new PanelDetails();
				Employe employe = EmployeManager.getEmploye(vue.getSelectedIndex());
				panelDetails.setNom(employe.getNom());
				panelDetails.setPrenom(employe.getPrenom());
				panelDetails.setAdresse(employe.getAdresse());
				panelDetails.setDonnees(EmployeManager.getRegle(vue.getSelectedIndex()));
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
