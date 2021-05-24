CREATE TABLE task(
    task_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(16),
    difficulty VARCHAR(16),
    status VARCHAR(16),
    assigned_to VARCHAR(32),
    start_date DATE,
    finish_date DATE
);