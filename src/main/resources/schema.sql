CREATE TABLE task(
    task_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(16),
    difficulty VARCHAR(16),
    status VARCHAR(16),
    assigned_to VARCHAR(32),
    start_date DATE,
    finish_date DATE
);

CREATE TABLE project(
  project_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  project_name VARCHAR(256),
  project_description VARCHAR(256),
  progress INTEGER
);

CREATE TABLE project_task(
    project_id BIGINT NOT NULL,
    task_id BIGINT NOT NULL,
    CONSTRAINT FK_PROJECT_ID FOREIGN KEY (project_id) REFERENCES project (project_id),
    CONSTRAINT FK_TASK_ID FOREIGN KEY (task_id) REFERENCES task (task_id)
);