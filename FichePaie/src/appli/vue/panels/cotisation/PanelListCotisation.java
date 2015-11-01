package appli.vue.panels.cotisation;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import appli.vue.Fenetre;
import appli.vue.panels.PanelList;

public class PanelListCotisation extends JPanel implements PanelList {

	private static final long serialVersionUID = 6081117319022909047L;
	private JList<String> list;
	DefaultListModel<String> listElement = new DefaultListModel<String>();
	JScrollPane listScroller;
	
	public PanelListCotisation() {
		this.setLayout(new GridLayout(2,1));
		
		ArrayList<String> listString = Fenetre.getControleur().getList();
		for(String chaine: listString)
		{
			listElement.addElement(chaine);
		}
		
		list = new JList<String>(listElement);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.addListSelectionListener(Fenetre.getControleur());
		
		listScroller = new JScrollPane(list);
		this.add(listScroller);
		
		
		JPanel buttons = new JPanel();
		//buttons.setLayout(new GridLayout(1,3));
		
		
		JButton ajoutButton = new JButton("Ajouter");
		ajoutButton.setActionCommand("showAddCotisation");
		ajoutButton.addActionListener(Fenetre.getControleur());
		buttons.add(ajoutButton);
		
		JButton modifierButton = new JButton("Modifier");
		modifierButton.setActionCommand("showModifierCotisation");
		modifierButton.addActionListener(Fenetre.getControleur());
		buttons.add(modifierButton);
		
		JButton supprimerButton = new JButton("Supprimer");
		supprimerButton.setActionCommand("supprimerCotisation");
		supprimerButton.addActionListener(Fenetre.getControleur());
		buttons.add(supprimerButton);
		
		this.add(buttons);
	}

	@Override
	public int getSelectedIndex() {
		return list.getSelectedIndex();
	}

	@Override
	public String getTextRecherche() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh() {
		ArrayList<String> listString = Fenetre.getControleur().getList();
		listElement.clear();
		for(String chaine: listString)
		{
			listElement.addElement(chaine);
		}
		list.setModel(listElement);
		listScroller.setViewportView(list);
		this.validate();

	}

}
