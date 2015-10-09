package appli.dao.arrayList;

import java.util.ArrayList;

import appli.dao.CotisationDAO;
import appli.modele.metier.Cotisation;

/**
 * Class DAO persistance ArrayList
 * Sauvegarde des Cotisations
 * @author alexis
 * @version 1.0
 */
public class ArrayListCotisationDAO implements CotisationDAO{

	/**
	 * List des Cotisations
	 */
	private ArrayList<Cotisation> cotisations = null;
	/**
	 * Instance de {@link ArrayListCotisationDAO}
	 * <b>Singleton</b>
	 */
	private static ArrayListCotisationDAO instance = null;
	
	/**
	 * Constructeur de {@link ArrayListCotisationDAO}
	 */
	private ArrayListCotisationDAO() {
		setCotisations(new ArrayList<Cotisation>());
		getCotisations().add(new Cotisation(1, "retraite", 0.8));
		getCotisations().add(new Cotisation(2, "secu", 0.5));
		getCotisations().add(new Cotisation(3, "patronal", 2));
	}
	
	/**
	 * Permet d'obtenir la list des Cotisations
	 * @return la list des cotisations
	 */
	public ArrayList<Cotisation> getCotisations() {
		return cotisations;
	}
	
	/**
	 * Permet de définir la list des Cotisations
	 * @param cotisations list des cotisations
	 */
	public void setCotisations(ArrayList<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}
	
	/**
	 * Permet d'obtenir l'instance de {@link ArrayListCotisationDAO}
	 * <b>Singleton</b>
	 * @return instance de {@link ArrayListCotisationDAO}
	 */
	public static ArrayListCotisationDAO getInstance() {
		if (instance == null) {
			instance = new ArrayListCotisationDAO();
		}
		return instance;
	}
	
	/**
	 * Permet de récupérer une Cotisation à l'aide d'un Id
	 * @param id Identifiant de la Cotisation
	 * @return Cotisation correspondante
	 * @see DAO
	 */
	@Override
	public Cotisation getById(int id) {
		Cotisation cotisation = new Cotisation(id, "", 0);
		int index = cotisations.indexOf(cotisation);
		cotisation = (index!=-1)?cotisations.get(index):null;
		return cotisation;
	}
	
	/**
	 * Permet de d'enregister une nouvelle Cotisation
	 * @param objet Cotisation à enregistrer
	 * @return Identifiant de la cotisation
	 * @see DAO
	 */
	@Override
	public int create(Cotisation objet) {
		int id = 1;
		if(!cotisations.isEmpty()){
			id = cotisations.get(cotisations.size()-1).getId()+1;
		}
		objet.setId(id);
		cotisations.add(objet);
		return id;
	}

	/**
	 * Permet de mettre à jour une Cotisation
	 * @param objet Cotisation à mettre à jour
	 * @return nb ligne modifier
	 * @see DAO
	 */
	@Override
	public int update(Cotisation objet) {
		
		if(!cotisations.contains(objet))
		{
			throw new IndexOutOfBoundsException("L'objet a mettre a jour n'est pas dans la list");
		}
		
		cotisations.get(cotisations.indexOf(objet)).setLibelle(objet.getLibelle());
		cotisations.get(cotisations.indexOf(objet)).setTaux(objet.getTaux());
			
		return 0;
	}

	/**
	 * Permet de supprimer une Cotisation
	 * @param objet Cotisation à supprimer
	 * @return nb ligne supprimer
	 * @see DAO
	 */
	@Override
	public int delete(Cotisation objet) {
		cotisations.remove(objet);
		return 0;
	}

	/**
	 * Permet de récupérer une Cotisation à l'aide d'un libelle
	 * @param libelle Libelle de la cotisation
	 * @return Cotisation correspondante
	 * @see CotisationDAO
	 */
	@Override
	public Cotisation getByLibelle(String libelle) {
		for(Cotisation cotisation:cotisations)
		{
			if(cotisation.getLibelle().equals(libelle))
			{
				return cotisation;
			}
		}
		return null;
	}

}
