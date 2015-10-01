package appli.modele.metier;

public class Cotisation {

        private int id;
        private String libelle;
        private double taux;

        public Cotisation(){
                this(-1,"",-1);
        }
        
        public Cotisation(String lib, double taux){
                this(-1,lib,taux);
        }
        
        public Cotisation(int id, String libelle, double taux) {
                this.setId(id);
                this.setLibelle(libelle);
                this.setTaux(taux);
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getLibelle() {
                return libelle;
        }

        public void setLibelle(String libelle) {
                this.libelle = libelle;
        }

        public double getTaux() {
                return taux;
        }

        public void setTaux(double taux) {
                this.taux = taux;
        }

		@Override
		public String toString() {
			return "Cotisation [id=" + id + ", libelle=" + libelle + ", taux="
					+ taux + "]";
		}
        
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