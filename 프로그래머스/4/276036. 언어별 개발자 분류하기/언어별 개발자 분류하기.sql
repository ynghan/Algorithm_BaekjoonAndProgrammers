SELECT
    CASE
        WHEN EXISTS (
            SELECT 1
            FROM SKILLCODES S
            WHERE S.CATEGORY = 'Front End'
              AND (D.SKILL_CODE & S.CODE) > 0
        )
        AND EXISTS (
            SELECT 1
            FROM SKILLCODES S
            WHERE S.NAME = 'Python'
              AND (D.SKILL_CODE & S.CODE) > 0
        )
        THEN 'A'

        WHEN EXISTS (
            SELECT 1
            FROM SKILLCODES S
            WHERE S.NAME = 'C#'
              AND (D.SKILL_CODE & S.CODE) > 0
        )
        THEN 'B'

        WHEN EXISTS (
            SELECT 1
            FROM SKILLCODES S
            WHERE S.CATEGORY = 'Front End'
              AND (D.SKILL_CODE & S.CODE) > 0
        )
        THEN 'C'
    END AS GRADE,
    D.ID,
    D.EMAIL
FROM DEVELOPERS D
WHERE
    EXISTS (
        SELECT 1
        FROM SKILLCODES S
        WHERE S.CATEGORY = 'Front End'
          AND (D.SKILL_CODE & S.CODE) > 0
    )
    OR EXISTS (
        SELECT 1
        FROM SKILLCODES S
        WHERE S.NAME = 'C#'
          AND (D.SKILL_CODE & S.CODE) > 0
    )
ORDER BY GRADE, D.ID;