#-*- coding:utf-8 -*-
'''
Created on 2019/10/27
勤怠登録画面のテスト

@since 1.0.0

'''
import datetime
from time import sleep

from selenium import webdriver
from selenium.webdriver.support.ui import Select

from src.main.python.common import ConstData
from src.main.python.common import Logger
from src.main.python.common import LoginAuth

def testSelectList(driver):

    # システム日時を取得
    sysdate = datetime.date.today()
    sysdateYear = sysdate.year
    # selectボックス-年を変更する(先頭から最後まで)
    yearEelement = driver.find_element_by_name('year')
    yearEelementSelected = Select(yearEelement)
    for i in range(0, 10):
        sleep(1)
        yearEelementSelected.select_by_value(str(sysdateYear + i))

def testMonthList(driver):
    # selectボックス-月を変更する(先頭から最後まで)
    monthEelement = driver.find_element_by_name('month')
    monthList = [1, 2, 3, 4, 5, 6, 7, 8 , 9, 10, 11, 12]
    monthEelementSelected = Select(monthEelement)
    for month in monthList:
        sleep(1)
        monthEelementSelected.select_by_value(str(month))

''' ここからメイン処理 '''
log = Logger.Logger("auto.log")
log.write("AttendTest開始")

# Driverパスを設定する
driver = webdriver.Chrome(ConstData.SELENIUM_DRIVER_PATH)

# 正しいログイン情報でログイン
loginId = "test"
password= "test"
LoginAuth.LoginAuth(driver, loginId, password).login()

# 勤怠登録画面へ遷移
driver.find_element_by_link_text(u"勤怠登録").click()

# セレクトリスト(年)のテストを行う
testSelectList(driver)

# セレクトリスト(月)のテストを行う
testMonthList(driver)

log.write("AttendTest終了")

''' ここまでメイン処理 '''
