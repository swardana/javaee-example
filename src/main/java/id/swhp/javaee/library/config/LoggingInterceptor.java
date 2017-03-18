package id.swhp.javaee.library.config;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

/**
 * @author Sukma Wardana
 * @since 1.0.0
 */
@Loggable
@Interceptor
public class LoggingInterceptor implements Serializable {
    @Inject
    transient Logger logger;

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {
        logger.info(">>>" + ic.getTarget().getClass().getName() + "-"
                + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            logger.info("<<<" + ic.getTarget().getClass().getName() + "-"
                    + ic.getMethod().getName());
        }
    }
}
