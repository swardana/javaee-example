package id.swhp.javaee.library.repository;

import id.swhp.javaee.library.entities.Author;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Stateless
public class AuthorDao {
    @PersistenceContext(name = "libraryPU")
    EntityManager em;

    public List<Author> findAll(){
        return this.em.createNamedQuery(Author.FIND_ALL_AUTHOR, Author.class).getResultList();
    }
}
