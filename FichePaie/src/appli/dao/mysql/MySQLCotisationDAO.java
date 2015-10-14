package appli.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appli.dao.CotisationDAO;
import appli.modele.metier.Cotisation;

public class MySQLCotisationDAO implements CotisationDAO {

        private Connection connexion;
        private static MySQLCotisationDAO instance = null;

        private MySQLCotisationDAO() {connexion = Connexion.creerConnexion();}
        
        @Override
        public Cotisation getById(int id) {
                PreparedStatement req = null;
                ResultSet res = null;
                Cotisation cotisation = null;

                try {
                        req = this.connexion
                                        .prepareStatement("SELECT id_coti,lib_coti,taux_coti FROM COTISATION WHERE id_coti = ?");
                        req.setInt(1, id);
                        res = req.executeQuery();
                        res.next();
                        cotisation = new Cotisation(res.getInt(1), res.getString(2),
                                        res.getDouble(3));
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Erreur lors de l'execution de la requete : "
                                        + sqle.getMessage());
                }
                return cotisation;
        }

        @Override
        public int create(Cotisation objet) {
                PreparedStatement req = null;
                ResultSet res = null;
                int key = -1;

                try {
                        req = this.connexion
                                        .prepareStatement(
                                                        "INSERT INTO COTISATION (id_coti, lib_coti, taux_coti) VALUES (NULL, ?, ?)",
                                                        Statement.RETURN_GENERATED_KEYS);
                        req.setString(1, objet.getLibelle());
                        req.setDouble(2, objet.getTaux());
                        req.executeUpdate();
                        res = req.getGeneratedKeys();
                        res.next();
                        key = res.getInt(1);
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Erreur lors de l'execution de la requete : "
                                        + sqle.getMessage());
                }
                objet.setId(key);
                return key;
        }

        @Override
        public int update(Cotisation objet) {
                PreparedStatement req = null;
                int nbligne = 0;

                try {
                        req = this.connexion
                                        .prepareStatement(
                                                        "UPDATE COTISATION SET lib_coti = ?, taux_coti = ? WHERE id_coti = ?",
                                                        Statement.RETURN_GENERATED_KEYS);
                        req.setString(1, objet.getLibelle());
                        req.setDouble(2, objet.getTaux());
                        req.setInt(3, objet.getId());
                        nbligne = req.executeUpdate();
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Erreur lors de l'execution de la requete : "
                                        + sqle.getMessage());
                }
                return nbligne;
        }

        @Override
        public int delete(Cotisation objet) {
                PreparedStatement req = null;
                int nbligne = 0;

                try {
                        req = this.connexion
                                        .prepareStatement(
                                                        "DELETE FROM COTISATION WHERE id_coti = ?",
                                                        Statement.RETURN_GENERATED_KEYS);
                        req.setInt(1, objet.getId());
                        nbligne = req.executeUpdate();
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Erreur lors de l'execution de la requete : "
                                        + sqle.getMessage());
                }
                return nbligne;
        }

        @Override
        public Cotisation getByLibelle(String libelle) {
                PreparedStatement req = null;
                ResultSet res = null;
                Cotisation cotisation = null;

                try {
                        req = this.connexion
                                        .prepareStatement("SELECT id_coti,lib_coti,taux_coti FROM COTISATION WHERE lib_coti = ?");
                        req.setString(1, libelle);
                        res = req.executeQuery();
                        res.next();
                        cotisation = new Cotisation(res.getInt(1), res.getString(2),
                                        res.getDouble(3));
                } catch (SQLException sqle) {
                        System.err.println(this.getClass() + " Erreur lors de l'execution de la requete : "
                                        + sqle.getMessage());
                }
                return cotisation;
        }

		public static MySQLCotisationDAO getInstance() {
			if(instance == null)
			{
				instance = new MySQLCotisationDAO();
			}
			return instance;
		}

}
