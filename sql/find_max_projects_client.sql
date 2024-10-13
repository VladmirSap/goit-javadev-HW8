WITH ProjectCounts AS (
    SELECT
        c.id AS client_id,
        c.name AS client_name,
        COUNT(p.id) AS project_count
    FROM client c
    LEFT JOIN project p ON c.id = p.client_id
    GROUP BY c.id, c.name
),
MaxProjectCount AS (
    SELECT MAX(project_count) AS max_count
    FROM ProjectCounts
)
SELECT
    client_name AS NAME,
    project_count AS PROJECT_COUNT
FROM ProjectCounts
WHERE project_count = (SELECT max_count FROM MaxProjectCount);
