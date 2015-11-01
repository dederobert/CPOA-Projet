package appli.dao;

import java.util.ArrayList;

import appli.modele.metier.Regle;
/**
 * Interface de gestion de la persistance des Regle <br /> <b> DAO niveau 2</b>
 * @author alexis
 *
 */
public interface RegleDAO extends DAO<Regle>{

	ArrayList<Regle> getAllRegle();}
