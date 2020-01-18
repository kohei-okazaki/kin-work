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
from src.main.python.common import LoginAuth

''' ここからメイン処理 '''
log = Logger.Logger("auto.log")
log.write("AttendTest開始")

# Driverパスを設定する
driver = webdriver.Chrome(ConstData.SELENIUM_DRIVER_PATH)

# 正しいログイン情報でログイン
loginId = "test"
password= "test"
loginAuth = LoginAuth.LoginAuth(driver, loginId, password)
result = loginAuth.login()

# 勤怠登録画面へ遷移
driver.find_element_by_link_text(u"勤怠登録").click()

# selectボックス-年を変更する(初期値->2021->2022)
yearEelement = driver.find_element_by_name('year')
yearEelementSelected = Select(yearEelement)
yearEelementSelected.select_by_value('2021')
sleep(1)
yearEelementSelected.select_by_value('2022')
sleep(1)

log.write("AttendTest終了")

''' ここまでメイン処理 '''
