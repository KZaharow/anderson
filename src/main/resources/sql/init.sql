DROP TABLE IF EXISTS employer cascade;
DROP TABLE IF EXISTS team cascade;
DROP TABLE IF EXISTS project cascade;
DROP TABLE IF EXISTS feedback cascade;

CREATE TABLE feedback
(
    id   bigint AUTO_INCREMENT
        CONSTRAINT feedback primary key,
    text text,
    date timestamp
);

CREATE TABLE employer
(
    id              bigint AUTO_INCREMENT
        CONSTRAINT employer_pkey primary key,
    name            text,
    surname         text,
    patronymic      text,
    email           text,
    tel             text,
    birthday        timestamp,
    experience      integer,
    employment_data timestamp,
    work_skill      char(2),
    english_skill   char(2),
    skype           text,
    feedback_id     integer,
    project_id      integer
);

CREATE TABLE project
(
    id              bigint AUTO_INCREMENT
        CONSTRAINT project primary key,
    name            text,
    costumer        text,
    finish_date     timestamp,
    methodology     text,
    project_manager text
);

CREATE TABLE team
(
    id   bigint AUTO_INCREMENT
        CONSTRAINT team primary key,
    name text
);


ALTER TABLE employer
    ADD CONSTRAINT employer_project_id_fk FOREIGN KEY (project_id) REFERENCES project (id);
ALTER TABLE employer
    ADD CONSTRAINT employer_feedback_id_fk FOREIGN KEY (feedback_id) REFERENCES feedback (id);

INSERT INTO feedback (text, date)
VALUES ('Замечательно справился', '2021-01-01 12:00:01.000000');
INSERT INTO feedback (text, date)
VALUES ('Успешно, хотим еще', '2021-02-02 10:00:01.000000');

INSERT INTO project (name, costumer, finish_date, methodology, project_manager)
VALUES ('iPay', 'BelBank', '2021-12-31 10:00:01.000000', 'Spring boot', 'MANAGER_1');
INSERT INTO project (name, costumer, finish_date, methodology, project_manager)
VALUES ('qBank', 'ExtBank', '2021-12-31 10:00:01.000000', 'Spring boot', 'MANAGER_2');

INSERT INTO team (name)
VALUES ('Команда 1');
INSERT INTO team (name)
VALUES ('Команда 2');

INSERT INTO employer (name, surname, patronymic, email, tel, birthday, experience, employment_data, work_skill,
                      english_skill, skype, feedback_id, project_id)
VALUES ('Иван', 'Иванов', 'Иванович', 'ivan@mail.ru', '(232)11-22-00', '1990-01-01 10:00:01.000000', 70,
        '2018-01-10 10:00:01.000000', 'm1', 'B1', 'ivanSkype', 1, 1);

INSERT INTO employer (name, surname, patronymic, email, tel, birthday, experience, employment_data, work_skill,
                      english_skill, skype, feedback_id, project_id)
VALUES ('Олег', 'Олегов', 'Олегович', 'oleg@mail.ru', '(232)11-22-01', '1991-01-01 10:00:01.000000', 80,
        '2019-01-10 10:00:01.000000', 'm2', 'B2', 'olegSkype', 1, 1);
INSERT INTO employer (name, surname, patronymic, email, tel, birthday, experience, employment_data, work_skill,
                      english_skill, skype, feedback_id, project_id)
VALUES ('Петр', 'Петров', 'Петрович', 'petr@mail.ru', '(232)11-22-02', '1992-02-02 10:00:01.000000', 90,
        '2020-01-10 10:00:01.000000', 's1', 'C1', 'petrSkype', 1, 1);

INSERT INTO employer (name, surname, patronymic, email, tel, birthday, experience, employment_data, work_skill,
                      english_skill, skype, feedback_id, project_id)
VALUES ('Глеб', 'Глебов', 'Глебович', 'gleb@mail.ru', '(232)11-22-03', '1993-03-03 10:00:01.000000', 99,
        '2020-02-10 10:00:01.000000', 's2', 'C2', 'glebSkype', 1, 1);