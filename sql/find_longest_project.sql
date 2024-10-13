WITH ProjectCounts AS (
    SELECT
        id,
        client_id,
        start_date,
        finish_date,
        TIMESTAMPDIFF(MONTH, start_date, finish_date) AS month_count
    FROM project
),
MaxDuration AS (
    SELECT MAX(month_count) AS max_count
    FROM ProjectCounts
)
SELECT
    id,
   month_count
FROM ProjectCounts
WHERE month_count = (SELECT max_count FROM MaxDuration);
