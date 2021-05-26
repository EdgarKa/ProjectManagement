INSERT INTO task (task_name, difficulty, status, assigned_to, start_date, finish_date)
VALUES ('Task1', 'Hard', 'ToDo', 'user1', '2021-05-23', '2021-06-23'),
       ('Task2', 'Easy', 'ToDo', 'user2', '2021-05-23', '2021-06-23'),
       ('Task3', 'Medium', 'ToDo', 'user3', '2021-05-23', '2021-06-23'),
       ('Task4', 'Hard', 'ToDo', 'user2', '2021-05-23', '2021-06-23'),
       ('Task5', 'Medium', 'ToDo', 'user3', '2021-05-23', '2021-06-23');

INSERT INTO project (project_name, project_description)
VALUES ('Project1', 'description for project 1'),
       ('Project2', 'description for project 2'),
       ('Project3', 'description for project 3');

INSERT INTO project_task (project_id, task_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (2, 5);