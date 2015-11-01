package appli.vue;

import javax.swing.JPanel;

import appli.utils.Vue;

public interface IVue {

	public int getSelectedIndex();

	public void changeCentrePanel(JPanel panelDetails);

	public String getNomEmp();

	public String getPrenomEmp();

	public String getAdresseEmp();

	public void refresh();

	public String getTextRecherche();

	public void changeVue(Vue employe);

	Vue getVueActive();

	void setVueActive(Vue vueActive);

	public String getLibelle();

	public Double getTaux();


}
