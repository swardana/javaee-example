package id.swhp.javaee.library.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Entity
@Table(name = "status")
@NamedQuery(name = Status.FIND_ALL_STATUS, query = "select s from Status s left join s.books")
public class Status implements Serializable {
    public static final String FIND_ALL_STATUS = "findAllStatus";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    private String description;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "status")
    private Set<Book> books;

    public Status() {
    }

    public Status(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
