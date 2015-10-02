package appli.modele.services;

import appli.dao.factory.DAOFactory;
import appli.modele.metier.Cotisation;
import appli.modele.metier.Variable;
import appli.utils.Utilitaire;

/**
 * Class pour les traitements sur les règles
 * 
 * @author alexis
 * @version 1.0
 */
public class RegleServices {

	/**
	 * Verifie que le parametre action est une action valide <i> Cotisation =
	 * taux </i>
	 * 
	 * @param regle
	 *            Règle dont l'action est à vérifier
	 * @return vraie si l'action est valide
	 */
	public static boolean actionIsValide(String action) {
		String[] champs = action.split(" ");
		DAOFactory daof = Utilitaire.getFactory();
		Cotisation cotisation = daof.getCotisationDAO().getByLibelle(champs[0]);

		if (champs.length == 3) {
			if (cotisation != null) {
				if (champs[1].equals("=")) {
					try {
						Double.parseDouble(champs[3]);
						return true;
					} catch (NumberFormatException exception) {
					}
				}
			}

		}
		return false;
	}

	/**
	 * Fonction qui vérifie la condition d'une règle
	 * 
	 * @param regle
	 *            Règle dont la condition est à vérifier
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
					if (champs[i + 1] == "<" || champs[i + 1] == "<="
							|| champs[i + 1] == "=" || champs[i + 1] == ">="
							|| champs[i + 1] == ">" || champs[i + 1] == "!=") {
						if ((champs[i + 2].startsWith("\"") && champs[i + 2]
								.endsWith("\"")) || isInteger(champs[i + 2])) {
							return true;
						}
					}
				}
			}
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

	private static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException exception) {
			return false;
		}

		return true;
	}

}
