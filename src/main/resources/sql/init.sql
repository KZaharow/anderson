DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS employer;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS feedback;

CREATE TABLE employer
(
    id              SERIAL PRIMARY KEY NOT NULL,
    name            text,
    surname         text,
    patronymic      text,
    e_mail          text,
    tel             text,
    birthday        timestamp,
    experience      integer,
    employment_data timestamp,
    project_id      integer,
    work_skill      char(2),
    english_skill   char(2),
    skype           text,
    feedback_id     integer
);

CREATE TABLE feedback
(
    id   SERIAL PRIMARY KEY NOT NULL,
    text text,
    date timestamp
);

CREATE TABLE project
(
    id              SERIAL PRIMARY KEY NOT NULL,
    name            text,
    costumer        text,
    finish_date     timestamp,
    methodology     text,
    project_manager text,
    team_name_id    integer
);

CREATE TABLE team
(
    id          SERIAL PRIMARY KEY NOT NULL,
    name        text,
    employer_id integer
);


ALTER TABLE employer
    ADD CONSTRAINT employer_project_id_fk FOREIGN KEY (project_id) REFERENCES project (id);
ALTER TABLE employer
    ADD CONSTRAINT employer_feedback_id_fk FOREIGN KEY (feedback_id) REFERENCES feedback (id);
ALTER TABLE project
    ADD CONSTRAINT project_team_name_id_fk FOREIGN KEY (team_name_id) REFERENCES team_name (id);
ALTER TABLE team
    ADD CONSTRAINT team_employer_id_fk FOREIGN KEY (employer_id) REFERENCES employer (id);

INSERT INTO team_name (id, name)
VALUES (1, 'Команда А');
INSERT INTO team_name (id, name)
VALUES (2, 'Команда Б');

INSERT INTO feedback (id, text, date)
VALUES (1, 'Замечательно справился', '2021-01-01 12:00:01.000000');
INSERT INTO feedback (id, text, date)
VALUES (2, 'Успешно, хотим еще', '2021-02-02 10:00:01.000000');

INSERT INTO project (id, name, costumer, finish_date, methodology, project_manager, team_name_id)
VALUES (1, 'iPay', 'BelBank', '2021-12-31 10:00:01.000000', 'Spring boot', 'MANAGER_1', 1);
INSERT INTO project (id, name, costumer, finish_date, methodology, project_manager, team_name_id)
VALUES (2, 'qBank', 'ExtBank', '2021-12-31 10:00:01.000000', 'Spring boot', 'MANAGER_2', 2);

INSERT INTO employer (id, name, surname, patronymic, e_mail, tel, birthday, experience, employment_data, project_id,
                      work_skill, english_skill, skype, feedback_id)
VALUES (1, 'Иван', 'Иванов', 'Иванович', 'ivan@mail.ru', '(232)11-22-00', '1990-01-01 10:00:01.000000', 70,
        '2018-01-10 10:00:01.000000', 1, 'm1', 'B1', 'ivanSkype', 1);

INSERT INTO employer (id, name, surname, patronymic, e_mail, tel, birthday, experience, employment_data, project_id,
                      work_skill, english_skill, skype, feedback_id)
VALUES (2, 'Олег', 'Олегов', 'Олегович', 'oleg@mail.ru', '(232)11-22-01', '1991-01-01 10:00:01.000000', 80,
        '2019-01-10 10:00:01.000000', 1, 'm2', 'B2', 'olegSkype', 2);
INSERT INTO employer (id, name, surname, patronymic, e_mail, tel, birthday, experience, employment_data, project_id,
                      work_skill, english_skill, skype, feedback_id)
VALUES (3, 'Петр', 'Петров', 'Петрович', 'petr@mail.ru', '(232)11-22-02', '1992-02-02 10:00:01.000000', 90,
        '2020-01-10 10:00:01.000000', 1, 's1', 'C1', 'petrSkype', 1);

INSERT INTO employer (id, name, surname, patronymic, e_mail, tel, birthday, experience, employment_data, project_id,
                      work_skill, english_skill, skype, feedback_id)
VALUES (4, 'Глеб', 'Глебов', 'Глебович', 'gleb@mail.ru', '(232)11-22-03', '1993-03-03 10:00:01.000000', 99,
        '2020-02-10 10:00:01.000000', 1, 's2', 'C2', 'glebSkype', 2);

INSERT INTO team (id, team_name_id, employer_id)
VALUES (1, 1, 1);
INSERT INTO team (id, team_name_id, employer_id)
VALUES (2, 1, 3);
INSERT INTO team (id, team_name_id, employer_id)
VALUES (3, 2, 2);
INSERT INTO team (id, team_name_id, employer_id)
VALUES (4, 2, 4);
