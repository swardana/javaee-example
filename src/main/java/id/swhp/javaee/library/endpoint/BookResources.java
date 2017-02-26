package id.swhp.javaee.library.endpoint;

import id.swhp.javaee.library.entities.Book;
import id.swhp.javaee.library.services.BookService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Path("book")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResources {

    @Inject
    BookService bookService;

    @GET
    public List<Book> findAll() {
        return this.bookService.findAll();
    }
}
