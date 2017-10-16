DROP TABLE IF EXISTS T_STUDENT;
DROP TABLE IF EXISTS T_CLASS;
DROP TABLE IF EXISTS T_SCHOOL;

CREATE TABLE T_STUDENT (
  ID BIGINT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(20),
  AGE INT,
  BIRTHDAY DATE,
  CREATE_TIME DATETIME,
  CLASS_ID INT,
  VERSION INT NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE T_CLASS (
  ID BIGINT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(20),
  SCHOOL_ID INT,
  VERSION INT NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE T_SCHOOL (
  ID BIGINT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(20),
  VERSION INT NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;