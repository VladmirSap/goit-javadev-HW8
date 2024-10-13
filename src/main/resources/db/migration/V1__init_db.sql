CREATE TABLE IF NOT EXISTS worker (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) BETWEEN 2 AND 1000),
     birthday DATE CHECK (YEAR(birthday) > 1900),
     LEVEL VARCHAR(10) NOT NULL CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior')),
     salary INT CHECK (salary BETWEEN 100 AND 100000)
);

CREATE TABLE IF NOT EXISTS client (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) BETWEEN 2 AND 1000)
);

CREATE TABLE IF NOT EXISTS project (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    client_id LONG,
    start_date DATE,
    finish_date DATE,
    CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES client(id),
    CHECK (finish_date IS NULL OR finish_date >= start_date)
);

CREATE TABLE IF NOT EXISTS project_worker (
    project_id LONG NOT NULL,
    worker_id LONG NOT NULL,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY (project_id) REFERENCES project(id),
    FOREIGN KEY (worker_id) REFERENCES worker(id)
);