package appli.dao.arrayList;

import java.util.ArrayList;
import java.util.HashMap;

import appli.dao.EmployeDAO;
import appli.modele.metier.Employe;
import appli.modele.metier.Regle;
import appli.modele.metier.Variable;

public class ArrayListEmployeDAO implements EmployeDAO {

	private ArrayList<Employe> employes = null;
	private static ArrayListEmployeDAO instance = null;

	private ArrayListEmployeDAO() {
		setEmployes(new ArrayList<Employe>());
		getEmployes().add(new Employe(1, "LAJOUX", "Alexis", "metz"));
		getEmployes().add(new Employe(2, "DINQUER", "Alexis", "metz"));
		getEmployes().add(new Employe(3, "LEMETAYER", "Leo", "metz"));
	}

	public ArrayList<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(ArrayList<Employe> employes) {
		this.employes = employes;
	}

	public static ArrayListEmployeDAO getInstance() {
		if (instance == null) {
			instance = new ArrayListEmployeDAO();
		}
		return instance;
	}

	@Override
	public Employe getById(int id) {
		Employe employe = new Employe(id, "", "", "");
		int index = employes.indexOf(employe);
		employe = (index!=-1)?employes.get(index):null;
		return employe;
	}

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

	@Override
	public int update(Employe objet) {
		employes.set(employes.indexOf(objet), objet);
		return 0;
	}

	@Override
	public int delete(Employe objet) {
		employes.remove(objet);
		return 0;
	}

	@Override
	public Employe getByNom(String nom) {
		for (Employe employe : employes)
			if (employe.getNom().equals(nom)) {
				return employe;
			}
		return null;
	}

	@Override
	public ArrayList<Regle> getRegles(Employe employe) {
		return employes.get(employes.indexOf(employe)).getRegles();

	}

	@Override
	public HashMap<Variable, String> getVariables(Employe employe) {
		return employes.get(employes.indexOf(employe)).getVariables();

	}

	@Override
	public void addRegle(Employe employe, Regle regle) {
		employe.getRegles().add(regle);
		
	}

	@Override
	public void addVariable(Employe employe, Variable variable, String valeur) {
		employe.getVariables().put(variable, valeur);
		
	}

	@Override
	public void removeRegle(Employe employe, Regle regle) {
		employe.getRegles().remove(regle);
	}

	@Override
	public void removeVariable(Employe employe, Variable variable, String valeur) {
		employe.getVariables().remove(variable);
	}

}
