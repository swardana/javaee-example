package id.swhp.javaee.library.web;

import id.swhp.javaee.library.entities.Author;
import id.swhp.javaee.library.services.AuthorService;
import org.slf4j.Logger;

import javax.enterprise.inject.Model;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Model
public class AuthorConverter implements Converter {
    @Inject
    Logger log;
    @Inject
    AuthorService authorService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        log.info("[getAsObject()]");
        if (value == null || value.isEmpty()) {
            log.info("[null]");
            return null;
        }

        try {
            Integer id = Integer.valueOf(value);
            return this.authorService.findById(id);
        } catch (NumberFormatException e) {
            log.warn("Error: {}", e);
            throw new ConverterException("The value is not a valid Product ID: " + value, e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        log.info("[getAsString()]");
        if (value == null) {
            log.info("[null]");
            return "";
        }

        if (value instanceof Author) {
            Integer id = ((Author) value).getId();
            return (id != null) ? String.valueOf(id) : null;
        } else {
            log.warn("Error: Value is not instance of Author");
            throw new ConverterException("The value is not a valid Author instance: " + value);
        }
    }
}
