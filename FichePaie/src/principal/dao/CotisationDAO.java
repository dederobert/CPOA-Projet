package principal.dao;

import principal.modele.metier.Cotisation;

/**
 * Interface de la gestion de persistance des Cotisation <br /> <b>DAO niveau 2</b>
 * @author alexis
 *
 */
public interface CotisationDAO extends DAO<Cotisation>{
	
	public Cotisation getByLibelle(String libelle);
	
}
