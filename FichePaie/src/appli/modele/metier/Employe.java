package appli.modele.metier;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class metier, Employe <br>
 * Un employé: un nom, un prenom, une adresse,
 *  une liste de regles et de variable associé à une valeur
 * @author alexis
 * @version 1.0
 */
public class Employe {

		/**
		 * Identifiant de l'employe
		 */
        private int id;
        /**
         * Nom de l'employe
         */
        private String nom;
        /**
         * Prenom de l'employe
         */
        private String prenom;
        /**
         * Adresse de l'employe
         */
        private String adresse;
        /**
         * Liste des regles que possèdent un employé
         */
        private ArrayList<Regle> regles = null;
        /**
         * Tableau associatif variable/valeur que possède un employé
         */
        private HashMap<Variable, String> variables = null;

        /**
         * Constrcteur sans paramètre de {@link Employe}<br>
         * id -1, nom "", prenom "", adresse "", regles emptyList, variables emptyList
         */
        public Employe() {
                this(-1, "", "", "");
        }

        /**
         * Constructeur de {@link Employe}
         * @param nom Nom de l'employé
         * @param prenom prenom de l'employé
         * @param adresse adresse de l'employé
         */
        public Employe(String nom, String prenom, String adresse) {
                this(-1, nom, prenom, adresse);
        }

        /**
         * Constrcuteur de {@link Employe}
         * @param id Identifiant de l'employé
         * @param nom Nom de l'employé
         * @param prenom prenom de l'employé
         * @param adresse adresse de l'employé
         */
        public Employe(int id, String nom, String prenom, String adresse) {
                this(id, nom, prenom, adresse, new ArrayList<Regle>(), new HashMap<Variable, String>());
        }
        

        /**
         * Constrcuteur de {@link Employe}
         * @param id Identifiant de l'employé
         * @param nom Nom de l'employé
         * @param prenom prenom de l'employé
         * @param adresse adresse de l'employé
         * @param regles Regles que possèdent l'employé
         * @param possede Variable/valeur associé à l'employé
         */
        public Employe(int id, String nom, String prenom, String adresse,
				ArrayList<Regle> regles, HashMap<Variable, String> possede) {
        	this.setId(id);
            this.setNom(nom);
            this.setPrenom(prenom);
            this.setAdresse(adresse);
            this.setRegles(regles);
            this.setVariables(possede);
		}

        /**
         * {@link GetField}
         * @return
         */
		public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        /**
         * {@link GetField}
         * @return
         */
        public String getNom() {
                return nom;
        }

        public void setNom(String nom) {
                this.nom = nom;
        }

        /**
         * {@link GetField}
         * @return
         */
        public String getPrenom() {
                return prenom;
        }

        public void setPrenom(String prenom) {
                this.prenom = prenom;
        }

        /**
         * {@link GetField}
         * @return
         */
        public String getAdresse() {
                return adresse;
        }

        public void setAdresse(String adresse) {
                this.adresse = adresse;
        }

        /**
         * {@link GetField}
         * @return
         */
		public ArrayList<Regle> getRegles() {
			return regles;
		}

		public void setRegles(ArrayList<Regle> regles) {
			this.regles = regles;
		}

		 /**
         * {@link GetField}
         * @return
         */
		public HashMap<Variable, String> getVariables() {
			return variables;
		}

		public void setVariables(HashMap<Variable, String> possede) {
			this.variables = possede;
		}

		@Override
		public String toString() {
			/*return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom
					+ ", adresse=" + adresse + ", regles=" + regles
					+ ", possede=" + variables + "]";
		*/
			return nom+" "+prenom+" "+adresse;
		}
		
		@Override
		public boolean equals(Object o)
		{
			if (o instanceof Employe) {
				Employe emp = (Employe) o;
				if (emp.getId()==this.getId()) {
					return true;
				}
			}
			return false;
		}
}
