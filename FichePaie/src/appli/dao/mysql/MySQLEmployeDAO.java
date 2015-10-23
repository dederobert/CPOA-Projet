package appli.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import appli.dao.EmployeDAO;
import appli.modele.metier.Employe;
import appli.modele.metier.Regle;
import appli.modele.metier.Variable;

public class MySQLEmployeDAO implements EmployeDAO {

        Connection connexion = null;
        private static MySQLEmployeDAO instance = null;

        private MySQLEmployeDAO() {
                connexion = Connexion.creerConnexion();
        }

        @Override
        public Employe getById(int id) {
                PreparedStatement req = null;
                ResultSet res = null;
                Employe employe = null;
                try {
                        req = this.connexion
                                        .prepareStatement("SELECT id_emp, nom_emp, prenom_emp, ad_emp"
                                                        + " FROM EMPLOYE " + " WHERE id_emp = ?");
                        req.setInt(1, id);
                        res = req.executeQuery();
                        res.next();
                        employe = new Employe(res.getInt(1), res.getString(2),
                                        res.getString(3), res.getString(4));
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Impossible de selectionner l'employe :"
                                        + sqle.getMessage());
                }
                return employe;
        }

        @Override
        public int create(Employe objet) {
                PreparedStatement req = null;
                ResultSet res = null;
                int key = -1;
                try {
                        req = this.connexion.prepareStatement("INSERT INTO EMPLOYE"
                                        + " (id_emp, nom_emp, prenom_emp, ad_emp)"
                                        + " VALUES (NULL, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                        req.setString(1, objet.getNom());
                        req.setString(2, objet.getPrenom());
                        req.setString(3, objet.getAdresse());
                        req.executeUpdate();
                        res = req.getGeneratedKeys();
                        res.next();
                        key = res.getInt(1);
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Impossible de creer l'employe :"
                                        + sqle.getMessage());
                }
                objet.setId(key);
                return key;
        }

        @Override
        public int update(Employe objet) {
                PreparedStatement req = null;
                int nbLigne = 0;
                try {
                        req = this.connexion.prepareStatement("UPDATE EMPLOYE"
                                        + " SET nom_emp = ?, prenom_emp = ?, ad_emp = ? "
                                        + " WHERE id_emp = ?");
                        req.setString(1, objet.getNom());
                        req.setString(2, objet.getPrenom());
                        req.setString(3, objet.getAdresse());
                        req.setInt(4, objet.getId());
                        nbLigne = req.executeUpdate();
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Impossible de mettre a jour l'employe :"
                                        + sqle.getMessage());
                }
                return nbLigne;
        }

        @Override
        public int delete(Employe objet) {
                PreparedStatement req = null;
                int nbLine = 0;
                try {
                        req = this.connexion.prepareStatement("DELETE FROM EMPLOYE "
                                        + "WHERE id_emp = ?");
                        req.setInt(1, objet.getId());
                        nbLine = req.executeUpdate();
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Imossible de supprimer l'employe :"
                                        + sqle.getMessage());
                }
                return nbLine;
        }

        @Override
        public Employe getByNom(String nom) {
                PreparedStatement req = null;
                ResultSet res = null;
                Employe employe = null;
                try {
                        req = this.connexion
                                        .prepareStatement("SELECT id_emp, nom_emp, prenom_emp, ad_emp"
                                                        + " FROM EMPLOYE "
                                                        + " WHERE nom_emp = ?");
                        req.setString(1, nom);
                        res = req.executeQuery();
                        res.next();
                        employe = new Employe(res.getInt(1), res.getString(2),
                                        res.getString(3), res.getString(4));
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Impossible de selectionner l'employe :"
                                        + sqle.getMessage());
                }
                return employe;
        }

        @Override
        public ArrayList<Regle> getRegles(Employe employe) {
                PreparedStatement req = null;
                ResultSet res = null;
                ArrayList<Regle> regles = new ArrayList<Regle>();
                try {
                        req = this.connexion
                                        .prepareStatement("SELECT EMP_REGLE.id_regle, `condition`, action, actif"
                                                        + " FROM EMP_REGLE LEFT JOIN REGLE"
                                                        + " ON EMP_REGLE.id_regle = REGLE.id_regle"
                                                        + " WHERE id_emp = ?");
                        req.setInt(1, employe.getId());
                        res = req.executeQuery();
                        while (res.next()) {
                                regles.add(new Regle(res.getInt(1), res.getString(2), res
                                                .getString(3), res.getBoolean(4)));
                        }
                        employe.setRegles(regles);
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Impossible de selectioner les regles : "
                                        + sqle.getMessage());
                }
                return employe.getRegles();
        }

        @Override
        public HashMap<Variable, String> getVariables(Employe employe) {
                PreparedStatement req = null;
                ResultSet res = null;
                HashMap<Variable, String> vars = new HashMap<Variable, String>();
                try {
                        req = this.connexion
                                        .prepareStatement("SELECT POSSEDE.id_var, lib_var, valeur"
                                                        + " FROM POSSEDE LEFT JOIN VARIABLE"
                                                        + " ON POSSEDE.id_var = VARIABLE.id_var"
                                                        + " WHERE id_emp = ?");
                        req.setInt(1, employe.getId());
                        res = req.executeQuery();
                        while (res.next()) {
                                vars.put(new Variable(res.getInt(1), res.getString(2)),
                                                res.getString(3));
                        }

                        employe.setVariables(vars);
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Impossible de selectioner les variables : "
                                        + sqle.getMessage());
                }

                return employe.getVariables();
        }

        public static MySQLEmployeDAO getInstance() {
                if (instance == null) {
                        instance = new MySQLEmployeDAO();
                }
                return instance;
        }

        @Override
        public void addRegle(Employe employe, Regle regle) {
                PreparedStatement requete = null;
                try{
                        requete = connexion.prepareStatement("INSERT INTO EMP_REGLE VALUES (?,?)");
                        requete.setInt(1, employe.getId());
                        requete.setInt(2, regle.getId());
                        requete.executeUpdate();
                }catch(SQLException sqle)
                {
                        System.err.println(this.getClass() + " Impossible d'ajouter la regle : "+sqle.getMessage());
                }
                employe.getRegles().add(regle);                
        }

        @Override
        public void addVariable(Employe employe, Variable variable, String valeur) {
                PreparedStatement requete = null;
                try{
                        requete = connexion.prepareStatement("INSERT INTO POSSEDE VALUES (?,?,?)");
                        requete.setInt(1, employe.getId());
                        requete.setInt(2, variable.getId());
                        requete.setString(3, valeur);
                        requete.executeUpdate();
                }catch(SQLException sqle)
                {
                        System.err.println(this.getClass() + " Impossible d'ajouter la variable : "+sqle.getMessage());
                }
                employe.getVariables().put(variable, valeur);        
                
        }

        @Override
        public void removeRegle(Employe employe, Regle regle) {
                PreparedStatement requete = null;
                try{
                        requete = connexion.prepareStatement("DELETE FROM EMP_REGLE WHERE id_emp = ? AND id_regle = ?");
                        requete.setInt(1, employe.getId());
                        requete.setInt(2, regle.getId());
                        requete.executeUpdate();
                }catch(SQLException sqle)
                {
                        System.err.println(this.getClass() + " Impossible de retirer la regle : "+sqle.getMessage());
                }
                employe.getRegles().remove(regle);
                
        }

        @Override
        public void removeVariable(Employe employe, Variable variable, String valeur) {
                PreparedStatement requete = null;
                try{
                        requete = connexion.prepareStatement("DELETE FROM POSSEDE WHERE id_emp = ? AND id_var = ?");
                        requete.setInt(1, employe.getId());
                        requete.setInt(2, variable.getId());
                        requete.executeUpdate();
                }catch(SQLException sqle)
                {
                        System.err.println(this.getClass() + " Impossible de retirer la variable : "+sqle.getMessage());
                }
                employe.getVariables().remove(variable);
                
        }

		@Override
		public ArrayList<Employe> getAllEmploye() {
			ArrayList<Employe> employes = new ArrayList<Employe>();
			PreparedStatement requete = null;
			ResultSet resultat = null;
			try{
				requete = connexion.prepareStatement("SELECT id_emp, nom_emp, prenom_emp, ad_emp FROM EMPLOYE order by nom_emp");
				resultat = requete.executeQuery();
				while(resultat.next()){
					Employe employe = new Employe(resultat.getInt(1),resultat.getString(2),resultat.getString(3),resultat.getString(4));
					employe.setRegles(this.getRegles(employe));
					employe.setVariables(this.getVariables(employe));
					employes.add(employe);
					}
			}
			catch(SQLException sqle){
				 System.err.println(this.getClass() + " Impossible d'obtenir tous les Employés : "+sqle.getMessage());
			}
			return employes;
		}

}
