DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS employer;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS feedback;
DROP SEQUENCE IF EXISTS sq1;
DROP SEQUENCE IF EXISTS sq2;
DROP SEQUENCE IF EXISTS sq3;
DROP SEQUENCE IF EXISTS sq4;


CREATE TABLE employer
(
    id              SERIAL PRIMARY KEY NOT NULL,
    name            varchar(30),
    surname         varchar(30),
    patronymic      varchar(30),
    e_mail          varchar(30),
    tel             varchar(30),
    birthday        timestamp,
    experience      integer,
    employment_data timestamp,
    work_skill      char(2),
    english_skill   char(2),
    skype           varchar(30),
    feedback_id     integer,
    project_id      integer,
    team_id         integer
);

CREATE TABLE feedback
(
    id   SERIAL PRIMARY KEY NOT NULL,
    text varchar(30),
    date timestamp
);

CREATE TABLE project
(
    id              SERIAL PRIMARY KEY NOT NULL,
    name            varchar(30),
    costumer        varchar(30),
    finish_date     timestamp,
    methodology     varchar(30),
    project_manager varchar(30)
);

CREATE TABLE team
(
    id   SERIAL PRIMARY KEY NOT NULL,
    name varchar(30)
);

create sequence sq1 start 3 increment 1;
create sequence sq2 start 3 increment 1;
create sequence sq3 start 3 increment 1;
create sequence sq4 start 3 increment 1;

INSERT INTO feedback (text, date)
VALUES ('Замечательно справился', '2021-01-01 12:00:01.000000');
INSERT INTO feedback (text, date)
VALUES ('Успешно, хотим еще', '2021-02-02 10:00:01.000000');

INSERT INTO project (name, costumer, finish_date, methodology, project_manager)
VALUES ('iPay', 'BelBank', '2021-12-31 10:00:01.000000', 'Spring boot', 'MANAGER_1');
INSERT INTO project (name, costumer, finish_date, methodology, project_manager)
VALUES ('qBank', 'ExtBank', '2021-12-31 10:00:01.000000', 'Spring boot', 'MANAGER_2');

INSERT INTO employer (name, surname, patronymic, e_mail, tel, birthday, experience, employment_data, work_skill,
                      english_skill, skype, feedback_id, project_id, team_id)
VALUES ('Иван', 'Иванов', 'Иванович', 'ivan@mail.ru', '(232)11-22-00', '1990-01-01 10:00:01.000000', 70,
        '2018-01-10 10:00:01.000000', 'm1', 'B1', 'ivanSkype', 1, 1, 1);

INSERT INTO employer (name, surname, patronymic, e_mail, tel, birthday, experience, employment_data, work_skill,
                      english_skill, skype, feedback_id, project_id, team_id)
VALUES ('Глеб', 'Глебов', 'Глебович', 'gleb@mail.ru', '(232)11-22-03', '1993-03-03 10:00:01.000000', 99,
        '2020-02-10 10:00:01.000000', 's2', 'C2', 'glebSkype', 2, 2, 2);

INSERT INTO team (name)
VALUES ('команда а');
INSERT INTO team (name)
VALUES ('команда б');
