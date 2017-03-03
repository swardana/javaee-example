package id.swhp.javaee.library.web;

import id.swhp.javaee.library.entities.Author;
import id.swhp.javaee.library.services.AuthorService;

import javax.annotation.PostConstruct;
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
    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @PostConstruct
    public void init(){
        this.authors = this.authorService.findAll();
    }

}
