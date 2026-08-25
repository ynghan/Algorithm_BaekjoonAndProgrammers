SELECT CAR_ID,
        CASE
            WHEN COUNT(*) = COUNT(
                CASE
                    WHEN START_DATE > TO_DATE('2022-10-16', 'YYYY-MM-DD')
                    OR END_DATE < TO_DATE('2022-10-16', 'YYYY-MM-DD')
                    THEN 1
                END
            )
            THEN '대여 가능'
            ELSE '대여중'
        END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;