WITH A AS (SELECT P.MEMBER_ID, P.MEMBER_NAME
FROM MEMBER_PROFILE P JOIN REST_REVIEW R
ON P.MEMBER_ID = R.MEMBER_ID
GROUP BY P.MEMBER_ID
ORDER BY COUNT(R.REVIEW_ID) DESC LIMIT 1
)


SELECT A.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d')
FROM A JOIN REST_REVIEW R ON A.MEMBER_ID = R.MEMBER_ID
ORDER BY REVIEW_DATE, REVIEW_TEXT

