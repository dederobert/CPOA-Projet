package appli.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import appli.manager.CotisationManager;
import appli.manager.EmployeManager;
import appli.manager.RegleManager;
import appli.modele.metier.Cotisation;
import appli.modele.metier.Employe;
import appli.modele.metier.Regle;
import appli.utils.Utilitaire;
import appli.utils.Vue;
import appli.vue.IVue;
import appli.vue.panels.PanelMenu;
import appli.vue.panels.cotisation.PanelAjoutCotisation;
import appli.vue.panels.cotisation.PanelDetailsCotisation;
import appli.vue.panels.cotisation.PanelModificationCotisation;
import appli.vue.panels.employe.PanelAjoutEmploye;
import appli.vue.panels.employe.PanelDetailsEmploye;
import appli.vue.panels.employe.PanelModificationEmploye;
import appli.vue.panels.regle.PanelDetailsRegle;

public class Controleur implements ActionListener, ListSelectionListener {

	private IVue vue;

	@Override
	public void actionPerformed(ActionEvent event) {
		String nom;
		String prenom;
		String adresse;
		String libelle;
		Double taux;
		Employe employe;
		Cotisation cotisation;
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
		case "addCotisation":
			libelle = vue.getLibelle();
			taux = vue.getTaux();

			if (libelle.isEmpty() || libelle == null || taux == null) {
				JOptionPane.showMessageDialog(null,
						"Attention il faut remplir tout les champs !!",
						"erreu", JOptionPane.ERROR_MESSAGE);
				break;
			}
			cotisation = new Cotisation(libelle, taux);
			Utilitaire.getFactory().getCotisationDAO().create(cotisation);
			CotisationManager.refresh();
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
		case "showAddCotisation":
			PanelAjoutCotisation ajoutCotisation = new PanelAjoutCotisation();
			vue.changeCentrePanel(ajoutCotisation);
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
				employe.setNom(nom);
				employe.setPrenom(prenom);
				employe.setAdresse(adresse);
				Utilitaire.getFactory().getEmployeDAO().update(employe);

				vue.refresh();
				vue.changeCentrePanel(null);
			}
			break;
		case "modifierCotisation":
			jop = new JOptionPane();
			@SuppressWarnings("static-access")
			int option1 = jop.showConfirmDialog(null,
					"Voulez-vous vraiment modifier cette cotisation",
					"Confirmer modfication", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (option1 != JOptionPane.NO_OPTION
					&& option1 != JOptionPane.CANCEL_OPTION
					&& option1 != JOptionPane.CLOSED_OPTION) {
				libelle = vue.getLibelle();
				taux = vue.getTaux();
				if (libelle.isEmpty() || libelle == null || taux == null) {
					JOptionPane.showMessageDialog(null,
							"Tout les champs doivent être remplis", "erreur",
							JOptionPane.ERROR_MESSAGE);
					break;
				}
				cotisation = CotisationManager.getCotisation(vue
						.getSelectedIndex());
				cotisation.setLibelle(libelle);
				cotisation.setTaux(taux);
				Utilitaire.getFactory().getCotisationDAO().update(cotisation);
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
		case "showModifierCotisation":
			if (vue.getSelectedIndex() != -1) {
				Cotisation cotisation2 = CotisationManager.getCotisation(vue
						.getSelectedIndex());
				PanelModificationCotisation modificationCotisation = new PanelModificationCotisation();
				modificationCotisation.remplitChamps(cotisation2.getLibelle(),
						cotisation2.getTaux());
				vue.changeCentrePanel(modificationCotisation);
			}
			break;
		case "supprimerEmploye":
			if (vue.getSelectedIndex() != -1) {
				jop = new JOptionPane();
				@SuppressWarnings("static-access")
				int option2 = jop.showConfirmDialog(null,
						"Voulez-vous vraiment supprimer cette employé",
						"Confirmer suppression",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (option2 != JOptionPane.NO_OPTION
						&& option2 != JOptionPane.CANCEL_OPTION
						&& option2 != JOptionPane.CLOSED_OPTION) {
					Employe employe11 = EmployeManager.getEmploye(vue
							.getSelectedIndex());
					Utilitaire.getFactory().getEmployeDAO().delete(employe11);
					vue.refresh();
					vue.changeCentrePanel(null);
				}
			}
			break;
		case "supprimerCotisation":
			if (vue.getSelectedIndex() != -1) {
				jop = new JOptionPane();
				@SuppressWarnings("static-access")
				int option2 = jop.showConfirmDialog(null,
						"Voulez-vous vraiment supprimer cette cotisation",
						"Confirmer suppression",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (option2 != JOptionPane.NO_OPTION
						&& option2 != JOptionPane.CANCEL_OPTION
						&& option2 != JOptionPane.CLOSED_OPTION) {
					Cotisation cotisation2 = CotisationManager
							.getCotisation(vue.getSelectedIndex());
					Utilitaire.getFactory().getCotisationDAO()
							.delete(cotisation2);
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

				if (vue.getVueActive() == Vue.EMPLOYE) {

					PanelMenu.setGenererEnable(true);

					PanelDetailsEmploye panelDetails = new PanelDetailsEmploye();
					Employe employe = EmployeManager.getEmploye(vue
							.getSelectedIndex());
					panelDetails.remplitChamps(employe.getNom(),
							employe.getPrenom(), employe.getAdresse());
					panelDetails.setRegles(EmployeManager.getRegle(vue
							.getSelectedIndex()));
					panelDetails.setVariables(EmployeManager.getVariable(vue
							.getSelectedIndex()));
					vue.changeCentrePanel(panelDetails);
				} else if (vue.getVueActive() == Vue.COTISATION) {
					PanelDetailsCotisation panelDetails = new PanelDetailsCotisation();
					Cotisation cotisation = CotisationManager.getCotisation(vue
							.getSelectedIndex());
					panelDetails.remplitChamps(cotisation.getLibelle(),
							cotisation.getTaux());
					vue.changeCentrePanel(panelDetails);
				} else {
					PanelDetailsRegle panelDetails = new PanelDetailsRegle();
					Regle regle = RegleManager.getRegle(vue.getSelectedIndex());
					panelDetails.remplitChamps(regle.getCondition(), regle.getAction(), regle.isActif());
					vue.changeCentrePanel(panelDetails);
				}
			}
		}

	}

	public ArrayList<String> getList() {
		ArrayList<String> list = new ArrayList<String>();
		if (vue == null) {
			for (Employe employe : EmployeManager.getAll()) {
				list.add(employe.toString());
			}
		} else {
			switch (vue.getVueActive()) {
			case EMPLOYE:
				for (Employe employe : EmployeManager.getAll()) {
					list.add(employe.toString());
				}
				break;
			case COTISATION:
				for (Cotisation cotisation : CotisationManager.getAll()) {
					list.add(cotisation.toString());
				}
				break;
			case REGLE:
				for (Regle regle : RegleManager.getAll()) {
					list.add(regle.toString());
				}
				break;
			default:
				break;
			}
		}
		return list;
	}

}
