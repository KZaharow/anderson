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

CREATE TABLE team
(
    id   bigint AUTO_INCREMENT
        CONSTRAINT team primary key,
    name text
);

CREATE TABLE employer
(
    id              bigint AUTO_INCREMENT
        CONSTRAINT employer_pkey primary key,
    name            text,
    surname         text,
    patronymic      text,
    mail           text,
    tel             text,
    birthday        timestamp,
    experience      integer,
    employment_data timestamp,
    work_skill      char(2),
    english_skill   char(2),
    skype           text,
    feedback_id     integer,
    project_id      integer,
    team_id         integer
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

ALTER TABLE employer
    ADD CONSTRAINT employer_project_id_fk FOREIGN KEY (project_id) REFERENCES project (id);
ALTER TABLE employer
    ADD CONSTRAINT employer_feedback_id_fk FOREIGN KEY (feedback_id) REFERENCES feedback (id);
ALTER TABLE employer
    ADD CONSTRAINT employer_team_id_fk FOREIGN KEY (team_id) REFERENCES team (id);