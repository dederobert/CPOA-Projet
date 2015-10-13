package appli.dao.arrayList;

import java.util.ArrayList;

import appli.dao.DAO;
import appli.dao.RegleDAO;
import appli.modele.metier.Regle;
/**
 * Class de gestion des sauvegarde des regles
 * <br /> persistance ArrayList
 * @author alexis
 * @version 1.0
 */
public class ArrayListRegleDAO implements RegleDAO{
	
	/**
	 * List des regles sauvegardée
	 */
	private ArrayList<Regle> regles = null;
	/**
	 * instance de {@link ArrayListRegleDAO}
	 * <b>Singleton</b>
	 */
	private static ArrayListRegleDAO instance = null;
	
	/**
	 * Constructeur de {@link ArrayListRegleDAO} <b>Singleton</b>
	 */
	private ArrayListRegleDAO() {
		setRegles(new ArrayList<Regle>());
		try{
			getRegles().add(new Regle(1, "brut < 2500", "secu = 2", true));
			getRegles().add(new Regle(2, "statu = 'cadre'", "secu = 7", false));
			getRegles().add(new Regle(3, "brut > 1500", "secu = 0.5", true));
		}catch(IllegalArgumentException e)
		{
			System.err.println("Problème d'initialisation de l'arrayList Regle");
		}
		
	}

	/**
	 * Permet d'obtenir une règle à partir d'un ID
	 * @param id Id de la règle à selectionner
	 * @return la règle correspondante à l'id <br> <code>null</code> si non trouvé
	 * @see DAO
	 */
	@Override
	public Regle getById(int id) {
		Regle regle = new Regle(id);
		int index = regles.indexOf(regle);
		regle = (index!=-1)?regles.get(index):null;
		return regle;
	}

	/**
	 * Permet de sauvegarder une règle
	 * @param objet Regle à sauvegarder
	 * @return id de la regle, 
	 * @see DAO
	 */
	@Override
	public int create(Regle objet) {
		int id = 1;
		if(!regles.isEmpty()){
			id = (regles.get(regles.size()-1).getId()+1);
		}
		objet.setId(id);
		regles.add(objet);		
		return id;
	}

	/**
	 * Permet de mettre à jour une regle
	 * @param objet regle à mettre à jour
	 * @return nb ligne mdifiée
	 * @see DAO
	 */
	@Override
	public int update(Regle objet) {
		regles.set(regles.indexOf(objet), objet);
		return 0;
	}

	/**
	 * Permet de supprimer une regle 
	 * @param objet regle à supprimer
	 * @return nb ligne supprimer
	 * @see DAO
	 */
	@Override
	public int delete(Regle objet) {
		regles.remove(objet);
		return 0;
	}

	/**
	 * Permet d'obtenir une instance de {@link ArrayListRegleDAO}
	 * <b>Singleton</b> 
	 * @return instance de {@link ArrayListRegleDAO}
	 */
	public static ArrayListRegleDAO getInstance() {
		if(instance==null)
		{
			instance = new ArrayListRegleDAO();
		}
		return instance;
	}

	/**
	 * Permet d'obtenir la liste des règles
	 * @return list des règles
	 */
	public ArrayList<Regle> getRegles() {
		return regles;
	}

	/**
	 * Permet de mettre à jour le list des regles
	 * @param regles list de regles
	 */
	public void setRegles(ArrayList<Regle> regles) {
		this.regles = regles;
	}

}
