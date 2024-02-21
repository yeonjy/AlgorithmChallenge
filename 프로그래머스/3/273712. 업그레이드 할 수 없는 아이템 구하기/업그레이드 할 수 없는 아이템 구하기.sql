SELECT II.ITEM_ID, II.ITEM_NAME, II.RARITY
FROM ITEM_INFO AS II LEFT JOIN ITEM_TREE AS IT
ON II.ITEM_ID = IT.PARENT_ITEM_ID
WHERE IT.ITEM_ID IS NULL
ORDER BY II.ITEM_ID DESC