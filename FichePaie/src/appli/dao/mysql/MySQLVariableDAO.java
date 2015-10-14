package appli.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appli.dao.VariableDAO;
import appli.modele.metier.Variable;

public class MySQLVariableDAO implements VariableDAO {

	private Connection connexion;
	private static MySQLVariableDAO instance = null;
	
	private  MySQLVariableDAO() {connexion = Connexion.creerConnexion();}
	
	@Override
	public Variable getById(int id) {
		PreparedStatement req = null;
		ResultSet res = null;
		Variable variable = null;

		try {
			req = this.connexion
					.prepareStatement("SELECT id_var,lib_var FROM VARIABLE WHERE id_var = ?");
			req.setInt(1, id);
			res = req.executeQuery();
			res.next();
			variable = new Variable(res.getInt(1), res.getString(2));
		
			
		} catch (SQLException sqle) {
			System.err.println("Erreur lors de l'execution de la requete : "
					+ sqle.getMessage());
		}
		return variable;
	}

	@Override
	public int create(Variable objet) {
		PreparedStatement req = null;
		ResultSet res = null;
		int key = -1;

		try {
			req = this.connexion.prepareStatement(
					"INSERT INTO VARIABLE (id_var, lib_var) VALUES (NULL, ?)",
					Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getLibelle());
			req.executeUpdate();
			res = req.getGeneratedKeys();
			res.next();
			key = res.getInt(1);
		} catch (SQLException sqle) {
			System.err.println("Erreur lors de l'execution de la requete : "
					+ sqle.getMessage());
		}
		objet.setId(key);
		return key;
	}

	@Override
	public int update(Variable objet) {
		PreparedStatement req = null;
		int nbligne = 0;

		try {
			req = this.connexion.prepareStatement(
					"UPDATE VARIABLE SET lib_var = ? WHERE id_var = ?",
					Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getLibelle());
			req.setInt(2, objet.getId());
			nbligne = req.executeUpdate();
		} catch (SQLException sqle) {
			System.err.println("Erreur lors de l'execution de la requete : "
					+ sqle.getMessage());
		}
		return nbligne;
	}

	@Override
	public int delete(Variable objet) {
		PreparedStatement req = null;
		int nbligne = 0;

		try {
			req = this.connexion.prepareStatement(
					"DELETE FROM VARIABLE WHERE id_var = ?",
					Statement.RETURN_GENERATED_KEYS);
			req.setInt(1, objet.getId());
			nbligne = req.executeUpdate();
		} catch (SQLException sqle) {
			System.err.println("Erreur lors de l'execution de la requete : "
					+ sqle.getMessage());
		}
		return nbligne;
	}

	@Override
	public Variable getByLibelle(String libelle) {
		PreparedStatement req = null;
		ResultSet res = null;
		Variable variable = null;

		try {
			req = this.connexion
					.prepareStatement("SELECT id_var,lib_var FROM VARIABLE WHERE lib_var = ?");
			req.setString(1, libelle);
			res = req.executeQuery();
			res.next();
			variable = new Variable(res.getInt(1), res.getString(2));
		} catch (SQLException sqle) {
			System.err.println("Erreur lors de l'execution de la requete : "
					+ sqle.getMessage());
		}
		return variable;
	}

	public static MySQLVariableDAO getInstance() {
		if (instance == null)
		{
			instance = new MySQLVariableDAO();
		}
		return instance;
	}
}