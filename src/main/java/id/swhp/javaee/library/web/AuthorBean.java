package id.swhp.javaee.library.web;

import id.swhp.javaee.library.entities.Author;
import id.swhp.javaee.library.service.AuthorService;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Model
public class AuthorBean {
    @Inject
    AuthorService authorService;

    public List<Author> authors(){
        return authorService.findAll();
    }
}
