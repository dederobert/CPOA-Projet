package appli.vue.panels;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import appli.manager.EmployeManager;
import appli.modele.metier.Employe;

public class PanelListEmploye extends JPanel{

	private static final long serialVersionUID = 1L;

	public PanelListEmploye() {
		this.add(new JTextField("Rechercher"));
		
		DefaultListModel<String> listEmploye = new DefaultListModel<String>();
		
		for(Employe employe:EmployeManager.getAllEmploye()){
			listEmploye.addElement(employe.toString());
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JList list = new JList(listEmploye);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		
		JScrollPane listScroller = new JScrollPane(list);
		this.add(listScroller);
	}

}
