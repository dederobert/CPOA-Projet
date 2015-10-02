package tests;

import appli.dao.factory.DAOFactory;
import appli.dao.factory.Persistance;
import appli.modele.metier.Cotisation;
import appli.modele.metier.Employe;
import appli.modele.metier.Regle;
import appli.modele.metier.Variable;
import appli.modele.services.RegleServices;

public class Main {

	public static void main(String[] args) {		
		
		RegleServices.conditionIsValide(null);
		 System.exit(0);
		
		DAOFactory daof = DAOFactory.getDAOFactory(Persistance.ArrayList);
		
		Employe employe1 = new Employe("LAJOUX", "Alexis", "Metz");
		Employe employe2 = new Employe("DINQUER", "Alexis", "Metz");
		
		Regle regle1 = new Regle("brut > 1", "je sais pas", true);
		Regle regle2 = new Regle("statu = cadre", "je sais tjrs pas", true);
		
		Variable variable1 = new Variable("statut");
		Variable variable2 = new Variable("brut");
		
		Cotisation cotisation1 = new Cotisation("retraite", 0.8);
		Cotisation cotisation2 = new Cotisation("secu", 0.5);
		
		//SAVE
		daof.getEmployeDAO().create(employe1);
		int idEmploye = daof.getEmployeDAO().create(employe2);
		
		daof.getRegleDAO().create(regle1);
		int idRegle = daof.getRegleDAO().create(regle2);
		
		daof.getVariableDAO().create(variable1);
		int idVariable = daof.getVariableDAO().create(variable2);
		
		daof.getCotisationDAO().create(cotisation1);
		int idCotisation = daof.getCotisationDAO().create(cotisation2);
		
		
		System.out.println(daof.getEmployeDAO().getById(idEmploye));
		System.out.println(daof.getRegleDAO().getById(idRegle));
		System.out.println(daof.getVariableDAO().getById(idVariable));
		System.out.println(daof.getCotisationDAO().getById(idCotisation));
		
		System.out.println("Getters :");
		System.out.println(daof.getEmployeDAO().getByNom("DINQUER"));
		System.out.println(daof.getCotisationDAO().getByLibelle("secu"));
		System.out.println(daof.getVariableDAO().getByLibelle("brut"));
		
		System.out.println("Deleter");
		daof.getEmployeDAO().delete(employe1);
		daof.getCotisationDAO().delete(cotisation1);
		daof.getRegleDAO().delete(regle1);
		daof.getVariableDAO().delete(variable1);
		
		System.out.println("Mise a jour");
		employe2.setAdresse("Paris");
		cotisation2.setLibelle("test");
		variable2.setLibelle("test_update");
		regle2.setActif(false);
		
		daof.getEmployeDAO().update(employe2);
		daof.getCotisationDAO().update(cotisation2);
		daof.getRegleDAO().update(regle2);
		daof.getVariableDAO().update(variable2);
		
		System.out.println(daof.getEmployeDAO().getById(idEmploye));
		System.out.println(daof.getRegleDAO().getById(idRegle));
		System.out.println(daof.getVariableDAO().getById(idVariable));
		System.out.println(daof.getCotisationDAO().getById(idCotisation));
		
	}

}
