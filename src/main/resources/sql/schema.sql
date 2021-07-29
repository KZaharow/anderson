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
ALTER TABLE team
    ADD CONSTRAINT team_employer_id_fk FOREIGN KEY (employer_id) REFERENCES employer (id);