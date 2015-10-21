package appli.vue.panels;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import appli.vue.Fenetre;

public class PanelList extends JPanel{

	private static final long serialVersionUID = 1L;
	private JList<String> list;

	public PanelList() {
		
		this.setLayout(new GridLayout(3,1));
		JPanel rechercher = new JPanel();
		rechercher.add(new JTextField("Rechercher"));
		this.add(rechercher);
		
		DefaultListModel<String> listElement = new DefaultListModel<String>();
		
		ArrayList<String> listString = Fenetre.getControleur().getList();
		for(String chaine: listString)
		{
			listElement.addElement(chaine);
		}
	
		list = new JList<String>(listElement);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.addListSelectionListener(Fenetre.getControleur());
		
		JScrollPane listScroller = new JScrollPane(list);
		this.add(listScroller);
		
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,3));
		JButton ajoutButton = new JButton("Ajouter");
		ajoutButton.setActionCommand("showAddEmploye");
		ajoutButton.addActionListener(Fenetre.getControleur());
		buttons.add(ajoutButton);
		buttons.add(new JButton("Modifier"));
		buttons.add(new JButton("Supprimer"));
		this.add(buttons);
	}

	

	public int getSelectedIndex() {
		return list.getSelectedIndex();
	}
}
