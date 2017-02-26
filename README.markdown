# JAVAEE EXAMPLE
Simple Library Application using JavaEE 7 Technology (NOTE: This is an over engineer example)

## Tools & Library

* Apache Maven (3.3.9)
* MariaDB (10.0.29)
* Wildfly (10.1.0.FINAL)

## Environment

### Database

To be able running this project first step is to setup the database, in this project used mariaDB database.
Database was named `library` with username: `user`, password: `password`, to make it simple run command below:

```
CREATE DATABASE IF NOT EXISTS library;
ALTER DATABASE library DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;
GRANT ALL PRIVILEGES ON library.* TO user@localhost IDENTIFIED BY 'password';
```

### Schema & Data
DDL schema and data was stored in `src/main/resources/db`. For command line user, execute command below from project directory:

```
mysql --user="user" --password="password" --database="library" < src/main/resources/db/schema.sql
mysql --user="user" --password="password" --database="library" < src/main/resources/db/data.sql
```

### Datasource
Create mysql datasource with JNDI name: `java:jboss/datasource/libraryDS`

## NOTES

* `@stateless`: is EJB which is manage our transactional in jpa, we don't need to manage transaction, commit, rollback. etc.
* Watchout using `@SessionScope` in JSF, make sure to use from `javax.enterprise.context.SessionScoped`
* `@Model`: is a stereotype for @Named & @SessionScoped in JSF
* Wildfly App Server as default using SLF4J for logging implementation, so in pom.xml made SLF4J scope as provided
* Because I put JSF files under folder views, so need to open in browser like this: `javaee/views/main.xhtml`
* Entities class need to specified table name with @Table
* To be able perform get all data, need to made an NamedQuery
* `[ERROR] Caused by: java.lang.IllegalArgumentException: WFLYEE0040: A component named 'xxx' is already defined in this module"}}` just perform:
    * wildfly:undeploy
    * clean install
    * wildfly:deploy
* Building JAX-RS always use JsonArray instead JsonObject
* WILDFLY 10.1.0 Supported SHA-512, to be able encrypt something run command bellow

    ```
    java -cp WILDFLY_HOME/modules/system/layers/base/org/picketbox/main/picketbox-4.9.6.Final.jar org.jboss.security.Base64Encoder <password> <message-digest>
    example:
    java -cp WILDFLY_HOME/modules/system/layers/base/org/picketbox/main/picketbox-4.9.6.Final.jar org.jboss.security.Base64Encoder sukma SHA-512
    ```
## References

* [web.xml deployment descriptor](https://www.mkyong.com/web-development/the-web-xml-deployment-descriptor-examples/)
* [Java Logging](http://www.pscheidl.cz/jee-tips/Injecting-Logger/)
* [Logback Configuration](https://springframework.guru/logback-configuration-using-xml/)
* [JSF @ManagedBean deprecated, used CDI @named](http://stackoverflow.com/questions/4347374/backing-beans-managedbean-or-cdi-beans-named)
* [JavaEE descriptor](https://antoniogoncalves.org/2013/06/04/java-ee-7-deployment-descriptors/)
* [JavaEE PetStore](https://github.com/agoncal/agoncal-application-petstore-ee6)
* [Lightweight JavaEE](https://www.youtube.com/watch?v=p4uSu_NvwCE&list=PLxU9yM-_yPs9j21E_xHMzaR4EGcCiKssC&index=7)
* [JavaEE Structure](https://www.youtube.com/watch?v=grJC6RFiB58)
* [How to Tacke JavaEE](https://www.youtube.com/watch?v=JWcoiXNoKxk)
* [Configure JavaEE with Wildfly](https://wwu-pi.github.io/tutorials/lectures/eai/010_tutorial_jboss_setup.html)
* [Best Practice JPA](https://zeroturnaround.com/rebellabs/how-to-use-jpa-correctly-to-avoid-complaints-of-a-slow-application/)
* [JAAS in Wildfly 10](https://dennis.gesker.com/2016/02/09/jdbc-security-domain-realm-to-wildfly-10/)
* [Form Based Authentication](https://www.examsmyantra.com/article/119/javaee/form-based-login-authentication-in-javaee7-with-wildfly-and-mysql)
* [JDBC Realm](http://blog.eisele.net/2015/01/jdbc-realm-wildfly820-primefaces51.html)
* [JavaEE Authentication](http://stackoverflow.com/a/2997254)