package appli.modele.metier;

import appli.modele.services.RegleServices;


public class Regle {
	
	private int id;
	private String condition;
	private String action;
	private boolean actif;
	
	/**
	 * Constructeur de la class {@link Regle}
	 */
	public Regle(){
		this(-1,"","",false);
	}
	
	/**
	 * Constructeur de la class {@link Regle}
	 * Elle est principalement utiliser dans les <b>GetById</b><br />
	 * <i>N'est pas affecter par le test des champs action et condition </i>
	 * @param id Permet de definir un id
	 */
	public Regle(int id)
	{
		this.setId(id);
		this.condition = "";
		this.action = "";
		this.actif = false;
	}
	
	/**
	 * Constructeur de la class {@link Regle}
	 * avec des champs sans id
	 * @param condition Conditon de la regle
	 * @param action Action de la regle
	 * @param actif 
	 */
	public Regle(String condition, String action, boolean actif)
	{
		this(-1, condition, action, actif);
	}
	
	public Regle(int id, String condition, String action, boolean actif) {
		this.setId(id);
		this.setCondition(condition);
		this.setAction(action);
		this.setActif(actif);		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		if(!RegleServices.conditionIsValide(condition) || condition.trim().length() == 0)
		{
			throw new IllegalArgumentException("La condition entré n'est pas valide");
		}
		this.condition = condition;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		if(!RegleServices.actionIsValide(action) || action.trim().length() == 0)
		{
			throw new IllegalArgumentException("L'action entré n'est pas valide");
		}
		this.action = action;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	@Override
	public String toString() {
		return "Regle [id=" + id + ", condition=" + condition + ", action="
				+ action + ", actif=" + actif + "]";
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof Regle) {
			Regle rg = (Regle) o;
			if (rg.getId()==this.getId()) {
				return true;
			}
		}
		return false;
	}
}
