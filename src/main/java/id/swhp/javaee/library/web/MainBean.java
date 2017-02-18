package id.swhp.javaee.library.web;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class MainBean implements Serializable {

    public String greeting() {
        return "Hello World";
    }

    public String getMessage() {
        return "This Made with Love";
    }
}
