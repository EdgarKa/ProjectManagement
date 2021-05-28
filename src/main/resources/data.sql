INSERT INTO task (task_name, difficulty, status, assigned_to, start_date, finish_date)
VALUES ('Task1', 'Hard', 'ToDo', 'user1', '2021-05-23', '2021-06-23'),
       ('Task2', 'Easy', 'Done', 'user2', '2021-05-23', '2021-06-23'),
       ('Task3', 'Medium', 'Doing', 'user3', '2021-05-23', '2021-06-23'),
       ('Task4', 'Hard', 'Done', 'user2', '2021-05-23', '2021-06-23'),
       ('Task5', 'Medium', 'Doing', 'user3', '2021-05-23', '2021-06-23');

INSERT INTO project (project_name, project_description, progress)
VALUES ('Project1', 'description for project 1', 50),
       ('Project2', 'description for project 2', 33),
       ('Project3', 'description for project 3', 0);

INSERT INTO project_task (project_id, task_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (2, 5);