CREATE SCHEMA IF NOT EXISTS APP_DB;

CREATE TABLE IF NOT EXISTS CONFERENCE (
    STOCKID	BIGINT(19)	NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NAME	VARCHAR(255),
    DATE	TIMESTAMP   NOT NULL,
    PARTICIPANT VARCHAR(255)

);

CREATE TABLE IF NOT EXISTS PARTICIPANT (
    ID	BIGINT(19)	NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CREATED_DATE	TIMESTAMP(9),
    LAST_MODIFIED_DATE	TIMESTAMP(9),
    NAME	VARCHAR(255)    NOT NULL ,
    SURNAME	VARCHAR(255)    NOT NULL ,
    BIRTHDAY	TIMESTAMP(9)    NOT NULL ,
    AGE INT NOT NULL ,
    SUBJECT	VARCHAR(255) ,
    CREATED_BY_ID	BIGINT(19),
    LAST_MODIFIED_BY_ID	BIGINT(19)
);

CREATE TABLE IF NOT EXISTS PARTICIPANT (
    CONFERENCEROOMID BIGINT(3)	NOT NULL PRIMARY KEY AUTO_INCREMENT,
    LOCATION VARCHAR    NOT NULL ,
    ROOMNUMBER  INT NOT NULL ,
    SEATS   INT NOT NULL ,
    DATE    TIMESTAMP(9)    NOT NULL ,
    PARTICIPANT VARCHAR(255),
    AVALIBLE BOOL
);