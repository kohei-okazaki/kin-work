#-*- coding:utf-8 -*-
'''
Created on 2019/10/27
勤怠登録画面のテスト

@since 1.0.0

'''
from time import sleep

from selenium import webdriver
from selenium.webdriver.support.ui import Select

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
log.write("AttendTest開始")

# Driverパスを設定する
driver = webdriver.Chrome(ConstData.SELENIUM_DRIVER_PATH)

# 正しいログイン情報でログイン
loginId = "test"
password= "test"
result = toLogin(driver, loginId, password)

# 勤怠登録画面へ遷移
driver.find_element_by_link_text(u"勤怠登録").click()

# selectボックス-年を変更する
tag = driver.find_element_by_id('elemet-id')

log.write("AttendTestt終了")

''' ここまでメイン処理 '''
