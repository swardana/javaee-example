-- Status of the book such as completed, one shot, ongoing
DROP TABLE IF EXISTS status;
CREATE TABLE status(
  id INT(2) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(255)
) ENGINE=InnoDB;

-- Category of the book such as science fiction, action, slice of life
DROP TABLE IF EXISTS category;
CREATE TABLE category(
  id INT(2) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(255)
) ENGINE=InnoDB;

-- Author of the book
DROP TABLE IF EXISTS author;
CREATE TABLE author(
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(255)
) ENGINE=InnoDB;

-- The Book
DROP TABLE IF EXISTS book;
CREATE TABLE book(
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  category_id INT(2) UNSIGNED NOT NULL,
  author_id INT(4) UNSIGNED UNIQUE NOT NULL, -- at the moment make book just written by one author
  status_id INT(2) UNSIGNED NOT NULL,
  title VARCHAR(255) NOT NULL,
  alternative_title VARCHAR(255),
  banner VARCHAR(255),
  tags VARCHAR(255), -- stored the data as string with comma (,) separator
  summary TEXT,
  created DATETIME,
  updated DATETIME,
  FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (status_id) REFERENCES status(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Series of the book
DROP TABLE IF EXISTS series;
CREATE TABLE series(
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  book_id INT(4) UNSIGNED NOT NULL,
  title VARCHAR(255) NOT NULL,
  saga INT(2) NOT NULL, -- working as volume of the series
  cover VARCHAR(255),
  summary TEXT,
  created DATETIME,
  updated DATETIME,
  FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- User and Roles Tables
DROP TABLE IF EXISTS user_account;
CREATE TABLE user_account(
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL,
  email VARCHAR(200),
  password VARCHAR(255) NOT NULL,
  enabled INT(1) -- active = 1, non-active = 0
) ENGINE=InnoDB;

DROP TABLE IF EXISTS role;
CREATE TABLE role(
  id INT(2) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  role_name VARCHAR(100) NOT NULL,
  description VARCHAR(255)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role(
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT(4) UNSIGNED NOT NULL,
  role_id INT(2) UNSIGNED NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user_account(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;