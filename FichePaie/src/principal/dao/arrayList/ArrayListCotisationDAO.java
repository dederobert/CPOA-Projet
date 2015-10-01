package principal.dao.arrayList;

import java.util.ArrayList;

import principal.dao.CotisationDAO;
import principal.modele.metier.Cotisation;

public class ArrayListCotisationDAO implements CotisationDAO{

	private ArrayList<Cotisation> cotisations = null;
	private static ArrayListCotisationDAO instance = null;
	
	
	private ArrayListCotisationDAO() {
		setCotisations(new ArrayList<Cotisation>());
	}

	public ArrayList<Cotisation> getCotisations() {
		return cotisations;
	}

	public void setCotisations(ArrayList<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}
	
	public static ArrayListCotisationDAO getInstance() {
		if (instance == null) {
			instance = new ArrayListCotisationDAO();
		}
		return instance;
	}

	@Override
	public Cotisation getById(int id) {
		Cotisation cotisation = new Cotisation(id, "", 0);
		int index = cotisations.indexOf(cotisation);
		cotisation = (index!=-1)?cotisations.get(index):null;
		return cotisation;
	}

	@Override
	public int create(Cotisation objet) {
		int id = 1;
		if(!cotisations.isEmpty()){
			id = (cotisations.get(cotisations.size()-1).getId()+1);
		}
		objet.setId(id);
		cotisations.add(objet);
		return id;
	}

	@Override
	public int update(Cotisation objet) {
		cotisations.set(cotisations.indexOf(objet), objet);
		return 0;
	}

	@Override
	public int delete(Cotisation objet) {
		cotisations.remove(objet);
		return 0;
	}

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
