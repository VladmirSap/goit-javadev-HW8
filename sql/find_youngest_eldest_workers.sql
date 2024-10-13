WITH Youngest AS (
    SELECT
        name,
        birthday
    FROM worker
    WHERE birthday = (SELECT MAX(birthday) FROM worker)
),
Oldest AS (
    SELECT
        name,
        birthday
    FROM worker
    WHERE birthday = (SELECT MIN(birthday) FROM worker)
)
SELECT
    'YOUNGEST' AS TYPE,
    name,
    birthday
FROM Youngest
UNION ALL
SELECT
    'ELDEST' AS TYPE,
    name,
    birthday
FROM Oldest;