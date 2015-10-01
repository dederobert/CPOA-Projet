package principal.dao.arrayList;

import java.util.ArrayList;

import principal.dao.RegleDAO;
import principal.modele.metier.Regle;

public class ArrayListRegleDAO implements RegleDAO{
	
	private ArrayList<Regle> regles = null;
	private static ArrayListRegleDAO instance = null;
	
	private ArrayListRegleDAO() {
		setRegles(new ArrayList<Regle>());
	}

	@Override
	public Regle getById(int id) {
		Regle regle = new Regle(id, "", "", false);
		int index = regles.indexOf(regle);
		regle = (index!=-1)?regles.get(index):null;
		return regle;
	}

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

	@Override
	public int update(Regle objet) {
		regles.set(regles.indexOf(objet), objet);
		return 0;
	}

	@Override
	public int delete(Regle objet) {
		regles.remove(objet);
		return 0;
	}


	public static ArrayListRegleDAO getInstance() {
		if(instance==null)
		{
			instance = new ArrayListRegleDAO();
		}
		return instance;
	}

	public ArrayList<Regle> getRegles() {
		return regles;
	}

	public void setRegles(ArrayList<Regle> regles) {
		this.regles = regles;
	}

}
