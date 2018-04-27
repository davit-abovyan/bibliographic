use bibliographic;

DROP TABLE IF EXISTS journal_editor_board;
DROP TABLE IF EXISTS boh_journal;
DROP TABLE IF EXISTS statistics;
DROP TABLE IF EXISTS journal;
DROP TABLE IF EXISTS science_field;
DROP TABLE IF EXISTS boh;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS operator;
DROP TABLE IF EXISTS users;


CREATE TABLE operator (
  id SMALLINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  is_reviewer TINYINT(1) DEFAULT 0
);

CREATE TABLE person (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name_initial_arm VARCHAR(255) NOT NULL,
  name_initial_rus VARCHAR(255) NOT NULL,
  name_initial_eng VARCHAR(255) NOT NULL,
  name_final_arm VARCHAR(255),
  name_final_rus VARCHAR(255),
  name_final_eng VARCHAR(255),
  review_state TINYINT(1) DEFAULT 0
);

CREATE TABLE boh(
  id SMALLINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) UNIQUE
);

CREATE TABLE science_field(
  id SMALLINT PRIMARY KEY AUTO_INCREMENT,
  name_arm VARCHAR(255),
  name_rus VARCHAR(255),
  name_eng VARCHAR(255)
);

CREATE TABLE journal (
  id SMALLINT PRIMARY KEY AUTO_INCREMENT,
  code CHAR(7) NOT NULL UNIQUE,
  operator SMALLINT NOT NULL,
  name_arm VARCHAR(255) NOT NULL,
  name_rus VARCHAR(255) NOT NULL,
  name_eng VARCHAR(255) NOT NULL,
  full_name_arm VARCHAR(255) NOT NULL,
  full_name_rus VARCHAR(255) NOT NULL,
  full_name_eng VARCHAR(255) NOT NULL,
  ISSN_print CHAR(9) NOT NULL ,
  ISBN VARCHAR(40),
  founder_arm VARCHAR(255) NOT NULL,
  publisher_arm VARCHAR(255),
  publisher_rus VARCHAR(255),
  publisher_eng VARCHAR(255),
  phone VARCHAR(60),
  fax VARCHAR(40),
  email VARCHAR(50),
  website VARCHAR(255),
  country ENUM('ARM') DEFAULT 'ARM',
  city VARCHAR(50),
  address VARCHAR(255),
  frequency SMALLINT,
  language SMALLINT,
  journal_category VARCHAR(50),
  reviewed TINYINT(1) DEFAULT 0,
  in_progress TINYINT(1) DEFAULT 0,
  start_year CHAR(4),
  editor INT NOT NULL ,
  description_arm TEXT,
  description_rus TEXT,
  description_eng TEXT,
  science_field_id SMALLINT NOT NULL ,
  cover VARCHAR(255) DEFAULT "0",
  type TINYINT(1) DEFAULT 0,
  indexed_libraries INT NOT NULL DEFAULT 0,
  CONSTRAINT operator_fk FOREIGN KEY (operator) REFERENCES operator(id),
  CONSTRAINT editor_fk FOREIGN KEY (editor) REFERENCES person(id),
  CONSTRAINT science_field_id_fk FOREIGN KEY (science_field_id) REFERENCES science_field(id)
);


CREATE TABLE statistics (
  journal_id SMALLINT NOT NULL UNIQUE,
  IF_2010 SMALLINT DEFAULT 0,
  IF_2011 SMALLINT DEFAULT 0,
  IF_2012 SMALLINT DEFAULT 0,
  IF_2013 SMALLINT DEFAULT 0,
  IF_2014 SMALLINT DEFAULT 0,
  IF_2015 SMALLINT DEFAULT 0,
  IF_2016 SMALLINT DEFAULT 0,
  IF_2017 SMALLINT DEFAULT 0,
  IF_2018 SMALLINT DEFAULT 0,
  IF_2019 SMALLINT DEFAULT 0,
  IF_2020 SMALLINT DEFAULT 0,
  n_issue_elib SMALLINT UNSIGNED DEFAULT 0,
  n_issue_AINC SMALLINT UNSIGNED DEFAULT 0,
  n_article_elib SMALLINT UNSIGNED DEFAULT 0,
  n_article_AINC SMALLINT UNSIGNED DEFAULT 0,
  n_reference_AINC SMALLINT UNSIGNED DEFAULT 0,
  n_citation_AINC SMALLINT UNSIGNED DEFAULT 0,
  n_selfcite_AINC SMALLINT UNSIGNED DEFAULT 0,
  INDEX statistics_idx (journal_id),
  CONSTRAINT statistics_journal_id_fk FOREIGN KEY (journal_id) REFERENCES journal(id)
);

CREATE TABLE boh_journal(
  journal_id SMALLINT NOT NULL ,
  boh_id SMALLINT NOT NULL ,
  INDEX boh_journal_idx (journal_id, boh_id),
  CONSTRAINT boh_journal_id_fk FOREIGN KEY (journal_id) REFERENCES journal(id),
  CONSTRAINT boh_id_fk FOREIGN KEY (boh_id) REFERENCES boh(id)
);

CREATE TABLE journal_editor_board(
  journal_id SMALLINT NOT NULL,
  editor_id INT NOT NULL,
  editor_position_arm VARCHAR(255),
  editor_position_rus VARCHAR(255),
  editor_position_eng VARCHAR(255),
  INDEX journal_editor_board_idx (journal_id, editor_id),
  CONSTRAINT editor_board_journal_id_fk FOREIGN KEY (journal_id) REFERENCES journal(id),
  CONSTRAINT editor_id_fk FOREIGN KEY (editor_id) REFERENCES person(id)
);

CREATE TABLE users (
  username VARCHAR(255) PRIMARY KEY,
  password VARCHAR(255) NOT NULL,
  authority VARCHAR(255) NOT NULL DEFAULT "ROLE_USER",
  enabled BOOLEAN DEFAULT FALSE
);
