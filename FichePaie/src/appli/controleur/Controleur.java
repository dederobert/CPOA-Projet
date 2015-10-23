package appli.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import appli.manager.EmployeManager;
import appli.modele.metier.Employe;
import appli.utils.Utilitaire;
import appli.vue.IVue;
import appli.vue.panels.PanelAjoutEmploye;
import appli.vue.panels.PanelDetails;
import appli.vue.panels.PanelModificationEmploye;

public class Controleur implements ActionListener, ListSelectionListener {

	private IVue vue;

	@Override
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "addEmploye":
			Employe employe = new Employe(vue.getNomEmp(), vue.getPrenomEmp(),
					vue.getAdresseEmp());
			Utilitaire.getFactory().getEmployeDAO().create(employe);
			EmployeManager.refresh();
			vue.refresh();
			vue.changeCentrePanel(null);
			break;
		case "showAddEmploye":
			PanelAjoutEmploye panelAjout = new PanelAjoutEmploye();
			vue.changeCentrePanel(panelAjout);
			break;
		case "modifierEmploye":
			Employe employe1 = EmployeManager
					.getEmploye(vue.getSelectedIndex());
			employe1.setNom(vue.getNomEmp());
			employe1.setPrenom(vue.getPrenomEmp());
			employe1.setAdresse(vue.getAdresseEmp());
			Utilitaire.getFactory().getEmployeDAO().update(employe1);
			vue.refresh();
			vue.changeCentrePanel(null);
			break;
		case "showModifierEmploye":
			if (vue.getSelectedIndex() != -1) {
				Employe employe11 = EmployeManager.getEmploye(vue
						.getSelectedIndex());
				PanelModificationEmploye panelModif = new PanelModificationEmploye();
				panelModif.setNom(employe11.getNom());
				panelModif.setPrenom(employe11.getPrenom());
				panelModif.setAdresse(employe11.getAdresse());
				vue.changeCentrePanel(panelModif);
			}
			break;
		case "supprimerEmploye":
			if (vue.getSelectedIndex() != -1) {
				JOptionPane jop = new JOptionPane();
				@SuppressWarnings("static-access")
				int option = jop.showConfirmDialog(null,
						"Voulez-vous vraiment supprimer cette employé",
						"Quelque chose", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (option != JOptionPane.NO_OPTION
						&& option != JOptionPane.CANCEL_OPTION
						&& option != JOptionPane.CLOSED_OPTION) {
					Employe employe11 = EmployeManager.getEmploye(vue
							.getSelectedIndex());
					Utilitaire.getFactory().getEmployeDAO().delete(employe11);
					vue.refresh();
					vue.changeCentrePanel(null);
				}
			}
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
		if (event.getValueIsAdjusting() == false) {
			if (vue.getSelectedIndex() != -1) {
				PanelDetails panelDetails = new PanelDetails();
				Employe employe = EmployeManager.getEmploye(vue
						.getSelectedIndex());
				panelDetails.setNom(employe.getNom());
				panelDetails.setPrenom(employe.getPrenom());
				panelDetails.setAdresse(employe.getAdresse());
				panelDetails.setRegles(EmployeManager.getRegle(vue
						.getSelectedIndex()));
				panelDetails.setVariables(EmployeManager.getVariable(vue
						.getSelectedIndex()));
				vue.changeCentrePanel(panelDetails);
			}
		}

	}

	public ArrayList<String> getList() {
		ArrayList<String> employes = new ArrayList<String>();
		for (Employe employe : EmployeManager.getAllEmploye()) {
			employes.add(employe.toString());
		}

		return employes;
	}

}
