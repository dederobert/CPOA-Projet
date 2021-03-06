package appli.modele.metier;

import appli.modele.services.RegleServices;


public class Regle {
	
	private int id;
	private String condition;
	private String action;
	private boolean actif;
	
	/**
	 * Constructeur de la class {@link Regle}
	 * <br>N'opp�re pas de v�rification sur les champs
	 * <br> id=-1 condition="", action="", actif=<code>false</code>
	 */
	public Regle(){
		this.id = -1;
		this.condition = "";
		this.action = "";
		this.actif = false;
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
	 * <br>id = -1
	 * @param condition Conditon de la regle
	 * @param action Action de la regle
	 * @param actif 
	 */
	public Regle(String condition, String action, boolean actif)
	{
		this(-1, condition, action, actif);
	}
	
	/**
	 * Constructeur de la class {@link Regle}
	 * @param id identifiant de la regle
	 * @param condition Conditon de la regle
	 * @param action Action de la regle
	 * @param actif 
	 */
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
	
	/**
	 * Definie la condition<br>
	 * Utilise la class {@link RegleServices} pour verifier la validit� de la condition
	 * @see RegleServices
	 * @param condition condition � definir
	 * @throws IllegalArgumentException
	 */
	public void setCondition(String condition) {
		if(!RegleServices.conditionIsValide(condition) || condition.trim().length() == 0)
		{
			throw new IllegalArgumentException("La condition entr� n'est pas valide");
		}
		this.condition = condition;
	}
	public String getAction() {
		return action;
	}
	
	/**
	 * Definie l'action<br>
	 * Utilise la class {@link RegleServices} pour verifier la validit� de l'action
	 * @see RegleServices
	 * @param action
	 * @throws IllegalArgumentException
	 */
	public void setAction(String action) {
		if(!RegleServices.actionIsValide(action) || action.trim().length() == 0)
		{
			throw new IllegalArgumentException("L'action entr� n'est pas valide");
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
