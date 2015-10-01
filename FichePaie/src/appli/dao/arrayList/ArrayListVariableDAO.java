package appli.dao.arrayList;

import java.util.ArrayList;

import appli.dao.VariableDAO;
import appli.modele.metier.Variable;

public class ArrayListVariableDAO implements VariableDAO {

	private ArrayList<Variable> variables = null;
	private static ArrayListVariableDAO instance = null;

	private ArrayListVariableDAO() {
		setVariables(new ArrayList<Variable>());
		getVariables().add(new Variable(1, "brut"));
		getVariables().add(new Variable(2, "statut"));
		getVariables().add(new Variable(3, "horaire"));
	}

	public ArrayList<Variable> getVariables() {
		return variables;
	}

	public void setVariables(ArrayList<Variable> variables) {
		this.variables = variables;
	}

	public static ArrayListVariableDAO getInstance() {
		if (instance == null) {
			instance = new ArrayListVariableDAO();
		}
		return instance;
	}

	@Override
	public Variable getById(int id) {
		Variable variable = new Variable(id, "");
		int index = variables.indexOf(variable);
		variable = (index!=-1)?variables.get(index):null;
		return variable;
	}

	@Override
	public int create(Variable objet) {
		int id = 1;
		if (!variables.isEmpty()) {
			id = variables.get(variables.size() - 1).getId() + 1;
		}
		objet.setId(id);
		variables.add(objet);
		return id;
	}

	@Override
	public int update(Variable objet) {
		variables.set(variables.indexOf(objet), objet);
		return 0;
	}

	@Override
	public int delete(Variable objet) {
		variables.remove(objet);
		return 0;
	}

	@Override
	public Variable getByLibelle(String libelle) {
		for (Variable variable : variables)
			if (variable.getLibelle().equals(libelle)) {
				return variable;
			}
		return null;
	}

}
