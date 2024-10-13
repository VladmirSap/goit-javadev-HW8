// insert workers
INSERT INTO worker (name, birthday, level, salary)
VALUES
('Mark Smith', '1987-05-15', 'Senior', 7500),
('Michael Johnson', '1990-07-22', 'Middle', 3150),
('Sarah Brown', '1993-12-14', 'Junior', 1200),
('David Williams', '1988-10-09', 'Middle', 2850),
('Jessica Miller', '1995-04-27', 'Junior', 1100),
('Emily Lee', '1986-03-05', 'Senior', 7700),
('James Anderson', '1994-08-13', 'Middle', 2800),
('Laura Taylor', '2000-02-19', 'Trainee', 700),
('Robert White', '1997-11-03', 'Junior', 1150),
('Olivia Davis', '2002-06-06', 'Trainee', 600),
('Daniel Wilson', '1999-01-15', 'Junior', 1500);

// insert clients
INSERT INTO client (name)
VALUES
('Sophia Martin'),
('Ethan Clark'),
('Ava Lewis'),
('Benjamin Harris'),
('Megan Robinson');

// insert projects
INSERT INTO project (client_id, start_date, finish_date)
VALUES
(1, '2024-04-17', '2024-06-21'),
(2, '2024-03-05', '2024-09-29'),
(3, '2024-07-04', '2024-12-15'),
(4, '2024-01-19', '2029-01-19'),
(5, '2020-09-10', '2027-09-10'),
(2, '2024-01-14', '2026-01-14'),
(4, '2023-08-21', '2024-09-21'),
(1, '2022-01-14', '2025-01-14'),
(2, '2024-06-23', '2024-07-29'),
(3, '2024-02-10', '2024-06-10');

// insert project_worker
INSERT INTO project_worker (project_id, worker_id)
VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(4, 6),
(4, 1),
(4, 7),
(4, 9),
(5, 1),
(5, 3),
(5, 7),
(5, 8),
(5, 10),
(6, 5),
(6, 11),
(7, 1),
(7, 3),
(7, 9),
(8, 2),
(8, 6),
(9, 5),
(10, 7);
