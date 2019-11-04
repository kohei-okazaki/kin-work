#-*- coding:utf-8 -*-
'''
Created on 2019/10/27
勤怠登録画面のテスト

@since 1.0.0

'''
from time import sleep
from selenium import webdriver
from src.main.python.common import ConstData

# Driverパスを設定する
driver = webdriver.Chrome(ConstData.SELENIUM_DRIVER_PATH)

# ログインを行う
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

# 勤怠登録画面へ遷移
driver.find_element_by_link_text(u"勤怠登録").click()

