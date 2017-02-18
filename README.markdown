# JAVAEE EXAMPLE
Simple Library Application using JavaEE Technology

## Tools & Library

* Apache Maven (3.3.9)
* MariaDB (10.0.29)

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

## NOTES

`@stateless`: is EJB which is manage our transactional in jpa, we don't need to manage transaction, commit, rollback. etc.


## References

* [web.xml deployment descriptor](https://www.mkyong.com/web-development/the-web-xml-deployment-descriptor-examples/)
* [JavaEE descriptor](https://antoniogoncalves.org/2013/06/04/java-ee-7-deployment-descriptors/)
* [Lightweight JavaEE](https://www.youtube.com/watch?v=p4uSu_NvwCE&list=PLxU9yM-_yPs9j21E_xHMzaR4EGcCiKssC&index=7)
* [JavaEE Structure](https://www.youtube.com/watch?v=grJC6RFiB58)
