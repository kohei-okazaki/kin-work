SELECT
  *
FROM
  DAILY_USER_WORK_DATA
WHERE
  WORK_DATA_REG_DATE BETWEEN /* workStartDate */'2019/01/01' AND /* workEndDate */'2019/01/02'
    AND
  USER_ID = /* userId */'test'
