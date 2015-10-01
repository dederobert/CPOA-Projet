package appli.modele.metier;

public class Variable {

        private int id;
        private String libelle;

        public Variable() {
                this(-1, "");
        }

        public Variable(String libelle) {
                this(-1, libelle);
        }

        public Variable(int id, String libelle) {
                this.setId(id);
                this.setLibelle(libelle);
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

		@Override
		public String toString() {
			return "Variable [id=" + id + ", libelle=" + libelle + "]";
		}
        
		@Override
		public boolean equals(Object o)
		{
			if (o instanceof Variable) {
				Variable var = (Variable) o;
				if (var.getId()==this.getId()) {
					return true;
				}
			}
			return false;
		}

}
