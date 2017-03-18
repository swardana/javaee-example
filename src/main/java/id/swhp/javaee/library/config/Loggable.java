package id.swhp.javaee.library.config;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface Loggable {
}
