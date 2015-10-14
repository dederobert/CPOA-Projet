package appli.modele.services;

import appli.dao.factory.DAOFactory;
import appli.modele.metier.Cotisation;
import appli.modele.metier.Variable;
import appli.utils.Utilitaire;

/**
 * Class pour les traitements sur les règles
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
	 *            Règle dont l'action est à vérifier
	 * @return vraie si l'action est valide
	 * @throws IllegalArgumentException
	 */
	public static boolean actionIsValide(String action) throws IllegalArgumentException{
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
						throw new IllegalArgumentException("Vous n'avez pas entré un taux valide");
					}
				}else{
					throw new IllegalArgumentException("Vous devez utiliser un = ");
				}
			}else
			{
				throw new IllegalArgumentException("La cotisation renseigné est inexistante");
			}

		}else
		{
			throw new IllegalArgumentException("Le nombre d'argument est invalide");
		}
	}

	/**
	 * Fonction qui vérifie la condition d'une règle
	 * 
	 * @param regle
	 *            Règle dont la condition est à vérifier
	 * @return Vraie si la condition est valide
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unused")
	public static boolean conditionIsValide(String condition) throws IllegalArgumentException{
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
						if ((champs[i + 2].startsWith("'") && champs[i + 2]
								.endsWith("'")) || Utilitaire.isInteger(champs[i + 2])) {
							return true;
						}else
						{
							throw new IllegalArgumentException("Le format du champs " + champs[i+2] + " est invalide");
						}
					}else
					{
						throw new IllegalArgumentException("Le connecteur " + champs[i+1] + " est invalide !");
					}
				}else
				{
					throw new IllegalArgumentException("La variable " + champs[i] + " n'existe pas !");
				}
			}
		}else
		{
			throw new IllegalArgumentException("Le nombre de champs ne correspond pas");
		}

		return false;
	}

	/**
	 * Permet de découper une condition
	 * 
	 * @param condition
	 *            Condition à découper
	 * @return Un tableau des mots constituant une condition
	 */
	private static String[] decoupeCondition(String condition) {
		String[] decoupage = condition.split(" ET |\\ et |\\ OU |\\ ou |\\ ");
		return decoupage;
	}


}
