package appli.dao;

/**
 * Interface principale de la DAO 1&2, permet de definir les methode de persistance CRUD
 * @author alexis
 *
 * @param <T> Type de la DAO
 */
public interface DAO<T> {
        public abstract T getById(int id);
        public abstract int create(T objet);
        public abstract int update(T objet);
        public abstract int delete(T objet);
}
