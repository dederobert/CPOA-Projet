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
import appli.vue.panels.PanelMenu;
import appli.vue.panels.PanelModificationEmploye;

public class Controleur implements ActionListener, ListSelectionListener {

	private IVue vue;

	@Override
	public void actionPerformed(ActionEvent event) {
		String nom;
		String prenom;
		String adresse;
		Employe employe;
		JOptionPane jop;
		switch (event.getActionCommand()) {
		case "addEmploye":
			nom = vue.getNomEmp();
			prenom = vue.getPrenomEmp();
			adresse = vue.getAdresseEmp();

			if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty()
					|| nom == null || prenom == null || adresse == null) {
				JOptionPane.showMessageDialog(null,
						"Attention il vous faut remplir tout les champs !!",
						"erreur", JOptionPane.ERROR_MESSAGE);
				break;
			}
			employe = new Employe(nom, prenom, adresse);
			Utilitaire.getFactory().getEmployeDAO().create(employe);
			EmployeManager.refresh();
			vue.refresh();
			vue.changeCentrePanel(null);
			break;
		case "recherche":
			Employe employe2 = Utilitaire.getFactory().getEmployeDAO()
					.getByNom(vue.getTextRecherche());
			if (employe2 == null) {
				vue.changeCentrePanel(null);
				break;
			}
			PanelModificationEmploye panelModif = new PanelModificationEmploye();
			panelModif.setNom(employe2.getNom());
			panelModif.setPrenom(employe2.getPrenom());
			panelModif.setAdresse(employe2.getAdresse());
			vue.changeCentrePanel(panelModif);
			break;
		case "showAddEmploye":
			PanelAjoutEmploye panelAjout = new PanelAjoutEmploye();
			vue.changeCentrePanel(panelAjout);
			break;
		case "modifierEmploye":

			jop = new JOptionPane();
			@SuppressWarnings("static-access")
			int option = jop.showConfirmDialog(null,
					"Voulez-vous vraiment modifier cette employé",
					"Confirmer modification", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (option != JOptionPane.NO_OPTION
					&& option != JOptionPane.CANCEL_OPTION
					&& option != JOptionPane.CLOSED_OPTION) {

				nom = vue.getNomEmp();
				prenom = vue.getPrenomEmp();
				adresse = vue.getAdresseEmp();

				if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty()
						|| nom == null || prenom == null || adresse == null) {
					JOptionPane
							.showMessageDialog(
									null,
									"Attention il vous faut remplir tout les champs !!",
									"erreur", JOptionPane.ERROR_MESSAGE);
					break;
				}
				employe = EmployeManager.getEmploye(vue.getSelectedIndex());
				employe.setNom(vue.getNomEmp());
				employe.setPrenom(vue.getPrenomEmp());
				employe.setAdresse(vue.getAdresseEmp());
				Utilitaire.getFactory().getEmployeDAO().update(employe);
				
				vue.refresh();
				vue.changeCentrePanel(null);
			}
			break;
		case "showModifierEmploye":
			if (vue.getSelectedIndex() != -1) {
				Employe employe11 = EmployeManager.getEmploye(vue
						.getSelectedIndex());
				PanelModificationEmploye panelModif1 = new PanelModificationEmploye();
				panelModif1.setNom(employe11.getNom());
				panelModif1.setPrenom(employe11.getPrenom());
				panelModif1.setAdresse(employe11.getAdresse());
				vue.changeCentrePanel(panelModif1);
			}
			break;
		case "supprimerEmploye":
			if (vue.getSelectedIndex() != -1) {
				jop = new JOptionPane();
				@SuppressWarnings("static-access")
				int option1 = jop.showConfirmDialog(null,
						"Voulez-vous vraiment supprimer cette employé",
						"Confirmer suppression",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (option1 != JOptionPane.NO_OPTION
						&& option1 != JOptionPane.CANCEL_OPTION
						&& option1 != JOptionPane.CLOSED_OPTION) {
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
				
				PanelMenu.setGenererEnable(true);
				
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
