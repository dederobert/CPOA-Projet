package principal.dao;

import java.util.ArrayList;
import java.util.HashMap;

import principal.modele.metier.Employe;
import principal.modele.metier.Regle;
import principal.modele.metier.Variable;
/**
 * Interface de gestion de la persistance des employé <br /> <b> DAO niveau 2</b>
 * @author alexis
 *
 */
public interface EmployeDAO extends DAO<Employe> {
        public Employe getByNom(String nom);
        public ArrayList<Regle> getRegles(Employe employe);
        public HashMap<Variable, String> getVariables(Employe employe);
        public void addRegle(Employe employe, Regle regle);
        public void addVariable(Employe employe, Variable variable, String valeur);
		public void removeRegle(Employe employe, Regle regle);
		public void removeVariable(Employe employe, Variable variable, String valeur);
}
