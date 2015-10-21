package appli.vue;

import javax.swing.JPanel;

public interface IVue {

	public int getSelectedIndex();

	public void changeCentrePanel(JPanel panelDetails);

	public String getNomEmp();

	public String getPrenomEmp();

	public String getAdresseEmp();


}
