package principal.dao.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connexion {
    static Properties accessBdD = new Properties();
    static File fconf = new File("config/bdd.properties");

    public static Connection creerConnexion() {

            FileInputStream source;

            try {
                    source = new FileInputStream(fconf);
                    accessBdD.loadFromXML(source);
            } catch (IOException ioe) {
                    ioe.printStackTrace();
            }

            String url = "jdbc:mysql://" + accessBdD.getProperty("adresse_ip")
                            + ":" + accessBdD.getProperty("port") + "/"
                            + accessBdD.getProperty("bdd"); // jdbc:mysql://infodb.iutmetz.univ-lorraine.fr:3306/dinquer1u_java";
            String user = accessBdD.getProperty("login"); // "dinquer1u_appli";
            String password = accessBdD.getProperty("pass"); // "alexis57";

            Connection maConnexion = null;

            try {
                    maConnexion = DriverManager.getConnection(url, user, password);
            } catch (SQLException sqle) {
                    System.out.println("Erreur de connexion " + sqle.getMessage());
            }

            return maConnexion;
    }
}
