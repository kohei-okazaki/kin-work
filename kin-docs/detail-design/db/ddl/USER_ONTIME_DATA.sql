-- ユーザ定時情報
CREATE TABLE USER_ONTIME_DATA (
-- ログインID
LOGIN_ID VARCHAR(16) NOT NULL PRIMARY KEY,
-- 始業時間(時)
WORK_START_TIME_HOUR VARCHAR(2),
-- 始業時間(分)
WORK_START_TIME_MINUTE VARCHAR(2),
-- 終業時間(時)
WORK_END_TIME_HOUR VARCHAR(2),
-- 終業時間(分)
WORK_END_TIME_MINUTE VARCHAR(2),
-- 登録日時
REG_DATE TIMESTAMP,
-- 更新日時
UPDATE_DATE TIMESTAMP
);