# -*- coding:utf-8 -*-
'''
Created on 2019/10/20
Login画面→ログイン後のTOP画面のテストを行うpython

@since 1.0.0

'''

from selenium import webdriver

from src.main.python.common import ConstData
from src.main.python.common import Logger
from src.main.python.login import LoginAuth

''' ここからメイン処理 '''

log = Logger.Logger("auto.log")
log.write("LoginTest開始")

# driverを取得
driver = webdriver.Chrome(ConstData.SELENIUM_DRIVER_PATH)

# 正しいログイン情報でログイン
loginId = "test"
password = "test"
LoginAuth.LoginAuth(driver, loginId, password).doLogin()

# ブラウザバック
driver.back()

# 正しくないパスワードでログイン
loginId = "test"
password = "hoge"
LoginAuth.LoginAuth(driver, loginId, password).doLogin()

log.write("LoginTest終了")

''' ここまでメイン処理 '''
