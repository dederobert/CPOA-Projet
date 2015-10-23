package appli.dao;

import java.util.ArrayList;

import appli.modele.metier.Cotisation;

/**
 * Interface de la gestion de persistance des Cotisation <br /> <b>DAO niveau 2</b>
 * @author alexis & alexis
 *
 */
public interface CotisationDAO extends DAO<Cotisation>{
	
	public Cotisation getByLibelle(String libelle);

	public ArrayList<Cotisation> getAll();
	
}
