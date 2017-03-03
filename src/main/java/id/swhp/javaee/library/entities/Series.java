package id.swhp.javaee.library.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "series")
@NamedQuery(name = Series.FIND_ALL_SERIES, query = "select s from Series s left join s.book")
public class Series implements Serializable {
    public static final String FIND_ALL_SERIES = "findAllSeries";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    @NotNull
    @XmlTransient
    private Book book;
    @NotNull
    private String title;
    @NotNull
    private Integer saga;
    private String cover;
    private String summary;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    public Series() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSaga() {
        return saga;
    }

    public void setSaga(Integer saga) {
        this.saga = saga;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return new StringBuilder("Series [").append(id).append(",").append(title).append(",")
                .append(saga).append(",").append(cover).append(",").append(summary).append(",")
                .append(created).append(",").append(updated).append("]").toString();
    }
}
