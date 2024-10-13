WITH WorkerSalaries AS (
    SELECT
        pw.project_id,
        SUM(w.salary) AS total_salary
    FROM project_worker pw
    JOIN worker w ON pw.worker_id = w.id
    GROUP BY pw.project_id
),
ProjectDurations AS (
    SELECT
        p.ID AS project_id,
        TIMESTAMPDIFF(MONTH, p.start_date, p.finish_date) AS duration_months
    FROM project p
),
Price AS (
    SELECT
        ps.project_id,
        ps.total_salary,
        pd.duration_months,
        ps.total_salary * pd.duration_months AS price
    FROM WorkerSalaries ps
    JOIN ProjectDurations pd ON ps.project_id = pd.project_id
)
SELECT
    p.ID AS project_id,
    pc.price
FROM project p
JOIN price pc ON p.ID = pc.project_id
ORDER BY pc.price DESC;
