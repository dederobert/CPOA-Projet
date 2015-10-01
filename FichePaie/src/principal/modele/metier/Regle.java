package principal.modele.metier;

public class Regle {
	
	private int id;
	private String condition;
	private String action;
	private boolean actif;
	
	public Regle(){
		this(-1,"","",false);
	}
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
		this.condition = condition;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
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
