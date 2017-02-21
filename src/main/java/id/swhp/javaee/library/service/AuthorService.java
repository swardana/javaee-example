package id.swhp.javaee.library.service;

import id.swhp.javaee.library.entities.Author;
import id.swhp.javaee.library.repository.AuthorDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Stateless
public class AuthorService {
    @Inject
    AuthorDao authorDao;

    public List<Author> findAll() {
        return this.authorDao.findAll();
    }
}
