'''
Created on 2019/10/20
Login画面→ログイン後のTOP画面のテストを行うpython

@since 1.0.0

'''
from time import sleep

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from src.main.python.common import ConstData

# Driverパスを設定する
driver = webdriver.Chrome(ConstData.SELENIUM_DRIVER_PATH)

# ログイン画面を表示する
driver.get(ConstData.BASE_REQUEST_URL + '/login/index')

print("ログイン画面のURL=" + driver.current_url)

# ログイン画面 - loginIdにtestを設定
loginIdElement = driver.find_element_by_id("loginId")
loginIdElement.send_keys("test")

# ログイン画面 - passwordにtestを設定
passwordElement = driver.find_element_by_id("password")
passwordElement.send_keys("test")

# 読み込みを待つために2秒間処理を止める
sleep(2)

# ログインボタン押下し、TOP画面へ遷移
submiyButton = driver.find_element_by_id("submit")
submiyButton.click()
# 読み込みを待つために2秒間処理を止める
sleep(2)

print("TOP画面のURL=" + driver.current_url)

# TOP画面からブラウザバック
driver.back()
# 読み込みを待つために2秒間処理を止める
sleep(2)

print("ブラウザバック後のURL=" + driver.current_url)

# ログイン画面でログインボタン押下
submiyButton = driver.find_element_by_id("submit")

# 画面をclose
driver.close()
