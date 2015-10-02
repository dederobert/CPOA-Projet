package appli.modele.services;

import appli.dao.factory.DAOFactory;
import appli.modele.metier.Cotisation;
import appli.modele.metier.Variable;
import appli.utils.Utilitaire;

/**
 * Class pour les traitements sur les r�gles
 * 
 * @author alexis
 * @version 1.1
 */
public class RegleServices {

	/**
	 * Verifie que le parametre action est une action valide <i> Cotisation =
	 * taux </i>
	 * 
	 * @param regle
	 *            R�gle dont l'action est � v�rifier
	 * @return vraie si l'action est valide
	 * @throws Exception 
	 */
	public static boolean actionIsValide(String action) {
		String[] champs = action.split(" ");
		DAOFactory daof = Utilitaire.getFactory();
		Cotisation cotisation = daof.getCotisationDAO().getByLibelle(champs[0]);

		if (champs.length == 3) {
			if (cotisation != null) {
				if (champs[1].equals("=")) {
					if(Utilitaire.isDouble(champs[2]))
					{
						return true;
					}else
					{
						System.err.println("Vous n'avez pas entr� un taux valide");
					}
				}else{
					System.err.println("Vous devez utiliser un = ");
				}
			}else
			{
				System.err.println("La cotisation renseign� est inexistante");
			}

		}else
		{
			System.err.println("Le nombre d'argument est invalide");
		}
		
		return false;
	}

	/**
	 * Fonction qui v�rifie la condition d'une r�gle
	 * 
	 * @param regle
	 *            R�gle dont la condition est � v�rifier
	 * @return Vraie si la condition est valide
	 */
	public static boolean conditionIsValide(String condition) {
		String[] champs = decoupeCondition(condition);
		DAOFactory daoF = Utilitaire.getFactory();

		if (champs.length % 3 == 0) {
			for (int i = 0; i < champs.length; i += 3) {
				Variable variable = daoF.getVariableDAO().getByLibelle(
						champs[i]);
				if (variable != null) {
					if (champs[i + 1].equals("<") || champs[i + 1].equals("<=")
							|| champs[i + 1].equals("=") || champs[i + 1].equals(">=")
							|| champs[i + 1].equals(">") || champs[i + 1].equals("!=")) {
						if ((champs[i + 2].startsWith("\"") && champs[i + 2]
								.endsWith("\"")) || Utilitaire.isInteger(champs[i + 2])) {
							return true;
						}else
						{
							System.err.println("Le format du champs " + champs[i+2] + " est invalide");
						}
					}else
					{
						System.err.println("Le connecteur " + champs[i+1] + " est invalide !");
					}
				}else
				{
					System.err.println("La variable " + champs[i] + "n'existe pas !");
				}
			}
		}else
		{
			System.err.println("Le nombre de champs ne correspond pas");
		}

		return false;
	}

	/**
	 * Permet de d�couper une condition
	 * 
	 * @param condition
	 *            Condition � d�couper
	 * @return Un tableau des mots constituant une condition
	 */
	private static String[] decoupeCondition(String condition) {
		String[] decoupage = condition.split(" ET |\\ et |\\ OU |\\ ou |\\ ");
		return decoupage;
	}


}
