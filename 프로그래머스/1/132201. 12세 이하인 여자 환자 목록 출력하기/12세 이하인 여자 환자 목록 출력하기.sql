SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE 12 >= AGE AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC