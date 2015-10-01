package principal.modele.metier;

import java.util.ArrayList;
import java.util.HashMap;

public class Employe {

        private int id;
        private String nom;
        private String prenom;
        private String adresse;
        private ArrayList<Regle> regles = null;
        private HashMap<Variable, String> variables = null;

        public Employe() {
                this(-1, "", "", "");
        }

        public Employe(String nom, String prenom, String adresse) {
                this(-1, nom, prenom, adresse);
        }

        public Employe(int id, String nom, String prenom, String adresse) {
                this(id, nom, prenom, adresse, new ArrayList<Regle>(), new HashMap<Variable, String>());
        }
        

        public Employe(int id, String nom, String prenom, String adresse,
				ArrayList<Regle> regles, HashMap<Variable, String> possede) {
        	this.setId(id);
            this.setNom(nom);
            this.setPrenom(prenom);
            this.setAdresse(adresse);
            this.setRegles(regles);
            this.setVariables(possede);
		}

		public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getNom() {
                return nom;
        }

        public void setNom(String nom) {
                this.nom = nom;
        }

        public String getPrenom() {
                return prenom;
        }

        public void setPrenom(String prenom) {
                this.prenom = prenom;
        }

        public String getAdresse() {
                return adresse;
        }

        public void setAdresse(String adresse) {
                this.adresse = adresse;
        }

		public ArrayList<Regle> getRegles() {
			return regles;
		}

		public void setRegles(ArrayList<Regle> regles) {
			this.regles = regles;
		}

		public HashMap<Variable, String> getVariables() {
			return variables;
		}

		public void setVariables(HashMap<Variable, String> possede) {
			this.variables = possede;
		}

		@Override
		public String toString() {
			return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom
					+ ", adresse=" + adresse + ", regles=" + regles
					+ ", possede=" + variables + "]";
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
