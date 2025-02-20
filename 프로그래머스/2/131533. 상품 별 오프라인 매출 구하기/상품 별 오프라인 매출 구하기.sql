SELECT P.PRODUCT_CODE, SUM(P.PRICE * S.SALES_AMOUNT) AS SALES
FROM PRODUCT P
JOIN OFFLINE_SALE S USING(PRODUCT_ID)
GROUP BY P.PRODUCT_ID
ORDER BY SALES DESC, P.PRODUCT_CODE