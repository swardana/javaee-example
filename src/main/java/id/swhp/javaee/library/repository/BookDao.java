package id.swhp.javaee.library.repository;

import id.swhp.javaee.library.entities.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Stateless
public class BookDao {

    @PersistenceContext
    EntityManager em;

    public List<Book> findAll() {
        return this.em.createNamedQuery(Book.FIND_ALL_BOOK, Book.class).getResultList();
    }
}
