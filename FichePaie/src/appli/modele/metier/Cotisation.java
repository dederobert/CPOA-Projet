package appli.modele.metier;

import java.io.ObjectInputStream.GetField;


/**
 * Class metier, cotisation <br />
 * Une cotisation est constituer d'un libelle et d'un taux
 * @author alexis
 * @version 1.0
 */
public class Cotisation {

		/**
		 * Identifiant de la cotisation
		 */
        private int id;
        /**
         * Libellé de la cotisation
         */
        private String libelle;
        /**
         * Taux de la cotisation
         */
        private double taux;

        /**
         * Constructeur de la class {@link Cotisation} <br />
         * id = -1, libelle vide, taux = -1
         */
        public Cotisation(){
                this(-1,"",-1);
        }
        
        /**
         * Constructeur de la class {@link Cotisation} <br />
         * id = -1
         * @param libelle libelle de la cotisation
         * @param taux taux de la cotisation
         */
        public Cotisation(String libelle, double taux){
                this(-1,libelle,taux);
        }
        
        /**
         * Constructeur de la class {@link Cotisation}
         * @param id Identifiant de la cotisation
         * @param libelle libelle de la cotisation
         * @param taux taux de la cotisation
         */
        public Cotisation(int id, String libelle, double taux) {
                this.setId(id);
                this.setLibelle(libelle);
                this.setTaux(taux);
        }

        /**
         * Permet d'otenir l'identifiant de la cotisation {@link GetField}
         * @return Identifiant de la cotisation
         */
        public int getId() {
                return id;
        }

        /**
         * Permet de definir l'identifiant de la cotisation
         * @param id nouvel identifiant
         */
        public void setId(int id) {
                this.id = id;
        }

        /**
         * Permet d'otenir le libelle de la cotisation {@link GetField}
         * @return libelle de la cotisation
         */
        public String getLibelle() {
                return libelle;
        }

        /**
         * Permet de definir le libelle de la cotisation
         * @param libelle nouveau libelle de la cotisation
         */
        public void setLibelle(String libelle) {
                this.libelle = libelle;
        }

        /**
         * Permet d'otenir le taux de la cotisation {@link GetField}
         * @return taux de la cotisation
         */
        public double getTaux() {
                return taux;
        }

        /**
         * Permet de definir le taux de la cotisation
         * @param taux nouveau taux de la cotisation
         */
        public void setTaux(double taux) {
                this.taux = taux;
        }

        /**
         * Revoie la cotisation sous forme d'une chaine <br>
         * Methode toString
         * @return cotisation sous forme de chaine
         */
		@Override
		public String toString() {
			/*return "Cotisation [id=" + id + ", libelle=" + libelle + ", taux="
					+ taux + "]";*/
			return libelle + " " + taux;
		}
        
		/**
		 * Test si 2 cotisation sont egaux <br>
		 * Verifie si elle possède le même id
		 * @retur vrai si elles ont le même id
		 */
		@Override
		public boolean equals(Object o)
		{
			if (o instanceof Cotisation) {
				Cotisation cot = (Cotisation) o;
				if (cot.getId()==this.getId()) {
					return true;
				}
			}
			return false;
		}
}