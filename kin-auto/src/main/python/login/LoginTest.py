#-*- coding:utf-8 -*-
'''
Created on 2019/10/20
Login画面→ログイン後のTOP画面のテストを行うpython

@since 1.0.0

'''

from time import sleep

from selenium import webdriver

from src.main.python.common import ConstData
from src.main.python.common import Logger

# 指定したログインIDとパスワードでログインを行う
def toLogin(driver, loginId, password):

    # ログイン画面を表示する
    driver.get(ConstData.BASE_REQUEST_URL + '/login/index')

    # ログイン画面 - loginIdを設定
    loginIdElement = driver.find_element_by_id("loginId")
    loginIdElement.send_keys(loginId)

    # ログイン画面 - passwordを設定
    passwordElement = driver.find_element_by_id("password")
    passwordElement.send_keys(password)

    # 読み込みを待つために2秒間処理を止める
    sleep(2)

    # ログインボタン押下し、TOP画面へ遷移
    submitButton = driver.find_element_by_id("submit")
    submitButton.click()

    # 読み込みを待つために2秒間処理を止める
    sleep(2)

''' ここからメイン処理 '''

log = Logger.Logger("auto.log")
log.write("LoginTest開始")

# driverを取得
driver = webdriver.Chrome(ConstData.SELENIUM_DRIVER_PATH)

# 正しいログイン情報でログイン
loginId = "test"
password= "test"
result = toLogin(driver, loginId, password)

# ブラウザバック
driver.back()

loginId = "test"
password= "hoge"
result = toLogin(driver, loginId, password)

log.write("LoginTest修正")

''' ここまでメイン処理 '''
