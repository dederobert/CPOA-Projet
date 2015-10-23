package appli.vue.panels;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelFichePaie extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private  JLabel identite = new JLabel();
	private  JTable tab = null;
	private  String[][] data = new String[1][5];
	private  final String[] cols = {"Element", "Libelle", "Base", "Tx. Salarié", "Mt. Salarié"};
	private  JScrollPane sp = null;
	
	public PanelFichePaie() {
		
		this.setLayout(new GridLayout(4, 1));
		
		JLabel titre = new JLabel("Bulletin de Paie");
		setTab(new JTable(data, cols));
		setSp(new JScrollPane(getTab()));
		
		this.add(titre);
		this.add(identite);
		this.add(getSp());
	}

	public  JLabel getNom() {
		return identite;
	}

	public void setIdentite(String identite) {
		this.identite.setText(identite);
	}

	public  JTable getTab() {
		return tab;
	}

	public  void setTab(JTable tab) {
		this.tab = tab;
	}
	
	public  void addElementTab(String[] row)
	{
		String[][] temp = data;
		data = new String[temp.length+1][5];
		for (int i = 0; i < temp.length; i++) {
			data[i][0] = temp[i][0];
			data[i][1] = temp[i][1];
			data[i][2] = temp[i][2];
			data[i][3] = temp[i][3];
			data[i][4] = temp[i][4];
		}
		data[temp.length][0] = row[0];
		data[temp.length][1] = row[1];
		data[temp.length][2] = row[2];
		data[temp.length][3] = row[3];
		data[temp.length][4] = row[4];
		
		setTab(new JTable(data, cols));
		setSp(new JScrollPane(getTab()));
	}

	public void setTable(String[][] data)
	{
		setTab(new JTable(data, cols));
		setSp(new JScrollPane(getTab()));
	}
	
	public JScrollPane getSp() {
		return sp;
	}

	public  void setSp(JScrollPane sp) {
		this.sp = sp;
	}
	
	public void refresh(){
		this.validate();
	}
	
	

}
