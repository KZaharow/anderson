DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS employer;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS feedback;

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
    id           SERIAL PRIMARY KEY NOT NULL,
    team_name_id integer,
    employer_id  integer
);
/*

ALTER TABLE employer
    ADD CONSTRAINT employer_project_id_fk FOREIGN KEY (project_id) REFERENCES project (id);
ALTER TABLE employer
    ADD CONSTRAINT employer_feedback_id_fk FOREIGN KEY (feedback_id) REFERENCES feedback (id);
ALTER TABLE project
    ADD CONSTRAINT project_team_name_id_fk FOREIGN KEY (team_name_id) REFERENCES team_name (id);
ALTER TABLE team
    ADD CONSTRAINT team_team_name_id_fk FOREIGN KEY (team_name_id) REFERENCES team_name (id);
ALTER TABLE team
    ADD CONSTRAINT team_employer_id_fk FOREIGN KEY (employer_id) REFERENCES employer (id);
*/

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

INSERT INTO team (team_name_id, employer_id)
VALUES (1, 1);
INSERT INTO team (team_name_id, employer_id)
VALUES (1, 3);
