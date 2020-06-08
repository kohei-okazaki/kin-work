# -*- coding:utf-8 -*-
'''
Created on 2019/10/20
Login画面→ログイン後のTOP画面のテストを行うpython

@since 1.0.0

'''

from selenium import webdriver

from src.main.python.common import const_data
from src.main.python.common.logger import Logger
from src.main.python.login.login_auth import LoginAuth

''' ここからメイン処理 '''

log = Logger("auto.log")
log.write("LoginTest開始")

# driverを取得
driver = webdriver.Chrome(const_data.SELENIUM_DRIVER_PATH)

# 正しいログイン情報でログイン
loginId = "test"
password = "test"
LoginAuth(driver, loginId, password).doLogin()

# ブラウザバック
driver.back()

# 正しくないパスワードでログイン
loginId = "test"
password = "hoge"
LoginAuth(driver, loginId, password).doLogin()

log.write("LoginTest終了")

''' ここまでメイン処理 '''
