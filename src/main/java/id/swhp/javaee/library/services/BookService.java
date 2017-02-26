package id.swhp.javaee.library.services;

import id.swhp.javaee.library.entities.Book;
import id.swhp.javaee.library.repository.BookDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Stateless
public class BookService {

    @Inject
    BookDao bookDao;

    public List<Book> findAll() {
        return this.bookDao.findAll();
    }
}
