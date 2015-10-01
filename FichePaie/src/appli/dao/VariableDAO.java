package appli.dao;

import appli.modele.metier.Variable;
/**
 * Interface de gestion de la persistance des Variable <br /> <b>DAO niveau 2</b>
 * @author alexis
 *
 */
public interface VariableDAO extends DAO<Variable> {
	public Variable getByLibelle(String libelle);
}