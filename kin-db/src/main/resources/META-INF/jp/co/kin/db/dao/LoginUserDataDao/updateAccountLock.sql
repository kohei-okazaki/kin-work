UPDATE LOGIN_USER_DATA
SET
  LOGIN_FAIL_COUNT = /* entity.loginFailCount */'1',
  ACCOUNT_LOCK_FLG = /* entity.accountLockFlg */'1'
WHERE
  LOGIN_ID = /* entity.loginId */'1'