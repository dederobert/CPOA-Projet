package principal;

import principal.dao.factory.DAOFactory;
import principal.dao.factory.Persistance;
import principal.modele.metier.Cotisation;
import principal.modele.metier.Employe;
import principal.modele.metier.Regle;
import principal.modele.metier.Variable;

public class Main {

	public static void main(String[] args) {
		DAOFactory daof = DAOFactory.getDAOFactory(Persistance.ArrayList);
		
		Employe emp1 = new Employe("LAJOUX", "Alexis", "Metz");
		Employe emp2 = new Employe("DINQUER", "Alexis", "Metz");
		
		Regle rg1 = new Regle("brut > 1", "je sais pas", true);
		Regle rg2 = new Regle("statu = cadre", "je sais tjrs pas", true);
		
		Variable v1 = new Variable("statut");
		Variable v2 = new Variable("brut");
		
		Cotisation cot1 = new Cotisation("retraite", 0.8);
		Cotisation cot2 = new Cotisation("secu", 0.5);
		
		//SAVE
		daof.getEmployeDAO().create(emp1);
		int id_emp = daof.getEmployeDAO().create(emp2);
		
		daof.getRegleDAO().create(rg1);
		int id_regle = daof.getRegleDAO().create(rg2);
		
		daof.getVariableDAO().create(v1);
		int id_var = daof.getVariableDAO().create(v2);
		
		daof.getCotisationDAO().create(cot1);
		int id_cot = daof.getCotisationDAO().create(cot2);
		
		
		System.out.println(daof.getEmployeDAO().getById(id_emp));
		System.out.println(daof.getRegleDAO().getById(id_regle));
		System.out.println(daof.getVariableDAO().getById(id_var));
		System.out.println(daof.getCotisationDAO().getById(id_cot));
		
		System.out.println("Getters :");
		System.out.println(daof.getEmployeDAO().getByNom("DINQUER"));
		System.out.println(daof.getCotisationDAO().getByLibelle("secu"));
		System.out.println(daof.getVariableDAO().getByLibelle("brut"));
		
		System.out.println("Deleter");
		daof.getEmployeDAO().delete(emp1);
		daof.getCotisationDAO().delete(cot1);
		daof.getRegleDAO().delete(rg1);
		daof.getVariableDAO().delete(v1);
		
		System.out.println("Mise a jour");
		emp2.setAdresse("Paris");
		cot2.setLibelle("test");
		v2.setLibelle("test_update");
		rg2.setActif(false);
		
		daof.getEmployeDAO().update(emp2);
		daof.getCotisationDAO().update(cot2);
		daof.getRegleDAO().update(rg2);
		daof.getVariableDAO().update(v2);
		
		System.out.println(daof.getEmployeDAO().getById(id_emp));
		System.out.println(daof.getRegleDAO().getById(id_regle));
		System.out.println(daof.getVariableDAO().getById(id_var));
		System.out.println(daof.getCotisationDAO().getById(id_cot));
		
	}

}
