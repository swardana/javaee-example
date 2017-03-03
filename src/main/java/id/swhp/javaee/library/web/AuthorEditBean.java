package id.swhp.javaee.library.web;

import id.swhp.javaee.library.entities.Author;
import org.omnifaces.cdi.ViewScoped;

import javax.inject.Named;
import java.io.Serializable;


/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Named
@ViewScoped
public class AuthorEditBean implements Serializable {
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
