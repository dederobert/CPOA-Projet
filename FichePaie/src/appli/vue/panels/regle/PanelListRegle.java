package appli.vue.panels.regle;

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
import appli.vue.panels.PanelList;

public class PanelListRegle extends JPanel implements PanelList {

	private static final long serialVersionUID = 333431897276404566L;
	private JList<String> list;
	DefaultListModel<String> listElement = new DefaultListModel<String>();
	JScrollPane listScroller;
	JTextField recherche;
	
	public PanelListRegle() {

		this.setLayout(new GridLayout(3,1));
		JPanel rechercher = new JPanel();
		recherche = new JTextField("Rechercher");
		recherche.setActionCommand("recherche");
		recherche.addActionListener(Fenetre.getControleur());
		rechercher.add(recherche);
		this.add(rechercher);
		
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
		ajoutButton.setActionCommand("showAddEmploye");
		ajoutButton.addActionListener(Fenetre.getControleur());
		buttons.add(ajoutButton);
		
		JButton modifierButton = new JButton("Modifier");
		modifierButton.setActionCommand("showModifierEmploye");
		modifierButton.addActionListener(Fenetre.getControleur());
		buttons.add(modifierButton);
		
		JButton supprimerButton = new JButton("Supprimer");
		supprimerButton.setActionCommand("supprimerEmploye");
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
		return recherche.getText().trim();
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
