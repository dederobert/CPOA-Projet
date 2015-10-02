package appli.dao.arrayList;

import java.util.ArrayList;
import java.util.HashMap;

import appli.dao.EmployeDAO;
import appli.modele.metier.Employe;
import appli.modele.metier.Regle;
import appli.modele.metier.Variable;

/**
 * Class DAO persistance ArrayList
 * Sauvegarde des Employes
 * @author lajoux2u
 *
 */

public class ArrayListEmployeDAO implements EmployeDAO {

	/**
	 * Liste des Employes
	 */
	private ArrayList<Employe> employes = null;
	
	/**
	 * Instance de {@link ArrayListEmployeDAO}
	 */
	private static ArrayListEmployeDAO instance = null;

	/**
	 * Constructeur de {@link ArrayListEmployeDAO}
	 */
	private ArrayListEmployeDAO() {
		setEmployes(new ArrayList<Employe>());
		getEmployes().add(new Employe(1, "LAJOUX", "Alexis", "metz"));
		getEmployes().add(new Employe(2, "DINQUER", "Alexis", "metz"));
		getEmployes().add(new Employe(3, "LEMETAYER", "Leo", "metz"));
	}

	/**
	 * Permet d'obtenir la list des Employes
	 * @return la list des employes
	 */
	public ArrayList<Employe> getEmployes() {
		return employes;
	}

	/**
	 * Permet de définir la list des Employes
	 * @param employes list d'employes
	 */
	public void setEmployes(ArrayList<Employe> employes) {
		this.employes = employes;
	}

	
	/**
	 * Permet d'obtenir l'instance de {@link ArrayListEmployeDAO}
	 * <b>Singleton</b>
	 * @return instance de {@link ArrayListEmployeDAO}
	 */
	public static ArrayListEmployeDAO getInstance() {
		if (instance == null) {
			instance = new ArrayListEmployeDAO();
		}
		return instance;
	}
	
	/**
	 * Permet de recuperer un Employe à l'aide d'un Id
	 * @param id Identifiant de l'Employe
	 * @return Employe correspondant
	 * @see DAO
	 */
	@Override
	public Employe getById(int id) {
		Employe employe = new Employe(id, "", "", "");
		int index = employes.indexOf(employe);
		employe = (index!=-1)?employes.get(index):null;
		return employe;
	}
	/**
	 * Permet d'enregistrer dans un nouveau Employe
	 * @param objet Employe à enregistrer
	 * @return Identifiant de l'Employe
	 * @see DAO
	 */
	@Override
	public int create(Employe objet) {
		int id = 1;
		if (!employes.isEmpty()) {
			id = employes.get(employes.size() - 1).getId() + 1;
		}
		objet.setId(id);
		employes.add(objet);
		return id;
	}

	/**
	 * Permet de mettre à jour un Employe
	 * @param objet Employe à mettre à jour
	 * @return nombre de ligne modifié
	 * @see DAO
	 */
	@Override
	public int update(Employe objet) {
		if(!employes.contains(objet))
		{
			throw new IndexOutOfBoundsException("L'objet à mettre à jour n'est pas dans la list");
		}
		
		employes.get(employes.indexOf(objet)).setAdresse(objet.getAdresse());
		employes.get(employes.indexOf(objet)).setNom(objet.getNom());
		employes.get(employes.indexOf(objet)).setPrenom(objet.getPrenom());
		employes.get(employes.indexOf(objet)).setRegles(objet.getRegles());
		employes.get(employes.indexOf(objet)).setVariables(objet.getVariables());
		return 0;
	}
	
	/**
	 * Permet de supprimer dans un nouveau Employe
	 * @param objet Employe à supprimer
	 * @return nombre de ligne supprimé
	 * @see DAO
	 */
	@Override
	public int delete(Employe objet) {
		employes.remove(objet);
		return 0;
	}
	
	/**
	 * Permet de recuperer un Employe à l'aide d'un nom
	 * @param nom Nom de l'Employe
	 * @see EmployeDAO
	 */
	@Override
	public Employe getByNom(String nom) {
		for (Employe employe : employes)
			if (employe.getNom().equals(nom)) {
				return employe;
			}
		return null;
	}
	
	/**
	 * Permet de récupérer les regles d'un Employe
	 * @param employe Employe
	 * @return list de l'Employe
	 */
	@Override
	public ArrayList<Regle> getRegles(Employe employe) {
		return employes.get(employes.indexOf(employe)).getRegles();

	}

	/**
	 * Permet de récupérer les variables d'un Employe
	 * @param employe Employe
	 * @return list de l'Employe
	 */
	@Override
	public HashMap<Variable, String> getVariables(Employe employe) {
		return employes.get(employes.indexOf(employe)).getVariables();

	}

	/**
	 * Permet d'ajouter une regle à un Employe
	 * @param employe Employe 
	 * @param regle Regle à ajouter
	 */
	@Override
	public void addRegle(Employe employe, Regle regle) {
		employe.getRegles().add(regle);
		
	}

	/**
	 * Permet d'ajouter une variable à un Employe
	 * @param employe Employe 
	 * @param variable Variable à ajouter
	 * @param valeur Valeur à ajouter
	 */ 
	@Override
	public void addVariable(Employe employe, Variable variable, String valeur) {
		employe.getVariables().put(variable, valeur);
		
	}

	/**
	 * Permet de supprimer un regle à un Employe
	 * @param employe Employe
	 * @param regle Regle à supprimer
	 */
	@Override
	public void removeRegle(Employe employe, Regle regle) {
		employe.getRegles().remove(regle);
	}

	/**
	 * Permet de supprimer une variable à un Employe
	 * @param employe Employe
	 * @param variable Variable à supprimer
	 * @param valeur Valeur à supprimer
	 */
	@Override
	public void removeVariable(Employe employe, Variable variable, String valeur) {
		employe.getVariables().remove(variable);
	}

}
