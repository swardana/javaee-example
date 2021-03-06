package id.swhp.javaee.library.web;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;

@Model
public class MainBean implements Serializable {
    @Inject
    private Logger log;

    @PostConstruct
    private void postConstruct() {
        log.info("INFO MESSAGE @PostConstruct");
        log.debug("DEBUG MESSAGE @PostConstruct");
        log.warn("WARN MESSAGE @PostConstruct");
        log.error("ERROR MESSAGE @PostConstruct");
    }

    public String greeting() {
        log.debug("greeting method");
        return "Hello World";
    }

    public String getMessage() {
        log.info("getMessage method");
        return "This Made with Love";
    }
}
