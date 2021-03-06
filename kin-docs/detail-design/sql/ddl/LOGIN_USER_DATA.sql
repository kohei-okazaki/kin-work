-- ログインユーザ情報
CREATE TABLE LOGIN_USER_DATA (
-- ログインID
LOGIN_ID VARCHAR(16) NOT NULL PRIMARY KEY,
-- ユーザID
USER_ID VARCHAR(16),
-- ユーザ名
USER_NAME VARCHAR(16),
-- パスワード
PASSWORD VARBINARY(64),
-- パスワード有効期限
PASSWORD_EXPIRE DATE,
-- ユーザ権限
USER_AUTH VARCHAR(1),
-- アカウントロックフラグ
ACCOUNT_LOCK_FLG VARCHAR(1),
-- ログイン失敗回数
LOGIN_FAIL_COUNT INT,
-- 登録日時
REG_DATE TIMESTAMP,
-- 更新日時
UPDATE_DATE TIMESTAMP
);
