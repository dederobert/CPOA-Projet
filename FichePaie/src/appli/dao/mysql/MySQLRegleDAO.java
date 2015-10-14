package appli.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import appli.dao.RegleDAO;
import appli.modele.metier.Regle;

public class MySQLRegleDAO implements RegleDAO {

	private Connection connexion;
	private static MySQLRegleDAO instance = null;
	
	private MySQLRegleDAO() {connexion = Connexion.creerConnexion();}
	
	@Override
	public Regle getById(int id) {
		PreparedStatement req = null;
		ResultSet res = null;
		Regle regle = null;

		try {
			req = this.connexion
					.prepareStatement("SELECT id_regle, `condition`, action, actif "
							+ "FROM REGLE " + "WHERE id_regle = ?");
			req.setInt(1, id);
			res = req.executeQuery();
			res.next();
			regle = new Regle(res.getInt(1), res.getString(2),
					res.getString(3), res.getBoolean(4));
		} catch (SQLException sqle) {
			System.err.println(this.getClass() + " Impossible de selectionner la regle :"
					+ sqle.getMessage());
		}

		return regle;
	}

	@Override
	public int create(Regle objet) {
		PreparedStatement req = null;
		ResultSet res = null;
		int key = -1;
		try {
			req = this.connexion
					.prepareStatement("INSERT INTO REGLE "
							+ "(id_regle, `condition`, action, actif) "
							+ "VALUES (NULL, ?, ?, ?)",
							Statement.RETURN_GENERATED_KEYS);
			req.setString(1, objet.getCondition());
			req.setString(2, objet.getAction());
			req.setBoolean(3, objet.isActif());
			req.executeUpdate();
			res = req.getGeneratedKeys();
			res.next();
			key = res.getInt(1);
		} catch (SQLException sqle) {
			System.err.println(this.getClass() + " Impossible de creer la regle :"
					+ sqle.getMessage());
		}
		objet.setId(key);
		return key;
	}

	@Override
	public int update(Regle objet) {
		PreparedStatement req = null;
		int nbLine = 0;
		try {
			req = this.connexion.prepareStatement("UPDATE REGLE "
					+ "SET `condition` = ?, action = ?, actif = ? "
					+ "WHERE id_regle = ?");
			req.setString(1, objet.getCondition());
			req.setString(2, objet.getAction());
			req.setBoolean(3, objet.isActif());
			req.setInt(4, objet.getId());
			nbLine = req.executeUpdate();
		} catch (SQLException sqle) {
			System.err.println(this.getClass() + " Impossible de mettre a jour la regle :"
					+ sqle.getMessage());
		}
		return nbLine;
	}

	@Override
	public int delete(Regle objet) {
		PreparedStatement req = null;
		int nbLine = 0;
		try {
			req = this.connexion.prepareStatement("DELETE FROM REGLE "
					+ "WHERE id_regle = ?");
			req.setInt(1, objet.getId());
			nbLine = req.executeUpdate();
		} catch (SQLException sqle) {
			System.err.println(this.getClass() + " Imossible de supprimer la regle :"
					+ sqle.getMessage());
		}
		return nbLine;
	}

	public static MySQLRegleDAO getInstance() {
		if (instance == null)
		{
			instance = new MySQLRegleDAO();
		}
		return instance;
	}

}
