
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

INSERT INTO employer (name, surname, patronymic, mail, tel, birthday, experience, employment_data, work_skill,
                      english_skill, skype, feedback_id, project_id, team_id)
VALUES ('Иван', 'Иванов', 'Иванович', 'ivan@mail.ru', '(232)11-22-00', '1990-01-01 10:00:01.000000', 70,
        '2018-01-10 10:00:01.000000', 'm1', 'B1', 'ivanSkype', 1, 1, 1 );

INSERT INTO employer (name, surname, patronymic, mail, tel, birthday, experience, employment_data, work_skill,
                      english_skill, skype, feedback_id, project_id, team_id)
VALUES ('Олег', 'Олегов', 'Олегович', 'oleg@mail.ru', '(232)11-22-01', '1991-01-01 10:00:01.000000', 80,
        '2019-01-10 10:00:01.000000', 'm2', 'B2', 'olegSkype', 1, 1, 1) ;
INSERT INTO employer (name, surname, patronymic, mail, tel, birthday, experience, employment_data, work_skill,
                      english_skill, skype, feedback_id, project_id, team_id)
VALUES ('Петр', 'Петров', 'Петрович', 'petr@mail.ru', '(232)11-22-02', '1992-02-02 10:00:01.000000', 90,
        '2020-01-10 10:00:01.000000', 's1', 'C1', 'petrSkype', 1, 1, 1) ;

INSERT INTO employer (name, surname, patronymic, mail, tel, birthday, experience, employment_data, work_skill,
                      english_skill, skype, feedback_id, project_id, team_id)
VALUES ('Глеб', 'Глебов', 'Глебович', 'gleb@mail.ru', '(232)11-22-03', '1993-03-03 10:00:01.000000', 99,
        '2020-02-10 10:00:01.000000', 's2', 'C2', 'glebSkype', 1, 1, 1) ;