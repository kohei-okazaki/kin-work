var table = [
  {
    physicalName: "LOGIN_USER_DATA",
    logicalName: "ログインユーザ情報",
    column : [
      {
        logicalName: "ログインID",
        physicalName: "LOGIN_ID",
        type: "VARCHAR",
        size: "16"
      },
      {
        logicalName: "ユーザID",
        physicalName: "USER_ID",
        type: "VARCHAR",
        size: "16"
      },
      {
        logicalName: "ユーザ名",
        physicalName: "USER_NAME",
        type: "VARCHAR",
        size: "16"
      },
      {
        logicalName: "パスワード",
        physicalName: "PASSWORD",
        type: "VARCHAR",
        size: "16"
      },
      {
        logicalName: "パスワード有効期限",
        physicalName: "PASSWORD_EXPIRE",
        type: "DATE",
        size: ""
      },
      {
        logicalName: "ユーザ権限",
        physicalName: "USER_AUTH",
        type: "VARCHAR",
        size: "1"
      },
      {
        logicalName: "アカウントロックフラグ",
        physicalName: "ACCOUNT_LOCK_FLG",
        type: "VARCHAR",
        size: "1"
      },
      {
        logicalName: "ログイン失敗回数",
        physicalName: "LOGIN_FAIL_COUNT",
        type: "INT",
        size: ""
      },
      {
        logicalName: "登録日時",
        physicalName: "REG_DATE",
        type: "TIMESTAMP",
        size: ""
      },
      {
        logicalName: "更新日時",
        physicalName: "UPDATE_DATE",
        type: "TIMESTAMP",
        size: ""
      }
    ]
  },
  {
    physicalName: "USER_BASE_DATA",
    logicalName: "ユーザ基本情報",
    column : [
      {
        logicalName: "ユーザID",
        physicalName: "USER_ID",
        type: "VARCHAR",
        size: "16"
      },
      {
        logicalName: "企業コード",
        physicalName: "COMPANY_CODE",
        type: "VARCHAR",
        size: "5"
      },
      {
        logicalName: "登録日時",
        physicalName: "REG_DATE",
        type: "TIMESTAMP",
        size: ""
      },
      {
        logicalName: "更新日時",
        physicalName: "UPDATE_DATE",
        type: "TIMESTAMP",
        size: ""
      }
    ]
  },
  {
    physicalName: "ONTIME_MT",
    logicalName: "定時情報マスタ",
    column : [
      {
        logicalName: "企業コード",
        physicalName: "COMPANY_CODE",
        type: "VARCHAR",
        size: "5"
      },
      {
        logicalName: "始業時間(時)",
        physicalName: "WORK_START_HOUR",
        type: "VARCHAR",
        size: "2"
      },
      {
        logicalName: "始業時間(分)",
        physicalName: "WORK_START_MINUTE",
        type: "VARCHAR",
        size: "2"
      },
      {
        logicalName: "終業時間(時)",
        physicalName: "WORK_END_HOUR",
        type: "VARCHAR",
        size: "2"
      },
      {
        logicalName: "終業時間(分)",
        physicalName: "WORK_END_MINUTE",
        type: "VARCHAR",
        size: "2"
      },
      {
        logicalName: "登録日時",
        physicalName: "REG_DATE",
        type: "TIMESTAMP",
        size: ""
      },
      {
        logicalName: "更新日時",
        physicalName: "UPDATE_DATE",
        type: "TIMESTAMP",
        size: ""
      }
    ]
  }
];

// 指定したテーブル名のカラム情報をすべて取得する
function getColumnList(tableName) {
  for (var i = 0; i < table.length; i++) {
    var tableData = table[i];
    if (tableData.physicalName === tableName) {
      return tableData.column;
    }
  }
}
